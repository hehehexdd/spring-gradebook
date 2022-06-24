package com.gradebook.Gradebook.model.dto;

public class AppUserDTO {
    private Long id;
    private String username;
    private String email;
    private String role;
    private boolean accountLocked;

    public AppUserDTO() {
    }

    public AppUserDTO(Long id, String username, String email, String role, boolean isAccountLocked) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.role = role;
        this.accountLocked = isAccountLocked;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public boolean isAccountLocked() {
        return accountLocked;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setAccountLocked(boolean accountLocked) {
        accountLocked = accountLocked;
    }


    @Override
    public String toString() {
        return "AppUserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", isAccountLocked=" + accountLocked +
                '}';
    }
}
