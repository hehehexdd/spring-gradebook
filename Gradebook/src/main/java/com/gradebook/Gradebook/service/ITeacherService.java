package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.dto.GradeDTO;
import com.gradebook.Gradebook.model.dto.ParentDTO;
import com.gradebook.Gradebook.model.dto.TeacherCourcesDTO;
import com.gradebook.Gradebook.model.dto.TeacherDTO;
import com.gradebook.Gradebook.model.entity.Parent;
import com.gradebook.Gradebook.model.entity.Teacher;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface ITeacherService {
    Teacher save(Teacher teacher);
    void update(Teacher teacher);
    void delete(Long id);
    TeacherDTO getById(Long id);
    List<TeacherDTO> getAll(Long schoolId);
    List<TeacherCourcesDTO> getCourses(Long id);
    TeacherDTO convertToDTO(Teacher teacher);

    List<GradeDTO> getAllTeacherGrades(Long teacherId);

}
