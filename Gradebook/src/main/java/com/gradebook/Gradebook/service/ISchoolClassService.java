package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.dto.SchoolClassDTO;
import com.gradebook.Gradebook.model.entity.SchoolClass;

import java.util.List;

public interface ISchoolClassService {
    SchoolClassDTO saveClass(Long id, SchoolClassDTO payload);
    void update(Long id, SchoolClassDTO payload);
    void delete(Long id);
    SchoolClassDTO getById(Long id);
    SchoolClass findById(Long id);
    List<SchoolClassDTO> getAll();
    List<SchoolClassDTO> getAllBySchoolId(Long schoolId);

    SchoolClassDTO convertToDTO(SchoolClass schoolClass);
}
