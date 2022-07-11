package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.dto.AppUserDTO;
import com.gradebook.Gradebook.model.dto.RegisterDTO;
import com.gradebook.Gradebook.model.entity.AppUser;
import com.gradebook.Gradebook.model.entity.RoleType;
import com.gradebook.Gradebook.repo.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AppUserService implements IAppUserService, UserDetailsService {

    @Autowired
    private AppUserRepo userRepo;

    public AppUserService(AppUserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = userRepo.findByUsername(username);
        if(user == null) {
            System.out.println(("Wrong credentials!"));
            throw new UsernameNotFoundException("Wrong credentials!");
        }
        else {
            System.out.println(("User found id DB" + username));
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().toString()));

        return new User(user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public AppUser saveUser(RegisterDTO userDTO) {
        AppUser user = new AppUser(
                userDTO.getUsername(),
                userDTO.getEmail(),
                userDTO.getPassword(),
                RoleType.ADMIN,
                false);
        return userRepo.save(user);
    }

    @Override
    public void updateUser(Long id, AppUserDTO payload) {
        AppUser tmp;
        tmp = userRepo.findByUsername(payload.getUsername());
        //tmp.setEmail(user.getEmail());
        tmp.setAccountLocked(payload.isAccountLocked());
        userRepo.save(tmp);
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById((id));
    }

    @Override
    public void addRoleToUser(String username, String role) {
        AppUser user = userRepo.findByUsername(username);
        user.setRole(RoleType.valueOf(role));
    }

    @Override
    public AppUser getUser(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public AppUser getUserById(Long id) {
        return userRepo.getById(id);
    }

    @Override
    public List<AppUserDTO> getAllUsers() {
        List<AppUser> users = userRepo.findAll();
        List<AppUserDTO> userDTOS = new ArrayList<>();

        for(AppUser d : users) {
            AppUserDTO deliveryDTO = this.convertToDTO(d);
            userDTOS.add(deliveryDTO);
        }
        return userDTOS;
    }

    @Override
    public AppUserDTO convertToDTO(AppUser user) {
        AppUserDTO userDTO = new AppUserDTO();
        if(user != null) {
            userDTO.setId(user.getId());
            userDTO.setUsername(user.getUsername());
            userDTO.setEmail(user.getEmail());
            userDTO.setRole(user.getRole().toString());
            userDTO.setAccountLocked(user.isAccountLocked());
        }
        return userDTO;
    }

    @Override
    public AppUser convertToEntity(AppUserDTO userDTO) {
        AppUser user = new AppUser();
        if(userDTO != null) {
            user.setId(userDTO.getId());
            user.setUsername(userDTO.getUsername());
            user.setEmail(userDTO.getEmail());
            user.setPassword(userRepo.findByUsername(user.getUsername()).getPassword());
            user.setRole(RoleType.valueOf(userDTO.getRole()));
        }
        return user;
    }



}
