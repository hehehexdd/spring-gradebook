package com.gradebook.Gradebook.controller;

import com.gradebook.Gradebook.config.GradebookCommon;
import com.gradebook.Gradebook.model.dto.AppUserDTO;
import com.gradebook.Gradebook.model.dto.RegisterDTO;
import com.gradebook.Gradebook.model.entity.AppUser;
import com.gradebook.Gradebook.model.entity.RoleType;
import com.gradebook.Gradebook.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4202")
@RestController
@RequestMapping(path = GradebookCommon.APPUSER_BASE_URI)
public class AppUserController {

    @Autowired
    private final IAppUserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AppUserController(IAppUserService userService) {
        this.userService = userService;
    }

    @PostMapping(path="/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody RegisterDTO userDTO) {
        AppUser user = new AppUser(
                userDTO.getUsername(),
                userDTO.getEmail(),
                this.passwordEncoder.encode(userDTO.getPassword()),
                userDTO.getRole(),
                userDTO.isAccountLocked());
        userService.saveUser(user);
    }

    //TODO put authentication in AppUser controller

    @GetMapping(path = "/all")
    public List<AppUserDTO> getAppUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "/{id}")
    public AppUserDTO getAppUserById(@PathVariable("id") Long id) {
        //return new AppUserDTO(Long.valueOf(1),"GET", "GET","GET",true);
        AppUser user = this.userService.getUserById(id);
        return userService.convertToDTO(user);
    }

    @PatchMapping(path = "/{id}")
    public AppUserDTO updateAppUserById(@PathVariable("id") Long id, @RequestBody AppUserDTO payload) {
        //return new AppUserDTO(Long.valueOf(1), "PATCH", "PATCH", "PATCH", true);
        AppUser user = userService.getUserById(id);
        user.setEmail(payload.getEmail());
        user.setAccountLocked(payload.isAccountLocked());
        user.setRole(RoleType.valueOf(payload.getRole()));
        userService.saveUser(user);
        return userService.convertToDTO(userService.getUserById(id));
    }

    @DeleteMapping(path = "/{id}")
    public void deleteAppUserById(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

}
