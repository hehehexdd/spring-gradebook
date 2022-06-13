package com.gradebook.Gradebook.data.service;

import com.gradebook.Gradebook.data.entity.AppUser;
import com.gradebook.Gradebook.data.entity.Role;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface AppUserService extends UserDetailsService {
    AppUser saveUser(AppUser user);
    void updateUser(AppUser user);
    void deleteUser(Long id);
    void addRoleToUser(String username, Role role);
    AppUser getUser(String username);
    //AppUserDTO convertToDTO(AppUser user);
    //AppUser convertToEntity(AppUserDTO userDTO);
    List<AppUser> getAllUsers();
}
