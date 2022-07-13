package com.gradebook.Gradebook.auth.dto;

import com.gradebook.Gradebook.model.entity.RoleType;

public class JwtResponse {
    private Long userId;
    private RoleType role;
    private boolean accountLocked;
    private String jwtToken;

    public JwtResponse() {
    }

    public JwtResponse(Long userId, RoleType role, boolean accountLocked,  String jwtToken) {
        this.userId = userId;
        this.role = role;
        this.accountLocked = accountLocked;
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

    public boolean isAccountLocked() {
        return accountLocked;
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

    public void setAccountLocked(boolean accountLocked) {
        this.accountLocked = accountLocked;
    }
}
