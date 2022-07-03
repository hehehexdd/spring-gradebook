package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.dto.AbsenceDTO;
import com.gradebook.Gradebook.model.entity.Absence;

import java.util.List;

public interface IAbsenceService {
    Absence saveAbsence(Absence absence);
    void updateAbsence(Absence absence);
    void deleteAbsence(Long id);
    Absence findById(Long id);
    AbsenceDTO getById(Long id);
    List<AbsenceDTO> getAllAbsences();
    List<AbsenceDTO> getAllAbsencesByStudentId(Long studentId);
    List<AbsenceDTO> getAllAbsencesByStudentsIds(List<Long> studentIds);

    AbsenceDTO convertToDTO(Absence absence);
}
