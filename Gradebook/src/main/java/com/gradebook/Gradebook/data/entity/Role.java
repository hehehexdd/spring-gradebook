package com.gradebook.Gradebook.data.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String authority;

    @OneToMany(mappedBy = "role")
    private Set<AppUser> users;

    //Constructors
    public Role() {
    }

    public Role(String authority) {
        this.id = null;
        this.authority = authority;
        this.users = new HashSet<>();
    }

    public Role(String authority, Set<AppUser> users) {
        this.id = null;
        this.authority = authority;
        this.users = users;
    }

    //Getters
    public Long getId() {
        return id;
    }

    public Set<AppUser> getUser() {
        return users;
    }

    //Setters
    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public void setStudent(Set<AppUser> users) {
        this.users = users;
    }
}
