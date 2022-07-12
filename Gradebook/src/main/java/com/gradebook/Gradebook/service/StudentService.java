package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.dto.GradeDTO;
import com.gradebook.Gradebook.model.dto.RegisterDTO;
import com.gradebook.Gradebook.model.dto.StudentDTO;
import com.gradebook.Gradebook.model.dto.TeacherDTO;
import com.gradebook.Gradebook.model.entity.*;
import com.gradebook.Gradebook.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentService implements IStudentService{

    @Autowired
    private final StudentRepo studentRepo;

    @Autowired
    private final ISchoolService schoolService;

    @Autowired
    private final ISchoolClassService schoolClassService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public StudentService(StudentRepo studentRepo, ISchoolService schoolService, ISchoolClassService schoolClassService) {
        this.studentRepo = studentRepo;
        this.schoolService = schoolService;
        this.schoolClassService = schoolClassService;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public void createStudent(RegisterDTO payload) {
        Student s = new Student(
                payload.getUsername(),
                payload.getEmail(),
                passwordEncoder.encode(payload.getPassword()),
                true,
                payload.getFirstName(),
                payload.getLastName(),
                schoolService.findById(payload.getSchoolId()),
                schoolClassService.findById(payload.getClassId()),
                RoleType.STUDENT,
                schoolClassService.findById(payload.getClassId()).getClassYear());
        this.saveStudent(s);
    }

    @Override
    public void updateStudent(Student student) {
        if(student != null) {
            Student tmp;
            tmp = studentRepo.getById(student.getId());
            tmp.setFirstName(student.getFirstName());
            tmp.setLastName(student.getLastName());
            tmp.setSchool(student.getSchool());
            tmp.setAbsences(student.getAbsences());
            tmp.setGrades(student.getGrades());
            tmp.setParents(student.getParents());
            tmp.setSClass(student.getSClass());
            studentRepo.save(tmp);
        }
    }

    @Override
    public StudentDTO update(Long id, StudentDTO payload) {
        Student student = this.findById(id);

        if(payload == null){
            return this.convertToDTO(student);
        }
        if(payload.getFirstName()!= null){
            student.setFirstName(payload.getFirstName());
        }
        if(payload.getLastName()!= null){
            student.setLastName(payload.getLastName());
        }
        if(payload.getSclassId() != null) {
            student.setSchoolClass(schoolClassService.findById(payload.getSclassId()));
            student.setSClass(schoolClassService.findById(payload.getSclassId()).getClassYear());
        }
        this.studentRepo.save(student);
        return this.convertToDTO(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }

    @Override
    public StudentDTO getById(Long id) {
        return this.convertToDTO(studentRepo.getById(id));
    }

    @Override
    public Student findById(Long id) {
        return studentRepo.getById(id);
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepo.findAll()
                .stream().map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> getAllStudentsByClassId(Long classId) {
        return this.studentRepo.getAllBySchoolClass_Id(classId)
                .stream().map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> getAllStudentsByClassIds(List<Long> classIds) {
        return this.studentRepo.getAllBySchoolClass_Ids(classIds)
                .stream().map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO convertToDTO(Student student) {
        StudentDTO studentDTO = new StudentDTO();

        if (student != null) {
            studentDTO.setId(student.getId());
            studentDTO.setFirstName(student.getFirstName());
            studentDTO.setLastName(student.getLastName());
            studentDTO.setSchoolName(student.getSchool().getName());
            studentDTO.setSchoolClass(student.getSchoolClass().getName());
            studentDTO.setSclassId(student.getSchoolClass().getId());
        }

        return studentDTO;
    }

    @Override
    public List<StudentDTO> getAllStudentsBySchoolId(Long schoolId) {
        return studentRepo.getAllBySchool_Id(schoolId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
