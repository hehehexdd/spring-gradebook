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
    private final IStudentService studentService;

    @Autowired
    private final ITeacherService teacherService;

    @Autowired
    private final ISubjectService subjectService;

    @Autowired
    private final IParentService parentService;

    public AbsenceController(IAbsenceService absenceService, IStudentService studentService,
                             ITeacherService teacherService, ISubjectService subjectService,
                             IParentService parentService) {
        this.absenceService = absenceService;
        this.studentService = studentService;
        this.teacherService = teacherService;
        this.subjectService = subjectService;
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
    public List<AbsenceDTO> getAllAbsencesByStudentIds(@PathVariable("parentId") Long parentId) {
        ParentDTO parent = parentService.getById(parentId);
        return absenceService.getAllAbsencesByStudentsIds(parent.getChildrenIds());
    }

    @PostMapping(path = "/{studentId}")
    public AbsenceDTO createAbsence(@PathVariable("studentId") Long id, @RequestBody AbsenceDTO payload) {
        Absence absence = new Absence(payload.getId(),
                studentService.findById(payload.getStudentId()),
                subjectService.getSubjectByName(payload.getSubject()),
                teacherService.findById(payload.getTeacherId()),
                LocalDate.now());
        absenceService.saveAbsence(absence);
        return absenceService.convertToDTO(absence);
    }

    @PatchMapping(path = "/{id}")
    public AbsenceDTO updateAbsenceById(@PathVariable("id") Long id, @RequestBody GradeDTO payload) {
        Absence tmp = absenceService.findById(id);
        tmp.setDate(payload.getDate());
        absenceService.saveAbsence(tmp);
        return absenceService.convertToDTO(tmp);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteAbsenceById(@PathVariable("id") Long id) {
        absenceService.deleteAbsence(id);
    }
}
