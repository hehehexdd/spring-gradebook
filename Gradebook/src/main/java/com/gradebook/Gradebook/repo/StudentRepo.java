package com.gradebook.Gradebook.repo;

import com.gradebook.Gradebook.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Long> {
    List<Student> getAllBySchool_Id(Long schoolId);
}
