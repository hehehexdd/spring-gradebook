package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.entity.AppUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IAppUserService extends UserDetailsService {
    AppUser saveUser(AppUser user);
    void updateUser(AppUser user);
    void deleteUser(Long id);
    void addRoleToUser(String username, String role);
    AppUser getUser(String username);
    //AppUserDTO convertToDTO(AppUser user);
    //AppUser convertToEntity(AppUserDTO userDTO);
    List<AppUser> getAllUsers();
}
