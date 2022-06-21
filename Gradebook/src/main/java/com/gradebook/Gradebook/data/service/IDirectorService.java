package com.gradebook.Gradebook.data.service;

import com.gradebook.Gradebook.data.dto.DirectorDTO;
import com.gradebook.Gradebook.data.entity.Director;

import java.util.List;

public interface IDirectorService {
    Director save(Director director);
    void update(Director director);
    void delete(Long id);
    Director getById(Long id);
    List<DirectorDTO> getAll();

    DirectorDTO convertToDTO(Director director);
}
