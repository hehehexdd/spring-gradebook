package com.gradebook.Gradebook.service;


import com.gradebook.Gradebook.model.dto.GradeDTO;
import com.gradebook.Gradebook.model.dto.StudentDTO;
import com.gradebook.Gradebook.model.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IStudentService {
    Student saveStudent(Student user);
    void updateStudent(Student user);
    void deleteStudent(Long id);
    StudentDTO getById(Long id);
    Student findById(Long id);
    List<StudentDTO> getAllStudents();
    StudentDTO convertToDTO(Student user);
    List<StudentDTO> getAllStudentsBySchoolId(Long schoolId);
}
