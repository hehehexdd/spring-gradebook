package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.dto.StudentDTO;
import com.gradebook.Gradebook.model.entity.Student;
import com.gradebook.Gradebook.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentService implements IStudentService{

    @Autowired
    private final StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }


    @Override
    public void updateStudent(Student student) {
        if(student != null) {
            Student tmp;
            tmp = studentRepo.getById(student.getId());
            tmp.setFirstName(student.getFirstName());
            tmp.setLastName(student.getLastName());
            tmp.setSchool(student.getSchool());
            tmp.setAbsences(student.getAbsences());
            tmp.setGrades(student.getGrades());
            tmp.setParents(student.getParents());
            tmp.setSClass(student.getSClass());
            studentRepo.save(tmp);
        }
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }

    @Override
    public Student getStudent(Long id) {
        return null;
    }

    @Override
    public List<StudentDTO> getAllStudent() {
        return null;
    }

    @Override
    public List<StudentDTO> getAllStudentsBySchoolId(Long schoolId) {
        return studentRepo.getAllBySchool_Id(schoolId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO convertToDTO(Student user) {
        return null;
    }

    @Override
    public Student convertToEntity(StudentDTO userDTO) {
        return null;
    }
}
