package com.gradebook.Gradebook.controller;


import com.gradebook.Gradebook.config.GradebookCommon;
import com.gradebook.Gradebook.model.dto.DirectorDTO;
import com.gradebook.Gradebook.model.dto.ParentDTO;
import com.gradebook.Gradebook.model.entity.Parent;
import com.gradebook.Gradebook.service.IDirectorService;
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
    public List<ParentDTO> getAllDirectors() {
        return this.parentService.getAll();
    }

    @GetMapping(path = "/{id}")
    public ParentDTO getParentById(@PathVariable("id") Long id) {
        return this.parentService.getById(id);
    }

    //To-do
    @PatchMapping(path = "/{id}")
    public ParentDTO updateParentById(@PathVariable("id") Long id, @RequestBody ParentDTO payload) {
        return new ParentDTO(Long.valueOf(1),"Ivan", "Ivan", "123");
    }

    //To-do
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ParentDTO createParent(@RequestBody ParentDTO payload) {
        return new ParentDTO(Long.valueOf(1),"Ivan", "Ivan", "123");
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteParentById(@PathVariable("id") Long id) {
        this.parentService.delete(id);
    }
}
