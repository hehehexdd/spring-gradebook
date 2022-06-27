package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.dto.GradeDTO;
import com.gradebook.Gradebook.model.dto.TeacherDTO;
import com.gradebook.Gradebook.model.entity.Grade;
import com.gradebook.Gradebook.repo.GradeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class GradeService implements IGradeService{

    @Autowired
    private final GradeRepo gradeRepo;

    public GradeService(GradeRepo gradeRepo) {
        this.gradeRepo = gradeRepo;
    }

    @Override
    public Grade saveGrade(Grade grade) {
        return this.gradeRepo.save(grade);
    }

    @Override
    public void updateGrade(GradeDTO gradeDTO) {
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
    public List<GradeDTO> getAllGradeBySubjectId(Long subjectId) {
        return gradeRepo.getAllBySubject_Id(subjectId)
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
            gradeDTO.setSubject(grade.getSubject().getName());
            gradeDTO.setStudentId(grade.getStudent().getId());
            //gradeDTO.setTeacherId((grade.getTeacher().getId());
        }

        return gradeDTO;
    }

    @Override
    public Grade convertToEntity(GradeDTO gradeDTO) {
        return null;
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
