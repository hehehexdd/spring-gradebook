package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.dto.*;
import com.gradebook.Gradebook.model.entity.Parent;
import com.gradebook.Gradebook.model.entity.Teacher;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface ITeacherService {
    TeacherDTO update(Long teacherId, TeacherDTO teacher);
    void createTeacher(RegisterDTO user);
    void delete(Long id);
    TeacherDTO getById(Long id);
    Teacher findById(Long id);
    List<TeacherDTO> getAll(Long schoolId);
    List<TeacherCourcesDTO> getCourses(Long id);
    List<StudentDTO> getStudents(Long id);
    TeacherDTO convertToDTO(Teacher teacher);
}
