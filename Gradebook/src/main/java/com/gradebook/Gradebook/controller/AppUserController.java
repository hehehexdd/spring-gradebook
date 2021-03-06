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
    public AppUserDTO register(@RequestBody RegisterDTO userDTO) {
        userDTO.setPassword(this.passwordEncoder.encode(userDTO.getPassword()));
        return userService.saveUser(userDTO);
    }

    @GetMapping(path = "/all")
    public List<AppUserDTO> getAppUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "/{id}")
    public AppUserDTO getAppUserById(@PathVariable("id") Long id) {
        AppUser user = this.userService.getUserById(id);
        return userService.convertToDTO(user);
    }

    @PatchMapping(path = "/{id}")
    public AppUserDTO updateAppUserById(@PathVariable("id") Long id, @RequestBody AppUserDTO payload) {
        this.userService.updateUser(id, payload);
        return userService.convertToDTO(userService.getUserById(id));
    }

    @DeleteMapping(path = "/{id}")
    public void deleteAppUserById(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

}
