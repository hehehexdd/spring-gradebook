package com.gradebook.Gradebook.service;


import com.gradebook.Gradebook.model.dto.RegisterDTO;
import com.gradebook.Gradebook.model.dto.StudentDTO;
import com.gradebook.Gradebook.model.entity.Student;


import java.util.List;

public interface IStudentService {
    Student saveStudent(Student user);
    void createStudent(RegisterDTO payload);
    void updateStudent(Student user);
    StudentDTO update(Long id, StudentDTO payload);
    void deleteStudent(Long id);
    StudentDTO getById(Long id);
    Student findById(Long id);
    List<StudentDTO> getAllStudents();
    List<StudentDTO> getAllStudentsByClassId(Long classId);
    List<StudentDTO> getAllStudentsByClassIdS(List<Long> classIds);
    StudentDTO convertToDTO(Student user);
    List<StudentDTO> getAllStudentsBySchoolId(Long schoolId);
}
