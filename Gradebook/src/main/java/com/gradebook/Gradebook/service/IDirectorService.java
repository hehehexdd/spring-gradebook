package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.dto.DirectorDTO;
import com.gradebook.Gradebook.model.entity.Director;

import java.util.List;

public interface IDirectorService {
    Director save(Director DirectorDTO);
    void update(Director director);
    void delete(Long id);
    DirectorDTO getById(Long id);
    DirectorDTO getByUsername(String username);
    List<DirectorDTO> getAll();

    DirectorDTO convertToDTO(Director director);


}
