package com.gradebook.Gradebook.repo;

import com.gradebook.Gradebook.model.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepo extends JpaRepository<Grade, Long> {

    @Query("SELECT g FROM Grade g JOIN g.student s WHERE s.id = ?1")
    List<Grade> getAllGradesByStudent(Long studentId);

    //TODO
    @Query("SELECT g From Grade g JOIN g.student s WHERE s.id in :ids")
    List<Grade> getAllGradesByStudent(@Param("ids") List<Long> studentIds);

    List<Grade> getAllBySubject_Id(Long id);
    List<Grade> getAllByTeacher_Id(Long id);
    List<Grade> getAllByStudent_School_Id(Long id);
}
