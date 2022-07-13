package com.gradebook.Gradebook.controller;

import com.gradebook.Gradebook.config.GradebookCommon;
import com.gradebook.Gradebook.model.dto.TermProgramDTO;
import com.gradebook.Gradebook.service.ITermProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = GradebookCommon.TERM_PROGRAM_BASE_URI)
public class TermProgramController {

    @Autowired
    private final ITermProgramService termProgramService;

    public TermProgramController(ITermProgramService termProgramService) {
        this.termProgramService = termProgramService;
    }

    @GetMapping(path = "/all")
    public List<TermProgramDTO> getAll() {
        return termProgramService.getAll();
    }

    @GetMapping(path = "/{classId}")
    public List<TermProgramDTO> getClassTermProgramByClassId(@PathVariable Long classId) {
        return termProgramService.getAllByClassId(classId);
    }

    @DeleteMapping(path = "/{classId}")
    public void deleteClassTermProgramById(@PathVariable Long classId) {
        termProgramService.deleteAllByClassId(classId);
    }

    @PostMapping
    public TermProgramDTO createTermProgram(@RequestBody TermProgramDTO payload) {
        return termProgramService.save(payload);
    }
}
