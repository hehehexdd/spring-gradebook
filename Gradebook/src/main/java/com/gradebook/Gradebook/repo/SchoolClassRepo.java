package com.gradebook.Gradebook.repo;

import com.gradebook.Gradebook.model.entity.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolClassRepo extends JpaRepository<SchoolClass, Long> {
    @Query("SELECT c FROM SchoolClass c JOIN c.school s WHERE s.id = ?1")
    List<SchoolClass> getAllClassesBySchoolId(Long schoolId);
}
