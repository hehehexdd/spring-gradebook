package com.gradebook.Gradebook.controller;

import com.gradebook.Gradebook.config.GradebookCommon;
import com.gradebook.Gradebook.model.dto.GradeDTO;
import com.gradebook.Gradebook.model.dto.RegisterDTO;
import com.gradebook.Gradebook.model.dto.SchoolDTO;
import com.gradebook.Gradebook.model.dto.SchoolStatisticsDTO;
import com.gradebook.Gradebook.service.IGradeService;
import com.gradebook.Gradebook.service.ISchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4202")
@RestController
@RequestMapping(path = GradebookCommon.SCHOOL_BASE_URI)
public class SchoolController {

    @Autowired
    private final ISchoolService schoolService;

    @Autowired
    private final IGradeService gradeService;

    public SchoolController(ISchoolService schoolService, IGradeService gradeService) {
        this.schoolService = schoolService;
        this.gradeService = gradeService;
    }

    @GetMapping(path = "/{id}/statistics")
    public SchoolStatisticsDTO getSchoolStatistics(@PathVariable("id") Long schoolId) {
        return schoolService.getStatisticsForSchool(schoolId);
    }

    @GetMapping(path = "/{id}/grades")
    public List<GradeDTO> getAllSchoolGrades(@PathVariable("id") Long schoolId) {
        return gradeService.getAllGradesBySchool(schoolId);
    }

    @GetMapping(path = "/{id}/grades/statistics")
    public ResponseEntity getAllSchoolGradeStatistics(@PathVariable("id") Long schoolId) {
        return schoolService.getGradeStatistics(schoolId);
    }

    @GetMapping(path =  "/{id}")
    public SchoolDTO getSchool(@PathVariable("id") Long id) {
        return schoolService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SchoolDTO createSchool(@RequestBody RegisterDTO payload) {
        return schoolService.create(payload);
    }

    @GetMapping(path = "/all")
    public List<SchoolDTO> getAllSchools() {
        return schoolService.getAll();
    }

}
