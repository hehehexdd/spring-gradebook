package com.gradebook.Gradebook.controller;

import com.gradebook.Gradebook.config.GradebookCommon;
import com.gradebook.Gradebook.model.dto.AbsenceDTO;
import com.gradebook.Gradebook.model.dto.GradeDTO;
import com.gradebook.Gradebook.model.entity.Absence;
import com.gradebook.Gradebook.service.IAbsenceService;
import com.gradebook.Gradebook.service.IStudentService;
import com.gradebook.Gradebook.service.ISubjectService;
import com.gradebook.Gradebook.service.ITeacherService;
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

    public AbsenceController(IAbsenceService absenceService, IStudentService studentService,
                             ITeacherService teacherService, ISubjectService subjectService) {
        this.absenceService = absenceService;
        this.studentService = studentService;
        this.teacherService = teacherService;
        this.subjectService = subjectService;
    }

    @GetMapping(path = "/all")
    public List<AbsenceDTO> getAllAbsences() {
        return absenceService.getAllAbsences();
    }

    @GetMapping(path = "/{id}")
    public List<AbsenceDTO> getAllAbsencesByStudentID(@PathVariable("id") Long id) {
//        return new AbsenceDTO(
//                Long.valueOf(1),
//                id,
//                Long.valueOf(2),
//                LocalDate.now());
        return absenceService.getAllAbsencesByStudentId(id);
    }

    //call: uri/absence/1,2,3,4
    @GetMapping(path = "/students/{studentIds}")
    public List<AbsenceDTO> getAllAbsencesByStudentIds(@PathVariable("studentIds") List<Long> studentIds) {
//        List<AbsenceDTO> absences = new ArrayList<AbsenceDTO>();
//        absences.add(new AbsenceDTO(
//                Long.valueOf(1),
//                studentIds.get(0),
//                Long.valueOf(2),
//                LocalDate.now()));
//        absences.add(new AbsenceDTO(
//                Long.valueOf(2),
//                studentIds.get(1),
//                Long.valueOf(3),
//                LocalDate.now())
//        );
        return absenceService.getAllAbsencesByStudentsIds(studentIds);
    }

    @PostMapping(path = "/{studentId}")
    public AbsenceDTO createAbsence(@PathVariable("studentId") Long id, @RequestBody AbsenceDTO payload) {
//        return new AbsenceDTO(
//                Long.valueOf(1),
//                id,
//                Long.valueOf(2),
//                LocalDate.now());
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
//        return new AbsenceDTO(
//                Long.valueOf(1),
//                id,
//                Long.valueOf(2),
//                LocalDate.now());
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
