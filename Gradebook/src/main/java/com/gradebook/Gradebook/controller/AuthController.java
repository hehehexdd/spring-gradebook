package com.gradebook.Gradebook.controller;

import com.gradebook.Gradebook.auth.dto.JwtRequest;
import com.gradebook.Gradebook.auth.dto.JwtResponse;
import com.gradebook.Gradebook.config.JwtUtility;
import com.gradebook.Gradebook.model.entity.AppUser;
import com.gradebook.Gradebook.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4202")
@RestController
@RequestMapping(path = "/")
public class AuthController {

    @Autowired
    private JwtUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IAppUserService userService;

    @PostMapping("/authenticate")
    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception{

        try {
            AppUser user = userService.getUser(jwtRequest.getUsername());
            if(passwordEncoder.matches(jwtRequest.getPassword(), user.getPassword())) {
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                jwtRequest.getUsername(),
                                user.getPassword()
                        )
                );
            }
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid Credentials!", e);
        }

        final UserDetails userDetails = userService.loadUserByUsername(jwtRequest.getUsername());
        final String token = jwtUtility.generateToken(userDetails);

        return  new JwtResponse(token);
    }

}
