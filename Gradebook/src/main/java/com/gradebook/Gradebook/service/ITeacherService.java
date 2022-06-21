package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.dto.ParentDTO;
import com.gradebook.Gradebook.model.dto.TeacherDTO;
import com.gradebook.Gradebook.model.entity.Parent;
import com.gradebook.Gradebook.model.entity.Teacher;

import java.util.List;

public interface ITeacherService {
    Teacher save(Teacher teacher);
    void update(Teacher teacher);
    void delete(Long id);
    TeacherDTO getById(Long id);
    List<TeacherDTO> getAll();

    TeacherDTO convertToDTO(Teacher teacher);

}
