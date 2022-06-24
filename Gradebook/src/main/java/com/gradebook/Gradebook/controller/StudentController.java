package com.gradebook.Gradebook.controller;

import com.gradebook.Gradebook.config.GradebookCommon;
import com.gradebook.Gradebook.model.dto.AppUserDTO;
import com.gradebook.Gradebook.model.dto.StudentDTO;
import com.gradebook.Gradebook.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = GradebookCommon.STUDENT_BASE_URI)
public class StudentController {

    @Autowired
    private final IStudentService studentService;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping(path = "/all")
    public List<StudentDTO> getStudents() {
        return studentService.getAllStudent();
    }

    @GetMapping(path = "/{id}")
    public StudentDTO getStudentById(@PathVariable("id") Long id) {
        return new StudentDTO(Long.valueOf(1), "PATCH", "PATCH", "PATCH", "PATCH");
    }

    @PatchMapping(path = "/{id}")
    public StudentDTO updateStudentById(@PathVariable("id") Long id, @RequestBody AppUserDTO payload) {
        return new StudentDTO(Long.valueOf(1), "PATCH", "PATCH", "PATCH", "PATCH");
    }

    @DeleteMapping(path = "/{id}")
    public void deleteStudentById(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
    }

    //TODO
    //getAllGradesByStudentId(Long id)
    //getAllGradesByStudentsId(List<Long>ids)
    //getAllAbsencesByStudentId(Long id)
    //getAllAbsencesByStudentsId(List<Long> ids)
    //assignToSchoolClass()


}
