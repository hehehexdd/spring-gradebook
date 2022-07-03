package com.gradebook.Gradebook.controller;

import com.gradebook.Gradebook.config.GradebookCommon;
import com.gradebook.Gradebook.model.dto.AppUserDTO;
import com.gradebook.Gradebook.model.dto.RegisterDTO;
import com.gradebook.Gradebook.model.dto.StudentDTO;
import com.gradebook.Gradebook.model.entity.RoleType;
import com.gradebook.Gradebook.model.entity.SClass;
import com.gradebook.Gradebook.model.entity.Student;
import com.gradebook.Gradebook.service.IAppUserService;
import com.gradebook.Gradebook.service.ISchoolClassService;
import com.gradebook.Gradebook.service.ISchoolService;
import com.gradebook.Gradebook.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = GradebookCommon.STUDENT_BASE_URI)
public class StudentController {

    @Autowired
    private final IStudentService studentService;

    @Autowired
    private final ISchoolService schoolService;

    @Autowired
    private final ISchoolClassService schoolClassService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public StudentController(IStudentService studentService, ISchoolService schoolService, ISchoolClassService schoolClassService) {
        this.studentService = studentService;
        this.schoolService = schoolService;
        this.schoolClassService = schoolClassService;
    }

    @PostMapping
    public void createStudent(@RequestBody RegisterDTO payload) {
        Student s = new Student(
                payload.getUsername(),
                payload.getEmail(),
                passwordEncoder.encode(payload.getPassword()),
                payload.isAccountLocked(),
                payload.getFirstName(),
                payload.getLastName(),
                schoolService.findById(payload.getSchoolId()),
                schoolClassService.findById(payload.getClassId()),
                RoleType.STUDENT,
                SClass.FIFTH);
        studentService.saveStudent(s);
    }

    @GetMapping(path = "/all")
    public List<StudentDTO> getAll() {
        return studentService.getAllStudents();
    }

    @GetMapping(path = "/all/{schoolId}")
    public List<StudentDTO> getStudentsBySchoolId(@PathVariable("schoolId") Long id) {
        return studentService.getAllStudentsBySchoolId(id);
    }

    @GetMapping(path = "/{id}")
    public StudentDTO getStudentById(@PathVariable("id") Long id) {
        //return new StudentDTO(Long.valueOf(1), "PATCH", "PATCH", "PATCH", "PATCH");
        Student s = studentService.findById(id);
        return studentService.convertToDTO(s);
    }

    @PatchMapping(path = "/{id}")
    public StudentDTO updateStudentById(@PathVariable("id") Long id, @RequestBody StudentDTO payload) {
        //return new StudentDTO(Long.valueOf(1), "PATCH", "PATCH", "PATCH", "PATCH");
        Student tmp = studentService.findById(id);
        tmp.setFirstName(payload.getFirstName());
        tmp.setLastName(payload.getLastName());
        return studentService.convertToDTO(tmp);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteStudentById(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
    }


    @PatchMapping(path = "/{schoolId}/{studentId}")
    public void assignToSchoolClass(@PathVariable("schoolId") Long schoolId, @PathVariable("studentId") Long studentId) {
        Student tmp = studentService.findById(studentId);
        tmp.setSchool(schoolService.findById(schoolId));
        studentService.saveStudent(tmp);
    }
}
