package com.gradebook.Gradebook.controller;

import com.gradebook.Gradebook.config.GradebookCommon;
import com.gradebook.Gradebook.model.dto.AbsenceDTO;
import com.gradebook.Gradebook.model.dto.GradeDTO;
import com.gradebook.Gradebook.model.entity.Absence;
import com.gradebook.Gradebook.service.IAbsenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = GradebookCommon.ABSENCE_BASE_URI)
public class AbsenceController {

    @Autowired
    private final IAbsenceService absenceService;

    public AbsenceController(IAbsenceService absenceService) {
        this.absenceService = absenceService;
    }

    @GetMapping(path = "/all")
    public List<AbsenceDTO> getAllAbsences() {
        return absenceService.getAllAbsences();
    }

    @GetMapping(path = "/{id}")
    public AbsenceDTO getAllAbsencesByStudentID(@PathVariable("id") Long id) {
        return new AbsenceDTO(
                Long.valueOf(1),
                id,
                Long.valueOf(2),
                LocalDate.now());
    }

    //call: uri/absence/1,2,3,4
    @GetMapping(path = "/students/{studentIds}")
    public List<AbsenceDTO> getAllAbsencesByStudentIds(@PathVariable("studentIds") List<Long> studentIds) {
        List<AbsenceDTO> absences = new ArrayList<AbsenceDTO>();
        absences.add(new AbsenceDTO(
                Long.valueOf(1),
                studentIds.get(0),
                Long.valueOf(2),
                LocalDate.now()));
        absences.add(new AbsenceDTO(
                Long.valueOf(2),
                studentIds.get(1),
                Long.valueOf(3),
                LocalDate.now())
        );
        return absences;
    }

    @PostMapping(path = "/{studentId}")
    public AbsenceDTO createAbsence(@PathVariable("studentId") Long id) {
        return new AbsenceDTO(
                Long.valueOf(1),
                id,
                Long.valueOf(2),
                LocalDate.now());
    }

    @PatchMapping(path = "/{id}")
    public AbsenceDTO updateAbsenceById(@PathVariable("id") Long id, @RequestBody GradeDTO payload) {
        return new AbsenceDTO(
                Long.valueOf(1),
                id,
                Long.valueOf(2),
                LocalDate.now());
    }

    @DeleteMapping(path = "/{id}")
    public void deleteAbsenceById(@PathVariable("id") Long id) {
        absenceService.deleteAbsence(id);
    }
}
