package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.dto.ParentDTO;
import com.gradebook.Gradebook.model.entity.Parent;
import com.gradebook.Gradebook.repo.ParentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class ParentService implements IParentService{

    @Autowired
    private final ParentRepo parentRepo;

    public ParentService(ParentRepo parentRepo) {
        this.parentRepo = parentRepo;
    }

    @Override
    public Parent save(Parent parent) {
        return this.parentRepo.save(parent);
    }

    @Override
    public void update(Parent parent) {
        this.parentRepo.save(parent);
    }

    @Override
    public void delete(Long id) {
        Parent parent = this.parentRepo.getById(id);
        this.parentRepo.delete(parent);
    }

    @Override
    public ParentDTO getById(Long id) {
        Parent parent = this.parentRepo.getById(id);
        return this.convertToDTO(parent);
    }

    @Override
    public List<ParentDTO> getAll() {

        List<ParentDTO> parentDTOs = new ArrayList<>();

        this.parentRepo.findAll().forEach(parent ->
                parentDTOs.add(convertToDTO(parent))
        );

        return parentDTOs;
    }

    @Override
    public ParentDTO convertToDTO(Parent parent) {
        ParentDTO parentDTO = new ParentDTO();

        if (parent != null) {
            parentDTO.setId(parent.getId());
            parentDTO.setFirstName(parent.getFirstName());
            parentDTO.setLastName(parent.getLastName());
            parentDTO.setUsername(parent.getUsername());

            parentDTO.setChildrenUsernames(parent.getKids().stream().map(kid->kid.getUsername()).collect(Collectors.toList()));
        }

        return parentDTO;
    }
}
