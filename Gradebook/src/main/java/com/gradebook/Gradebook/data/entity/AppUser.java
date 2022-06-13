package com.gradebook.Gradebook.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "role")
    private Role role;
//    @Enumerated(value = EnumType.STRING)
//    private Role role;

    @Column(name = "isAccLocked", nullable = false)
    private boolean isAccountLocked;

    //Constructors
    public AppUser() {
    }
    public AppUser(String username, String email, String password, Role role) {
        this.id = null;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.isAccountLocked = true;
    }

    public AppUser(String username, String email, String password, Role role, boolean isAccountLocked) {
        this.id = null;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.isAccountLocked = isAccountLocked;
    }

    //Getters
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public boolean isAccountLocked() {
        return isAccountLocked;
    }

    //Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setAccountLocked(boolean accountLocked) {
        isAccountLocked = accountLocked;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isAccountLocked=" + isAccountLocked +
                '}';
    }
}
