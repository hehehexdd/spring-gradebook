package com.gradebook.Gradebook.controller;

import com.gradebook.Gradebook.config.GradebookCommon;
import com.gradebook.Gradebook.model.dto.AbsenceDTO;
import com.gradebook.Gradebook.model.dto.GradeDTO;
import com.gradebook.Gradebook.model.dto.ParentDTO;
import com.gradebook.Gradebook.model.entity.Absence;
import com.gradebook.Gradebook.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4202")
@RestController
@RequestMapping(path = GradebookCommon.ABSENCE_BASE_URI)
public class AbsenceController {

    @Autowired
    private final IAbsenceService absenceService;

    @Autowired
    private final IParentService parentService;

    public AbsenceController(IAbsenceService absenceService, IParentService parentService) {
        this.absenceService = absenceService;
        this.parentService = parentService;
    }

    @GetMapping(path = "/all")
    public List<AbsenceDTO> getAllAbsences() {
        return absenceService.getAllAbsences();
    }

    @GetMapping(path = "/{id}")
    public List<AbsenceDTO> getAllAbsencesByStudentID(@PathVariable("id") Long id) {
        return absenceService.getAllAbsencesByStudentId(id);
    }

    //call: uri/absence/1,2,3,4
    @GetMapping(path = "/students/parent/{parentId}")
    public List<AbsenceDTO> getAllAbsencesOfStudentsByParentId(@PathVariable("parentId") Long parentId) {
        ParentDTO parent = parentService.getById(parentId);
        return absenceService.getAllAbsencesByStudentsIds(parent.getChildrenIds());
    }

    @GetMapping(path = "/students/teacher/{teacherId}")
    public List<AbsenceDTO> getAllAbsencesByTeacherIdS(@PathVariable("teacherId") Long teacherId) {
        return absenceService.getAllAbsencesByTeacherId(teacherId);
    }

    @GetMapping(path = "/school/{schoolId}")
    public List<AbsenceDTO> getAllAbsencesBySchoolId(@PathVariable("schoolId") Long schoolId) {
        return absenceService.getAllAbsencesBySchoolId(schoolId);
    }

    @PostMapping(path = "/{studentId}")
    public AbsenceDTO createAbsence(@PathVariable("studentId") Long id, @RequestBody AbsenceDTO payload) {
        return absenceService.convertToDTO(absenceService.saveAbsence(id, payload));
    }

    @PatchMapping(path = "/{id}")
    public AbsenceDTO updateAbsenceById(@PathVariable("id") Long id, @RequestBody AbsenceDTO payload) {
        this.absenceService.updateAbsence(id, payload);
        return absenceService.convertToDTO(absenceService.findById(id));
    }

    @DeleteMapping(path = "/{id}")
    public void deleteAbsenceById(@PathVariable("id") Long id) {
        absenceService.deleteAbsence(id);
    }
}
