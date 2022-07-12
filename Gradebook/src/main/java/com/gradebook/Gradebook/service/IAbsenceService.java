package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.dto.AbsenceDTO;
import com.gradebook.Gradebook.model.entity.Absence;

import java.util.List;

public interface IAbsenceService {
    AbsenceDTO saveAbsence(AbsenceDTO payload);
    void updateAbsence(Long id, AbsenceDTO payload);
    void deleteAbsence(Long id);
    Absence findById(Long id);
    AbsenceDTO getById(Long id);
    List<AbsenceDTO> getAllAbsences();
    List<AbsenceDTO> getAllAbsencesByStudentId(Long studentId);
    List<AbsenceDTO> getAllAbsencesByStudentsIds(List<Long> studentIds);
    List<AbsenceDTO> getAllAbsencesByTeacherId(Long teacherId);
    List<AbsenceDTO> getAllAbsencesBySchoolId(Long schoolId);

    AbsenceDTO convertToDTO(Absence absence);
}
