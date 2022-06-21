package com.gradebook.Gradebook.model.entity;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "idDirector")
public class Director extends AppUser{

    @Column(nullable = false, length = 30)
    private String firstName;

    @Column(nullable = false, length = 30)
    private String lastName;

    @OneToOne
    @JoinColumn(name = "schoolId", referencedColumnName = "id", nullable = false)
    private School school;

    public Director(String username, String email, String password, RoleType role, boolean isAccountLocked, String firstName, String secondName, School school) {
        super(username, email, password, role, isAccountLocked);
        this.firstName = firstName;
        this.lastName = secondName;
        this.school = school;
    }

    public Director() {

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

    public void setLastName(String secondName) {
        this.lastName = secondName;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Director{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + lastName + '\'' +
                ", school=" + school.getName() +
                '}';
    }
}
