package com.gradebook.Gradebook.repo;

import com.gradebook.Gradebook.model.entity.ClassTeachers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassTeacherRepo extends JpaRepository<ClassTeachers, Long> {

    List<ClassTeachers> getAllByTeacher_Id(Long id);
}
