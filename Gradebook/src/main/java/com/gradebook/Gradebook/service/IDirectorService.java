package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.dto.DirectorDTO;
import com.gradebook.Gradebook.model.entity.Director;

import java.util.List;

public interface IDirectorService {
    DirectorDTO save(Director director);
    void update(Director director);
    void delete(Long id);
    Director findById(Long id);
    Director findByUsername(String username);
    DirectorDTO getById(Long id);
    DirectorDTO getByUsername(String username);
    List<DirectorDTO> getAll();

    DirectorDTO convertToDTO(Director director);


}
