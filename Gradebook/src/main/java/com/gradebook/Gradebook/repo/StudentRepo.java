package com.gradebook.Gradebook.repo;

import com.gradebook.Gradebook.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Long> {
    List<Student> getAllBySchool_Id(Long schoolId);
    List<Student> getAllByClass_Id(Long classId);

    @Query("SELECT s From Student s JOIN s.schoolClass c WHERE c.id in :ids")
    List<Student> getAllByClass_Ids(@Param("ids") List<Long> classIds);
}
