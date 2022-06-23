package com.gradebook.Gradebook.service;


import com.gradebook.Gradebook.model.dto.StudentDTO;
import com.gradebook.Gradebook.model.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IStudentService {
    Student saveStudent(Student user);
    void updateStudent(Student user);
    void deleteStudent(Long id);
    Student getStudent(Long id);
    List<StudentDTO> getAllStudent();
    StudentDTO convertToDTO(Student user);
    Student convertToEntity(StudentDTO userDTO);

    List<StudentDTO> getAllStudentsBySchoolId(Long schoolId);
}
