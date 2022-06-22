package com.gradebook.Gradebook.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "user_id")
public class Teacher extends AppUser{
    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @ManyToOne
    private School school;

    @OneToMany(mappedBy = "teacher")
    private List<ClassTeachers> classTeachers;

    public Teacher(){

    }

    public Teacher(String username, String email, String password, RoleType role, boolean isAccountLocked, String firstName, String lastName, School school, List<ClassTeachers> classTeachers) {
        super(username, email, password, role, isAccountLocked);
        this.firstName = firstName;
        this.lastName = lastName;
        this.school = school;
        this.classTeachers = classTeachers;
    }

    public Teacher(String username, String email, String password, RoleType role, boolean isAccountLocked, String firstName, String lastName, School school) {
        super(username, email, password, role, isAccountLocked);
        this.firstName = firstName;
        this.lastName = lastName;
        this.school = school;
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

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public List<ClassTeachers> getClassTeachers() {
        return classTeachers;
    }

    public void setClassTeachers(List<ClassTeachers> classTeachers) {
        this.classTeachers = classTeachers;
    }
}
