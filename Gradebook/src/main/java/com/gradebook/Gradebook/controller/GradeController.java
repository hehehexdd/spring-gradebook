package com.gradebook.Gradebook.controller;


import com.gradebook.Gradebook.config.GradebookCommon;
import com.gradebook.Gradebook.model.dto.AppUserDTO;
import com.gradebook.Gradebook.model.dto.GradeDTO;
import com.gradebook.Gradebook.model.entity.Grade;
import com.gradebook.Gradebook.service.IGradeService;
import com.gradebook.Gradebook.service.IStudentService;
import com.gradebook.Gradebook.service.ISubjectService;
import com.gradebook.Gradebook.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4202")
@RestController
@RequestMapping(path = GradebookCommon.GRADE_BASE_URI)
public class GradeController {

    @Autowired
    private final IGradeService gradeService;

    @Autowired
    private final ITeacherService teacherService;

    @Autowired
    private final ISubjectService subjectService;

    @Autowired
    private final IStudentService studentService;

    public GradeController(IGradeService gradeService, ITeacherService teacherService,
                           ISubjectService subjectService,
                           IStudentService studentService) {
        this.gradeService = gradeService;
        this.teacherService = teacherService;
        this.subjectService = subjectService;
        this.studentService = studentService;
    }

    @GetMapping(path = "/all")
    public List<GradeDTO> getAllGrades() {
        return gradeService.getAllGrades();
    }

    @GetMapping(path = "/{id}")
    public List<GradeDTO> getAllGradesByStudentID(@PathVariable("id") Long id) {
        return gradeService.getAllGradesByStudentId(id);
    }

    //call: uri/course/1,2,3,4
    @GetMapping(path = "/students/{studentIds}")
    public List<GradeDTO> getAllGradesByStudentIds(@PathVariable("studentIds") List<Long> studentIds) {
        return gradeService.getAllGradesByStudentsIds(studentIds);
    }

    @PostMapping(path = "/{studentId}")
    public GradeDTO createGrade(@PathVariable("studentId") Long id, @RequestBody GradeDTO payload) {
        Grade grade = new Grade(
                subjectService.getSubjectByName(payload.getSubject()),
                payload.getGrade(),
                studentService.findById(payload.getStudentId()),
                teacherService.findById(payload.getTeacherId()),
                LocalDate.now());
        gradeService.saveGrade(grade);
        return gradeService.convertToDTO(grade);
    }

    @PatchMapping(path = "/{id}")
    public GradeDTO updateGradeById(@PathVariable("id") Long id, @RequestBody GradeDTO payload) {
        Grade tmp = gradeService.findGradeById(id);
        tmp.setGrade(payload.getGrade());
        gradeService.saveGrade(tmp);
        return gradeService.convertToDTO(tmp);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteGradeById(@PathVariable("id") Long id) {
        gradeService.deleteGrade(id);
    }
}
