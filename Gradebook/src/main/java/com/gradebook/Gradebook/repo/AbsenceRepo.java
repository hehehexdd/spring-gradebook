package com.gradebook.Gradebook.repo;

import com.gradebook.Gradebook.model.dto.AbsenceDTO;
import com.gradebook.Gradebook.model.entity.Absence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbsenceRepo extends JpaRepository<Absence, Long> {

    @Query("SELECT a FROM Absence a JOIN a.student s WHERE s.id = ?1")
    List<Absence> getAllAbsencesByStudentId(Long id);

    //TODO
    @Query("SELECT a From Absence a JOIN a.student s WHERE s.id in :ids")
    List<Absence> getAllAbsencesByStudentsId(List<Long> ids);
}
