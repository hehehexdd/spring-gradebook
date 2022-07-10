package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.dto.GradeDTO;
import com.gradebook.Gradebook.model.dto.SubjectDTO;
import com.gradebook.Gradebook.model.entity.Grade;
import com.gradebook.Gradebook.model.entity.Subject;

import java.util.List;

public interface ISubjectService {
    Subject saveSubject(Subject subject);
    void updateSubject(SubjectDTO subjectDTO);
    void deleteSubject(Long id);
    SubjectDTO getSubjectById(Long id);
    Subject getSubjectByName(String name);
    List<SubjectDTO> getAllSubjects();
    SubjectDTO convertToDTO(Subject subject);
    List<SubjectDTO> getSubjectsByIds(List<Long> subjectIds);
}
