package com.gradebook.Gradebook.controller;

import com.gradebook.Gradebook.config.GradebookCommon;
import com.gradebook.Gradebook.model.dto.ClassTeachersDTO;
import com.gradebook.Gradebook.service.IClassTeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4202")
@RestController
@RequestMapping(path = GradebookCommon.CLASS_TEACHERS_BASE_URI)
public class ClassTeachersController {

    @Autowired
    private final IClassTeachersService classTeachersService;

    public ClassTeachersController(IClassTeachersService classTeachersService) {
        this.classTeachersService = classTeachersService;
    }

    @GetMapping(path = "/all")
    public List<ClassTeachersDTO> getAllClassTechers() {
        return this.classTeachersService.getAll();
    }

    @GetMapping(path = "/{id}")
    public ClassTeachersDTO getClassTeacherById(@PathVariable("id") Long id) {
        return this.classTeachersService.getById(id);
    }

    @PostMapping
    public ClassTeachersDTO createClassTeacher(@RequestBody ClassTeachersDTO payload) {
        return this.classTeachersService.saveClassTeachers(payload);
    }

    @PatchMapping(path = "/{id}")
    public ClassTeachersDTO updateClassTeachers(@RequestBody ClassTeachersDTO payload) {
        this.classTeachersService.update(payload);
        return this.classTeachersService.convertToDTO(classTeachersService.findById(payload.getId()));
    }

    @DeleteMapping(path = "/{id}")
    public void deleteClassTeachers(@PathVariable("id") Long id) {
        this.classTeachersService.delete(id);
    }
}
