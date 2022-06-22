package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.dto.SchoolDTO;
import com.gradebook.Gradebook.model.entity.Director;
import com.gradebook.Gradebook.model.entity.School;

import java.util.List;

public interface ISchoolService {

    SchoolDTO save(School school);
    void update(SchoolDTO schoolDTO);
    void delete(Long id);
    SchoolDTO getById(Long id);
    List<SchoolDTO> getAll();

    SchoolDTO convertToDTO(School school);
}

