package com.gradebook.Gradebook.controller;


import com.gradebook.Gradebook.config.GradebookCommon;
import com.gradebook.Gradebook.model.dto.AppUserDTO;
import com.gradebook.Gradebook.model.dto.GradeDTO;
import com.gradebook.Gradebook.service.IGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = GradebookCommon.GRADE_BASE_URI)
public class GradeController {

    @Autowired
    private final IGradeService gradeService;

    public GradeController(IGradeService gradeService) {
        this.gradeService = gradeService;
    }

    @GetMapping(path = "/all")
    public List<GradeDTO> getAllGrades() {
        return gradeService.getAllGrades();
    }

    @GetMapping(path = "/{id}")
    public GradeDTO getAllGradesByStudentID(@PathVariable("id") Long id) {
        return new GradeDTO(
                Long.valueOf(1),
                "GET_GRADE",
                Integer.valueOf(5),
                Long.valueOf(1),
                Long.valueOf(2),
                LocalDate.now());
    }

    @GetMapping(path = "/{studentIds}")
    public List<GradeDTO> getAllGradesByStudentIds(@PathVariable("studentIds") List<Long> studentIds) {
        GradeDTO grade = new GradeDTO(
                Long.valueOf(1),
                "POST_GRADE",
                Integer.valueOf(5),
                Long.valueOf(1),
                Long.valueOf(2),
                LocalDate.now());
        List<GradeDTO> grades;
        return null;
    }

    @PostMapping(path = "{studentId}")
    public GradeDTO createGrade(@PathVariable("studentId") Long id) {
        return new GradeDTO(
                Long.valueOf(1),
                "POST_GRADE",
                Integer.valueOf(5),
                Long.valueOf(1),
                Long.valueOf(2),
                LocalDate.now());
    }

    @PatchMapping(path = "/{id}")
    public GradeDTO updateGradeById(@PathVariable("id") Long id, @RequestBody GradeDTO payload) {
        return new GradeDTO(
                Long.valueOf(1),
                "PATCH_GRADE",
                Integer.valueOf(5),
                Long.valueOf(1),
                Long.valueOf(2),
                LocalDate.now());
    }

    @DeleteMapping(path = "/{id}")
    public void deleteAppUserById(@PathVariable("id") Long id) {
        gradeService.deleteGrade(id);
    }
}
