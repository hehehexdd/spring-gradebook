package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.dto.GradeDTO;
import com.gradebook.Gradebook.model.dto.SubjectDTO;
import com.gradebook.Gradebook.model.entity.Grade;
import com.gradebook.Gradebook.model.entity.Subject;

import java.util.List;

public interface ISubjectService {
    SubjectDTO saveSubject(SubjectDTO payload);
    void updateSubject(Long id, SubjectDTO gradeDTO);
    void deleteSubject(Long id);
    SubjectDTO getSubjectById(Long id);
    Subject findSubjectById(Long id);
    Subject getSubjectByName(String name);
    List<SubjectDTO> getAllSubjects();
    SubjectDTO convertToDTO(Subject subject);
    List<SubjectDTO> getSubjectsByIds(List<Long> subjectIds);
}
