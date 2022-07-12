package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.dto.AbsenceDTO;
import com.gradebook.Gradebook.model.entity.Absence;
import com.gradebook.Gradebook.repo.AbsenceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AbsenceService implements IAbsenceService{

    @Autowired
    private final AbsenceRepo absenceRepo;

    @Autowired
    private final IStudentService studentService;

    @Autowired
    private final ISubjectService subjectService;

    @Autowired
    private final ITeacherService teacherService;


    public AbsenceService(AbsenceRepo absenceRepo, IStudentService studentService,
                          ISubjectService subjectService, ITeacherService teacherService) {
        this.absenceRepo = absenceRepo;
        this.studentService = studentService;
        this.subjectService = subjectService;
        this.teacherService = teacherService;
    }


    @Override
    public AbsenceDTO saveAbsence(AbsenceDTO payload) {
        Absence absence = new Absence(payload.getId(),
                studentService.findById(payload.getStudentId()),
                subjectService.getSubjectByName(payload.getSubject()),
                teacherService.findById(payload.getTeacherId()),
                LocalDate.now());
        absenceRepo.save(absence);
        return this.convertToDTO(absence);
    }

    @Override
    public void updateAbsence(Long id, AbsenceDTO payload) {
        Absence absence = absenceRepo.getById(payload.getId());
        absence.setDate(payload.getDate());
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
        return absenceRepo.findAll()
                .stream().map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AbsenceDTO> getAllAbsencesByStudentId(Long studentId) {
        return absenceRepo.getAllAbsencesByStudentId(studentId)
                .stream().map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AbsenceDTO> getAllAbsencesByStudentsIds(List<Long> studentIds) {
        return absenceRepo.getAllAbsencesByStudentsId(studentIds)
                .stream().map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AbsenceDTO> getAllAbsencesByTeacherId(Long teacherId) {
        return absenceRepo.getAllByTeacher_Id(teacherId)
                .stream().map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AbsenceDTO> getAllAbsencesBySchoolId(Long schoolId) {
        return absenceRepo.getAllByStudent_School_Id(schoolId)
                .stream().map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AbsenceDTO convertToDTO(Absence absence) {
        AbsenceDTO absenceDTO = new AbsenceDTO();

        if(absence != null) {
            absenceDTO.setId(absence.getId());
            absenceDTO.setStudentId(absence.getStudent().getId());
            absenceDTO.setStudentName(absence.getStudent().getFirstName() + " " + absence.getStudent().getLastName());
            absenceDTO.setSubject(absence.getSubject().getName() );
            absenceDTO.setTeacherId(absence.getTeacher().getId());
            absenceDTO.setTeacherName(absence.getTeacher().getFirstName() + " " + absence.getTeacher().getLastName());
            absenceDTO.setDate(absence.getDate());
        }
        return absenceDTO;
    }
}
