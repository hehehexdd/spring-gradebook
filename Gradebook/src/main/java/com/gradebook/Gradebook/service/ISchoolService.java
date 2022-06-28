package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.dto.RegisterDTO;
import com.gradebook.Gradebook.model.dto.SchoolDTO;
import com.gradebook.Gradebook.model.dto.SchoolStatisticsDTO;
import com.gradebook.Gradebook.model.entity.School;

import java.util.List;

public interface ISchoolService {

    School save(School school);

    SchoolDTO create(RegisterDTO payload);
    void update(SchoolDTO schoolDTO);
    void delete(Long id);

    School findById(Long id);
    SchoolDTO getById(Long id);
    List<SchoolDTO> getAll();

    SchoolStatisticsDTO getStatisticsForSchool(Long id);

    SchoolDTO convertToDTO(School school);
}

