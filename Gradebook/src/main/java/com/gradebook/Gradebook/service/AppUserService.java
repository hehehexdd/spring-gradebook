package com.gradebook.Gradebook.service;

import com.gradebook.Gradebook.model.entity.AppUser;
import com.gradebook.Gradebook.model.entity.RoleType;
import com.gradebook.Gradebook.repo.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
    public AppUser saveUser(AppUser user) {
        user.setAccountLocked(true);
        return userRepo.save(user);
    }

    @Override
    public void updateUser(AppUser user) {
        AppUser tmp;
        tmp = userRepo.findByUsername(user.getUsername());
        tmp.setEmail(user.getEmail());
        tmp.setPassword(user.getPassword());
        tmp.setAccountLocked(user.isAccountLocked());
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
    public List<AppUser> getAllUsers() {
        return userRepo.findAll();
    }


}
