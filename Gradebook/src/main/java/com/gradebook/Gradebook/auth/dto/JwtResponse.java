package com.gradebook.Gradebook.auth.dto;

import com.gradebook.Gradebook.model.entity.RoleType;

public class JwtResponse {
    private Long userId;
    private RoleType role;
    private String jwtToken;

    public JwtResponse() {
    }

    public JwtResponse(Long userId, RoleType role,  String jwtToken) {
        this.userId = userId;
        this.role = role;
        this.jwtToken = jwtToken;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public Long getUserId() {
        return userId;
    }

    public RoleType getRole() {
        return role;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }
}
