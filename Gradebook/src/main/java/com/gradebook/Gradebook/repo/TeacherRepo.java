package com.gradebook.Gradebook.repo;

import com.gradebook.Gradebook.model.dto.TeacherDTO;
import com.gradebook.Gradebook.model.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long> {
    Teacher findByUsername(String username);
    List<Teacher> findAllBySchool_Id(Long id);
}
