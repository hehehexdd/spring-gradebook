package com.gradebook.Gradebook.controller;

import com.gradebook.Gradebook.config.GradebookCommon;
import com.gradebook.Gradebook.model.dto.SchoolClassDTO;
import com.gradebook.Gradebook.service.ISchoolClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4202")
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
        return schoolClassService.getAllBySchoolId(id);
    }

    @PostMapping
    public SchoolClassDTO createClass(@RequestBody SchoolClassDTO payload) {
        return this.schoolClassService.saveClass(payload);
    }

    @PatchMapping(path = "/{id}")
    public SchoolClassDTO updateClass(@PathVariable("id") Long id, @RequestBody SchoolClassDTO payload) {
        this.schoolClassService.update(id, payload);
        return this.schoolClassService.convertToDTO(schoolClassService.findById(id));
    }

    @DeleteMapping(path = "/{id}")
    public void deleteClass(@PathVariable("id") Long id) {
        this.schoolClassService.delete(id);
    }
}
