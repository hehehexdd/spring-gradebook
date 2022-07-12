package com.gradebook.Gradebook.service;


import com.gradebook.Gradebook.model.dto.RegisterDTO;
import com.gradebook.Gradebook.model.dto.StudentDTO;
import com.gradebook.Gradebook.model.entity.Student;


import java.util.List;

public interface IStudentService {
    Student saveStudent(Student user);
    StudentDTO createStudent(RegisterDTO payload);
    StudentDTO update(Long id, StudentDTO payload);
    void deleteStudent(Long id);
    StudentDTO getById(Long id);
    Student findById(Long id);
    List<StudentDTO> getAllStudents();
    List<StudentDTO> getAllStudentsByClassId(Long classId);
    List<StudentDTO> getAllStudentsByClassIds(List<Long> classIds);
    StudentDTO convertToDTO(Student user);
    List<StudentDTO> getAllStudentsBySchoolId(Long schoolId);
}
