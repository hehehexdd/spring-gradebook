package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.dto.AbsenceDTO;
import com.gradebook.Gradebook.model.entity.Absence;
import com.gradebook.Gradebook.repo.AbsenceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AbsenceService implements IAbsenceService{

    @Autowired
    private final AbsenceRepo absenceRepo;

    public AbsenceService(AbsenceRepo absenceRepo) {
        this.absenceRepo = absenceRepo;
    }


    @Override
    public Absence saveAbsence(Absence absence) {
        return absenceRepo.save(absence);
    }

    @Override
    public void updateAbsence(Absence absence) {
        Absence tmp = absenceRepo.getById(absence.getId());
        tmp.setDate(absence.getDate());
        absenceRepo.save(absence);
    }

    @Override
    public void deleteAbsence(Long id) {
        absenceRepo.deleteById(id);
    }

    @Override
    public Absence findById(Long id) {
        return absenceRepo.getById(id);
    }

    @Override
    public AbsenceDTO getById(Long id) {
        return this.convertToDTO(absenceRepo.getById(id));
    }

    @Override
    public List<AbsenceDTO> getAllAbsences() {
        return null;
    }

    @Override
    public AbsenceDTO convertToDTO(Absence absence) {
        AbsenceDTO absenceDTO = new AbsenceDTO();

        if(absence != null) {
            absenceDTO.setId(absence.getId());
            absenceDTO.setStudentId(absence.getStudent().getId());
            absenceDTO.setSubjectId(absence.getSubject().getId());
            //absenceDTO.setTeacherId(absence.getTeacher().getId());
            absenceDTO.setDate(absence.getDate());
        }
        return absenceDTO;
    }
}
