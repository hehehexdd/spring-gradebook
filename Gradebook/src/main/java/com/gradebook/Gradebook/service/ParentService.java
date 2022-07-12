package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.dto.ParentDTO;
import com.gradebook.Gradebook.model.dto.RegisterDTO;
import com.gradebook.Gradebook.model.entity.*;
import com.gradebook.Gradebook.repo.ParentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    private final IStudentService studentService;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    public ParentService(ParentRepo parentRepo, StudentService studentService, PasswordEncoder passwordEncoder) {

        this.parentRepo = parentRepo;
        this.studentService = studentService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ParentDTO update(Long parentId, ParentDTO payload) {
        Parent parent = this.findById(parentId);
        if(payload == null){
            return this.convertToDTO(parent);
        }

        List<Long> childrenIds = payload.getChildrenIds();

        if(payload.getFirstName()!= null){
            parent.setFirstName(payload.getFirstName());
        }
        if(payload.getLastName()!= null){
            parent.setLastName(payload.getLastName());
        }
        if(!childrenIds.isEmpty()){
            System.out.println("child array is not empty");
            List<Student> children = new ArrayList<>();
            childrenIds.forEach((id)-> children.add(this.studentService.findById(id)));
            parent.setKids(children);
        }
        this.parentRepo.save(parent);
        return this.convertToDTO(parent);
    }

    @Override
    public ParentDTO createParent(RegisterDTO user) {

        Parent parent = new Parent(
                user.getUsername(),
                user.getEmail(),
                this.passwordEncoder.encode(user.getPassword()),
                RoleType.PARENT,
                true,
                user.getFirstName(),
                user.getLastName()
        );

        this.parentRepo.save(parent);

        return this.convertToDTO(parent);
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
    public Parent findById(Long id) {
        return this.parentRepo.getById(id);
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

            parentDTO.setChildrenIds(parent.getKids().stream().map(AppUser::getId).collect(Collectors.toList()));
        }

        return parentDTO;
    }
}
