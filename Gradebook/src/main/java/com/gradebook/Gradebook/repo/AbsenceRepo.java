package com.gradebook.Gradebook.repo;

import com.gradebook.Gradebook.model.dto.AbsenceDTO;
import com.gradebook.Gradebook.model.entity.Absence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbsenceRepo extends JpaRepository<Absence, Long> {

    @Query("SELECT a FROM Absence a JOIN a.student s WHERE s.id = ?1 ORDER BY a.date DESC")
    List<Absence> getAllAbsencesByStudentId(Long id);

    @Query("SELECT a From Absence a JOIN a.student s WHERE s.id in :ids ORDER BY a.date DESC")
    List<Absence> getAllAbsencesByStudentsId(@Param("ids") List<Long> ids);

    List<Absence> getAllByTeacher_Id(Long id);

    //@Query("SELECT a From Absence a JOIN a.student s WHERE s.school = ?1")
    List<Absence> getAllByStudent_School_Id(Long schoolId);
}
