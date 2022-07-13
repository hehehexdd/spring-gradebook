package com.gradebook.Gradebook.service;


import com.gradebook.Gradebook.model.dto.ClassTeachersDTO;
import com.gradebook.Gradebook.model.entity.ClassTeachers;

import java.util.List;

public interface IClassTeachersService {
    ClassTeachersDTO saveClassTeachers(ClassTeachersDTO payload);
    void update(ClassTeachersDTO payload);
    void delete(Long id);
    ClassTeachersDTO getById(Long id);
    ClassTeachers findById(Long id);
    List<ClassTeachersDTO> getAll();

    ClassTeachersDTO convertToDTO(ClassTeachers classTeachers);
}
