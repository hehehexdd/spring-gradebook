package com.gradebook.Gradebook.controller;

import com.gradebook.Gradebook.model.entity.AppUser;
import com.gradebook.Gradebook.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/users")
public class AppUserController {

    @Autowired
    private IAppUserService userService;

    public AppUserController(IAppUserService userService) {
        this.userService = userService;
    }

    @PostMapping(path="/register")
    public void register(@RequestBody AppUser user) {
        userService.saveUser(user);
    }

    @GetMapping(path="/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        AppUser user = userService.getUser(username);
        if(user == null || !user.getPassword().equals(password)) {
            return "Invalid user or password!";
        }
        else {
            return "Login successful! Welcome back, " + user.getUsername() + "!";
        }
    }

    @GetMapping(path="/all")
    public List<AppUser> getUsers() {
        return userService.getAllUsers();
    }

}
