package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.dto.AppUserDTO;
import com.gradebook.Gradebook.model.dto.RegisterDTO;
import com.gradebook.Gradebook.model.entity.AppUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IAppUserService extends UserDetailsService {
    AppUserDTO saveUser(RegisterDTO userDTO);
    void updateUser(Long id, AppUserDTO payload);
    void deleteUser(Long id);
    AppUser getUser(String username);
    AppUser getUserById(Long id);
    List<AppUserDTO> getAllUsers();
    AppUserDTO convertToDTO(AppUser user);
}
