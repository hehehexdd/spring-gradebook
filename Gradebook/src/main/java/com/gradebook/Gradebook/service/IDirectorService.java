package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.dto.DirectorDTO;
import com.gradebook.Gradebook.model.dto.RegisterDTO;
import com.gradebook.Gradebook.model.entity.Director;

import java.util.List;

public interface IDirectorService {
    Director save(Director director);
    DirectorDTO create(RegisterDTO payload);
    DirectorDTO update(Long id, RegisterDTO registerDTO);
    void delete(Long id);
    Director findById(Long id);
    DirectorDTO getById(Long id);
    List<DirectorDTO> getAll();
    DirectorDTO convertToDTO(Director director);
}
