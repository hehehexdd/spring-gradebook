package com.gradebook.Gradebook.service;


import com.gradebook.Gradebook.model.dto.ParentDTO;
import com.gradebook.Gradebook.model.entity.Parent;

import java.util.List;

public interface IParentService {
    Parent save(Parent parent);
    void update(Parent parent);
    void delete(Long id);
    ParentDTO getById(Long id);
    List<ParentDTO> getAll();

    ParentDTO convertToDTO(Parent parent);
}
