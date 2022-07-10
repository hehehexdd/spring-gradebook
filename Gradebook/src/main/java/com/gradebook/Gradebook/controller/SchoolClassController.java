package com.gradebook.Gradebook.controller;

import com.gradebook.Gradebook.config.GradebookCommon;
import com.gradebook.Gradebook.model.dto.SchoolClassDTO;
import com.gradebook.Gradebook.service.ISchoolClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = GradebookCommon.SCHOOL_CLASS_BASE_URI)
public class SchoolClassController {

    @Autowired
    private final ISchoolClassService schoolClassService;

    public SchoolClassController(ISchoolClassService schoolClassService) {
        this.schoolClassService = schoolClassService;
    }

    @GetMapping(path = "/all")
    public List<SchoolClassDTO> getAllClassesInASchool() {
        return schoolClassService.getAll();
    }

    @GetMapping(path = "/{schoolId}/all")
    public List<SchoolClassDTO> getAllClassesBySchoolId(@PathVariable("schoolId") Long id) {

    }
}
