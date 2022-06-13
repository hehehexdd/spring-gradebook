package com.gradebook.Gradebook.data.service;

import com.gradebook.Gradebook.data.entity.Role;
import com.gradebook.Gradebook.data.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepo roleRepo;

    public RoleServiceImpl(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }
}
