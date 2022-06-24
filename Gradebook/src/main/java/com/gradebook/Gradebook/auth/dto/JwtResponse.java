package com.gradebook.Gradebook.auth.dto;

public class JwtResponse {
    private Long userId;
    private String jwtToken;

    public JwtResponse() {
    }

    public JwtResponse(Long userId, String jwtToken) {
        this.userId = userId;
        this.jwtToken = jwtToken;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
