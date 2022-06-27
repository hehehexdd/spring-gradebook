package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.dto.GradeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SubjectService implements ISubjectService {

    @Autowired
    private final IGradeService gradeService;

    public SubjectService(IGradeService gradeService) {
        this.gradeService = gradeService;
    }

    @Override
    public List<GradeDTO> getAllGradesForSubject(Long subjectId) {
        return gradeService.getAllGradesBySubjectId(subjectId);
    }
}
