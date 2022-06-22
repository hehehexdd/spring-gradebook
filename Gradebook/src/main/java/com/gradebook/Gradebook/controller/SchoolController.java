package com.gradebook.Gradebook.controller;

import com.gradebook.Gradebook.config.GradebookCommon;
import com.gradebook.Gradebook.model.dto.SchoolDTO;
import com.gradebook.Gradebook.service.ISchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = GradebookCommon.SCHOOL_BASE_URI)
public class SchoolController {

    @Autowired
    private final ISchoolService schoolService;

    public SchoolController(ISchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping
    public List<SchoolDTO> getAllSchools() {
        return schoolService.getAll();
    }

}
