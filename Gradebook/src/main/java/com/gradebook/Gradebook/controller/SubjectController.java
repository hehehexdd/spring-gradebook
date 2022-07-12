package com.gradebook.Gradebook.controller;

import com.gradebook.Gradebook.config.GradebookCommon;
import com.gradebook.Gradebook.model.dto.GradeDTO;
import com.gradebook.Gradebook.model.dto.SubjectDTO;
import com.gradebook.Gradebook.service.IGradeService;
import com.gradebook.Gradebook.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4202")
@RestController
@RequestMapping(path = GradebookCommon.Subject_BASE_URI)
public class SubjectController {

    @Autowired
    private final ISubjectService subjectService;

    @Autowired
    private final IGradeService gradeService;

    public SubjectController(ISubjectService subjectService, IGradeService gradeService) {
        this.subjectService = subjectService;
        this.gradeService = gradeService;
    }

    @GetMapping(path = "/{id}")
    public SubjectDTO getSubjectById(@PathVariable("id") Long id) {
        return subjectService.getSubjectById(id);
    }

    @GetMapping(path = "/all")
    public List<SubjectDTO> getALlSubjects() {
        return subjectService.getAllSubjects();
    }

    @PostMapping
    public SubjectDTO createSubject(@RequestBody SubjectDTO payload) {
        return subjectService.saveSubject(payload);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteSubjectById(@PathVariable("id") Long id) {
        subjectService.deleteSubject(id);
    }

    @GetMapping(path = "/{subjectId}/grades")
    public List<GradeDTO> subjectGrades(@PathVariable("subjectId") Long subjectId) {
        return gradeService.getAllGradesBySubjectId(subjectId);
    }

}
