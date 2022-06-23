package com.gradebook.Gradebook.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.gradebook.Gradebook.config.GradebookCommon;

import com.gradebook.Gradebook.model.dto.TeacherCourcesDTO;
import com.gradebook.Gradebook.model.dto.TeacherDTO;
import com.gradebook.Gradebook.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = GradebookCommon.TEACHER_BASE_URI)
public class TeacherController {

    @Autowired
    private final ITeacherService teacherService;

    public TeacherController(ITeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<TeacherDTO> getAllTeachers(@RequestParam(required = false) Long schoolId) {
        return this.teacherService.getAll(schoolId);
    }

    @GetMapping(path = "/{id}")
    public TeacherDTO getTeacherById(@PathVariable("id") Long id) {
        return this.teacherService.getById(id);
    }

    @GetMapping(path = "/{id}/courses")
    public List<TeacherCourcesDTO> getCourses(@PathVariable("id") Long id) {
        return this.teacherService.getCourses(id);
    }


    //To-do
    @PatchMapping(path = "/{id}")
    public TeacherDTO updateTeacherById(@PathVariable("id") Long id, @RequestBody TeacherDTO payload) {
        return new TeacherDTO(Long.valueOf(1), "Ivan", "Petrov","123", Long.valueOf(1));
    }

    //To-do
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public TeacherDTO createTeacher(@RequestBody TeacherDTO payload) {
        return new TeacherDTO(Long.valueOf(1), "Ivan", "Petrov","123", Long.valueOf(1));
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTeacherById(@PathVariable("id") Long id) {
        this.teacherService.delete(id);
    }
}
