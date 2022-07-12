package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.dto.GradeDTO;
import com.gradebook.Gradebook.model.dto.TeacherDTO;
import com.gradebook.Gradebook.model.entity.Grade;
import com.gradebook.Gradebook.repo.GradeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class GradeService implements IGradeService{

    @Autowired
    private final GradeRepo gradeRepo;

    @Autowired
    private final ISubjectService subjectService;

    @Autowired
    private final IStudentService studentService;

    @Autowired
    private final ITeacherService teacherService;

    public GradeService(GradeRepo gradeRepo, ISubjectService subjectService,
                        IStudentService studentService, ITeacherService teacherService) {
        this.gradeRepo = gradeRepo;
        this.subjectService = subjectService;
        this.studentService = studentService;
        this.teacherService = teacherService;
    }

    @Override
    public Grade saveGrade(Long id, GradeDTO payload) {
        Grade grade = new Grade(
                subjectService.getSubjectByName(payload.getSubject()),
                payload.getGrade(),
                studentService.findById(payload.getStudentId()),
                teacherService.findById(payload.getTeacherId()),
                LocalDate.now());
        return gradeRepo.save(grade);
    }

    @Override
    public void updateGrade(Long id, GradeDTO gradeDTO) {
        Grade tmp = this.gradeRepo.getById(gradeDTO.getId());
        tmp.setDate(gradeDTO.getDate());
        tmp.setGrade(gradeDTO.getGrade());
        this.gradeRepo.save(tmp);
    }

    @Override
    public void deleteGrade(Long id) {
        this.gradeRepo.deleteById(id);
    }

    @Override
    public GradeDTO getGradeById(Long id) {
        return this.convertToDTO(this.gradeRepo.getById(id));
    }

    @Override
    public Grade findGradeById(Long id) {
        return gradeRepo.getById(id);
    }

    @Override
    public List<GradeDTO> getAllGradesBySubjectId(Long subjectId) {
        return gradeRepo.getAllBySubject_Id(subjectId)
                .stream().map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<GradeDTO> getAllGradesByTeacherId(Long teacherId) {
        return gradeRepo.getAllByTeacher_Id(teacherId)
                .stream().map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<GradeDTO> getAllGradesBySchoolId(Long schoolId) {
        return gradeRepo.getAllByStudent_School_Id(schoolId)
                .stream().map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<GradeDTO> getAllGrades() {
        return gradeRepo.findAll()
                .stream().map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public GradeDTO convertToDTO(Grade grade) {
        GradeDTO gradeDTO = new GradeDTO();

        if (grade != null) {
            gradeDTO.setId(grade.getId());
            gradeDTO.setGrade(grade.getGrade());
            gradeDTO.setDate(grade.getDate());
            gradeDTO.setSubject((grade.getSubject() != null) ? grade.getSubject().getName() : null);
            gradeDTO.setStudentId((grade.getStudent() != null ? grade.getStudent().getId() : null));
            gradeDTO.setTeacherId((grade.getTeacher() != null ? grade.getTeacher().getId() : null));
        }

        return gradeDTO;
    }

    @Override
    public List<GradeDTO> getAllGradesByStudentId(Long studentId) {
        return gradeRepo.getAllGradesByStudent(studentId)
                .stream().map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<GradeDTO> getAllGradesByStudentsIds(List<Long> studentIds) {
        return gradeRepo.getAllGradesByStudent(studentIds)
                .stream().map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
