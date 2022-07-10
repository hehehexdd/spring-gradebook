package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.dto.GradeDTO;
import com.gradebook.Gradebook.model.dto.RegisterDTO;
import com.gradebook.Gradebook.model.dto.TeacherCourcesDTO;
import com.gradebook.Gradebook.model.dto.TeacherDTO;
import com.gradebook.Gradebook.model.entity.RoleType;
import com.gradebook.Gradebook.model.entity.School;
import com.gradebook.Gradebook.model.entity.Student;
import com.gradebook.Gradebook.model.entity.Teacher;
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
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SchoolService schoolService;

    public TeacherService(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    @Override
    public void createTeacher(RegisterDTO user) {
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
        Teacher teacher = this.teacherRepo.getById(id);
        this.teacherRepo.delete(teacher);
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
    public List<TeacherCourcesDTO> getCourses(Long id) {
        List<TeacherCourcesDTO> courses= new ArrayList<>();
        //to add logic
        courses.add(new TeacherCourcesDTO(id,"Physics 4th Grade", 5L));
        courses.add(new TeacherCourcesDTO(id,"Mathematics 7th Grade", 4L));

        return courses;
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
