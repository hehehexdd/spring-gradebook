package com.gradebook.Gradebook.repo;

import com.gradebook.Gradebook.model.entity.TermProgram;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TermProgramRepo extends JpaRepository<TermProgram, Long> {
    List<TermProgram> getAllByClassTeachers_StudentClass_Id(Long id);
    void deleteAllByClassTeachers_StudentClass_Id(Long id);
}
