package com.gradebook.Gradebook.controller;


import com.gradebook.Gradebook.config.GradebookCommon;
import com.gradebook.Gradebook.data.dto.DirectorDTO;
import com.gradebook.Gradebook.data.entity.Director;
import com.gradebook.Gradebook.data.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = GradebookCommon.DIRECTOR_BASE_URI)
public class DirectorController {

    @Autowired
    private final DirectorService directorService;

    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping(path = "/all")
    public List<DirectorDTO> getAllDirectors() {
        return directorService.getAll();
    }

}
