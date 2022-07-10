package com.gradebook.Gradebook.service;


import com.gradebook.Gradebook.model.dto.ParentDTO;
import com.gradebook.Gradebook.model.dto.RegisterDTO;
import com.gradebook.Gradebook.model.entity.Parent;

import java.util.List;

public interface IParentService {
    ParentDTO update(Long parentId, ParentDTO parent);
    void createParent(RegisterDTO user);
    void delete(Long id);
    ParentDTO getById(Long id);
    Parent findById(Long id);
    List<ParentDTO> getAll();

    ParentDTO convertToDTO(Parent parent);
}
