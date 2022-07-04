package com.gradebook.Gradebook.controller;

import com.gradebook.Gradebook.config.GradebookCommon;
import com.gradebook.Gradebook.model.dto.GradeDTO;
import com.gradebook.Gradebook.service.IGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4202")
@RestController
@RequestMapping(path = GradebookCommon.Subject_BASE_URI)
public class SubjectController {

    @Autowired
    private final IGradeService gradeService;

    public SubjectController(IGradeService gradeService) {
        this.gradeService = gradeService;
    }

    @GetMapping(path = "/{subjectId}/grades")
    public List<GradeDTO> subjectGrades(@PathVariable("subjectId") Long subjectId) {
        return gradeService.getAllGradesBySubjectId(subjectId);
    }

}
