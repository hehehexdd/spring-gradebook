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
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4202")
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
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody RegisterDTO payload) {
       this.studentService.createStudent(payload);
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
        Student s = studentService.findById(id);
        return studentService.convertToDTO(s);
    }

    @PatchMapping(path = "/{id}")
    public StudentDTO updateStudentById(@PathVariable("id") Long id, @RequestBody StudentDTO payload) {
        return studentService.update(id, payload);
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
