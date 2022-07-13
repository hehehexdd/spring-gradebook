package com.gradebook.Gradebook.repo;

import com.gradebook.Gradebook.model.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubjectRepo extends JpaRepository<Subject, Long> {
    Subject findByName(String name);

    @Query("SELECT s FROM Subject s WHERE s.id in :ids")
    List<Subject> getAllSubjectsByIds(@Param("ids") List<Long> ids);


}
