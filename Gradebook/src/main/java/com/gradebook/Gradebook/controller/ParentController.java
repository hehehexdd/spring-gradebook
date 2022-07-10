package com.gradebook.Gradebook.controller;


import com.gradebook.Gradebook.config.GradebookCommon;
import com.gradebook.Gradebook.model.dto.ParentDTO;
import com.gradebook.Gradebook.model.dto.RegisterDTO;
import com.gradebook.Gradebook.service.IParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = GradebookCommon.PARENT_BASE_URI)
public class ParentController {

    @Autowired
    private final IParentService parentService;

    public ParentController(IParentService parentService) {
        this.parentService = parentService;
    }

    @GetMapping()
    public List<ParentDTO> getAllParents() {
        return this.parentService.getAll();
    }

    @GetMapping(path = "/{id}")
    public ParentDTO getParentById(@PathVariable("id") Long id) {
        return this.parentService.getById(id);
    }

    @PatchMapping(path = "/{id}")
    public ParentDTO updateParentById(@PathVariable("id") Long id, @RequestBody(required=false) ParentDTO payload) {
        return this.parentService.update(id, payload);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createParent(@RequestBody RegisterDTO payload) {
        this.parentService.createParent(payload);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteParentById(@PathVariable("id") Long id) {
        this.parentService.delete(id);
    }
}
