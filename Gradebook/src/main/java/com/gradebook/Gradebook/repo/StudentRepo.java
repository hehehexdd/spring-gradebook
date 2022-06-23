package com.gradebook.Gradebook.repo;

import com.gradebook.Gradebook.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
}
