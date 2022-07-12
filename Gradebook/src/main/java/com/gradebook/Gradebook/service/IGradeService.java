package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.dto.GradeDTO;
import com.gradebook.Gradebook.model.entity.Grade;

import java.util.List;

public interface IGradeService {
    Grade saveGrade(Long id, GradeDTO payload);
    void updateGrade(Long id, GradeDTO gradeDTO);
    void deleteGrade(Long id);
    GradeDTO getGradeById(Long id);
    Grade findGradeById(Long id);
    List<GradeDTO> getAllGrades();
    GradeDTO convertToDTO(Grade grade);

    List<GradeDTO> getAllGradesByStudentId(Long studentId);
    List<GradeDTO> getAllGradesByStudentsIds(List<Long> studentIds);

    List<GradeDTO> getAllGradesBySubjectId(Long subjectId);
    List<GradeDTO> getAllGradesByTeacherId(Long teacherId);
    List<GradeDTO> getAllGradesBySchoolId(Long schoolId);
}
