package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.dto.*;
import com.gradebook.Gradebook.model.entity.*;
import com.gradebook.Gradebook.repo.ClassTeacherRepo;
import com.gradebook.Gradebook.repo.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Transactional
@Service
public class TeacherService implements ITeacherService{
    @Autowired
    private final TeacherRepo teacherRepo;

    @Autowired
    private final ClassTeacherRepo classTeacherRepo;

    @Autowired
    private final IStudentService studentService;

    @Autowired
    private final ISubjectService subjectService;

    @Autowired
    private final ISchoolService schoolService;

    @Autowired
    private final PasswordEncoder passwordEncoder;



    public TeacherService(TeacherRepo teacherRepo, ClassTeacherRepo classTeacherRepo, IStudentService studentService, ISubjectService subjectService, ISchoolService schoolService, PasswordEncoder passwordEncoder) {
        this.teacherRepo = teacherRepo;
        this.classTeacherRepo = classTeacherRepo;
        this.studentService = studentService;
        this.subjectService = subjectService;
        this.schoolService = schoolService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public TeacherDTO createTeacher(RegisterDTO user) {
        Long schoolId = user.getSchoolId();

        School school = schoolService.findById(schoolId);

        Teacher teacher = new Teacher(
                user.getUsername(),
                user.getEmail(),
                this.passwordEncoder.encode(user.getPassword()),
                RoleType.TEACHER,
                true,
                user.getFirstName(),
                user.getLastName(),
                school
                );

        this.teacherRepo.save(teacher);
        return this.convertToDTO(teacher);
    }

    @Override
    public TeacherDTO update(Long id, TeacherDTO payload) {
        Teacher teacher = this.findById(id);

        if(payload == null){
            return this.convertToDTO(teacher);
        }
        if(payload.getFirstName()!= null){
            teacher.setFirstName(payload.getFirstName());
        }
        if(payload.getLastName()!= null){
            teacher.setLastName(payload.getLastName());
        }
        if(payload.getSchoolId()!= null) {
            School school = this.schoolService.findById(payload.getSchoolId());
            teacher.setSchool(school);
        }
        this.teacherRepo.save(teacher);
        return this.convertToDTO(teacher);
    }

    @Override
    public void delete(Long id) {
        teacherRepo.deleteById(id);
    }

    @Override
    public TeacherDTO getById(Long id) {
        Teacher teacher = this.teacherRepo.getById(id);
        return this.convertToDTO(teacher);
    }

    @Override
    public Teacher findById(Long id) {
        return teacherRepo.getById(id);
    }

    @Override
    public List<TeacherDTO> getAll(Long schoolId) {
        if (schoolId != null) {
            return teacherRepo.findAllBySchool_Id(schoolId)
                    .stream().map(this::convertToDTO)
                    .collect(Collectors.toList());
        }

        return teacherRepo.findAll()
                .stream().map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<SubjectDTO> getCourses(Long id) {
        List<ClassTeachers> tmp = this.classTeacherRepo.getAllByTeacher_Id(id);
        List<Long> courseIds = new ArrayList<>();
        tmp.forEach(classTeacher -> {
            Long courseId = classTeacher.getSubject().getId();
            if(!courseIds.contains(courseId)){
                courseIds.add(courseId);
            }
        });

        return this.subjectService.getSubjectsByIds(courseIds);
    }

    @Override
    public List<StudentDTO> getStudents(Long id) {
        List<ClassTeachers> tmp = this.classTeacherRepo.getAllByTeacher_Id(id);
        List<Long> classIds = new ArrayList<>();
        tmp.forEach(classTeacher -> {
                Long classId = classTeacher.getStudentClass().getId();
                if(!classIds.contains(classId)){
                    classIds.add(classId);
                }
        });


        return this.studentService.getAllStudentsByClassIds(classIds);
    }

    @Override
    public List<TeacherDTO> getAllBySchoolId(Long id) {
        return teacherRepo.findAllBySchool_Id(id)
                .stream().map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TeacherDTO convertToDTO(Teacher teacher) {
        TeacherDTO teacherDTO = new TeacherDTO();

        if (teacher != null) {
            teacherDTO.setId(teacher.getId());
            teacherDTO.setUsername(teacher.getUsername());
            teacherDTO.setFirstName(teacher.getFirstName());
            teacherDTO.setLastName(teacher.getLastName());
            teacherDTO.setUsername(teacher.getUsername());
            teacherDTO.setSchoolId((teacher.getSchool() != null) ? teacher.getSchool().getId() : null);
        }
        return teacherDTO;
    }
}
