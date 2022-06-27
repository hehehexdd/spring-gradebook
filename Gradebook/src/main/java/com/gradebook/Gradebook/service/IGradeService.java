package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.dto.GradeDTO;
import com.gradebook.Gradebook.model.entity.Grade;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IGradeService {
    Grade saveGrade(Grade grade);
    void updateGrade(GradeDTO gradeDTO);
    void deleteGrade(Long id);
    GradeDTO getGradeById(Long id);
    List<GradeDTO> getAllGrades();
    GradeDTO convertToDTO(Grade grade);
    Grade convertToEntity(GradeDTO gradeDTO);

    List<GradeDTO> getAllGradesByStudentId(Long studentId);
    List<GradeDTO> getAllGradesByStudentsIds(List<Long> studentIds);

    List<GradeDTO> getAllGradeBySubjectId(Long subjectId);

}
