package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.dto.SubjectDTO;
import com.gradebook.Gradebook.model.entity.Subject;
import com.gradebook.Gradebook.repo.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SubjectService implements ISubjectService{

    @Autowired
    private final SubjectRepo subjectRepo;

    public SubjectService(SubjectRepo subjectRepo) {
        this.subjectRepo = subjectRepo;
    }

    @Override
    public Subject saveSubject(Subject subject) {
        return subjectRepo.save(subject);
    }

    @Override
    public void updateSubject(SubjectDTO subjectDTO) {
        Subject tmp = subjectRepo.getById(subjectDTO.getId());
        tmp.setName(subjectDTO.getName());
        subjectRepo.save(tmp);
    }

    @Override
    public void deleteSubject(Long id) {
        subjectRepo.deleteById(id);
    }

    @Override
    public SubjectDTO getSubjectById(Long id) {
        return this.convertToDTO(subjectRepo.getById(id));
    }

    @Override
    public Subject getSubjectByName(String name) {
        return subjectRepo.findByName(name);
    }

    @Override
    public List<SubjectDTO> getAllSubjects() {
        return subjectRepo.findAll()
                .stream().map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SubjectDTO convertToDTO(Subject subject) {
        SubjectDTO subjectDTO = new SubjectDTO();

        if (subject != null) {
            subjectDTO.setId(subject.getId());
            subjectDTO.setName(subject.getName());
        }
        return subjectDTO;
    }
}
