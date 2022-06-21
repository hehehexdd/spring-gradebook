package com.gradebook.Gradebook.controller;


import com.gradebook.Gradebook.config.GradebookCommon;
import com.gradebook.Gradebook.model.dto.DirectorDTO;
import com.gradebook.Gradebook.service.IDirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = GradebookCommon.DIRECTOR_BASE_URI)
public class DirectorController {

    @Autowired
    private final IDirectorService IDirectorService;

    public DirectorController(IDirectorService IDirectorService) {
        this.IDirectorService = IDirectorService;
    }

    @GetMapping(path = "/all")
    public List<DirectorDTO> getAllDirectors() {
        return IDirectorService.getAll();
    }

}
