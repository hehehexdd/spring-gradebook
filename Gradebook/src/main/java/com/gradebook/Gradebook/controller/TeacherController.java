package com.gradebook.Gradebook.controller;


import com.gradebook.Gradebook.config.GradebookCommon;

import com.gradebook.Gradebook.model.dto.*;
import com.gradebook.Gradebook.service.IGradeService;
import com.gradebook.Gradebook.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4202")
@RestController
@RequestMapping(path = GradebookCommon.TEACHER_BASE_URI)
public class TeacherController {

    @Autowired
    private final ITeacherService teacherService;

    @Autowired
    private final IGradeService gradeService;

    public TeacherController(ITeacherService teacherService, IGradeService gradeService) {
        this.teacherService = teacherService;
        this.gradeService = gradeService;
    }

    @GetMapping
    public List<TeacherDTO> getAllTeachers(@RequestParam(required = false) Long schoolId) {
        return this.teacherService.getAll(schoolId);
    }

    @GetMapping(path = "/{id}")
    public TeacherDTO getTeacherById(@PathVariable("id") Long id) {
        return this.teacherService.getById(id);
    }

    @GetMapping(path = "/{teacherId}/grades")
    public List<GradeDTO> getAllTeacherGrades(@PathVariable("teacherId") Long teacherId) {
        return gradeService.getAllGradesByTeacherId(teacherId);
    }

    @GetMapping(path = "/{id}/courses")
    public List<SubjectDTO> getCourses(@PathVariable("id") Long id) {
        return this.teacherService.getCourses(id);
    }

    @GetMapping(path = "/{id}/students")
    public List<StudentDTO> getStudents(@PathVariable("id") Long id) {
        return this.teacherService.getStudents(id);
    }

    @PatchMapping(path = "/{id}")
    public TeacherDTO updateTeacherById(@PathVariable("id") Long id, @RequestBody(required=false) TeacherDTO payload) {
        return this.teacherService.update(id,payload);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createTeacher(@RequestBody RegisterDTO payload) {
        this.teacherService.createTeacher(payload);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTeacherById(@PathVariable("id") Long id) {
        this.teacherService.delete(id);
    }
}
