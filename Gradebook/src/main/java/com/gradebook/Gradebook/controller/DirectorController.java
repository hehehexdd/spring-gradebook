package com.gradebook.Gradebook.controller;


import com.gradebook.Gradebook.config.GradebookCommon;
import com.gradebook.Gradebook.model.dto.DirectorDTO;
import com.gradebook.Gradebook.model.dto.RegisterDTO;
import com.gradebook.Gradebook.service.IDirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4202")
@RestController
@RequestMapping(path = GradebookCommon.DIRECTOR_BASE_URI)
public class DirectorController {

    @Autowired
    private final IDirectorService directorService;

    public DirectorController(IDirectorService IDirectorService) {
        this.directorService = IDirectorService;
    }

    @GetMapping
    public List<DirectorDTO> getAllDirectors() {
        return directorService.getAll();
    }

    @GetMapping(path = "/{id}")
    public DirectorDTO getDirectorById(@PathVariable("id") Long id) {
        return directorService.getById(id);
    }

    @PatchMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DirectorDTO updateDirector(@PathVariable("id") Long id, @RequestBody DirectorDTO payload) {
        return new DirectorDTO(Long.valueOf(1), "PATCH", "PATCH", "PATCH", "PATCH");
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DirectorDTO createDirector(@RequestBody RegisterDTO payload) {
        return directorService.create(payload);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDirectorById(@PathVariable("id") Long id) {
        directorService.delete(id);
    }
}
