package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.dto.GradeDTO;

import java.util.List;

public interface ISubjectService {

    List<GradeDTO> getAllGradesForSubject(Long subjectId);
}
