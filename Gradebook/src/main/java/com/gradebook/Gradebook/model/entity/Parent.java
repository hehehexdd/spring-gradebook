package com.gradebook.Gradebook.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.List;


@Entity
@PrimaryKeyJoinColumn(name = "parentId")
public class Parent extends AppUser{

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @OneToMany
    private List<Student> kids;

    public Parent() {
    }

    public Parent(String username, String email, String password, RoleType role, boolean isAccountLocked, String firstName, String lastName, List<Student> kids) {
        super(username, email, password, role, isAccountLocked);
        this.firstName = firstName;
        this.lastName = lastName;
        this.kids = kids;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Student> getKids() {
        return kids;
    }

    public void setKids(List<Student> kids) {
        this.kids = kids;
    }
}
