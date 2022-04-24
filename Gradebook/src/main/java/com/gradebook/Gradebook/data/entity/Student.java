package com.gradebook.Gradebook.data.entity;


import javax.persistence.*;
import java.util.*;

@Entity
@PrimaryKeyJoinColumn(name = "idStudent")
public class Student extends AppUser{

    private String FirstName;
    private String LastName;

//    @ManyToOne
//    private School school;
//
    @Enumerated(value = EnumType.STRING)
    private SClass SClass;
//
//    @ManyToMany
//    private Set<Parent> parents;
//    @ManyToMany
//    private List<Absence> absences;
//    @OneToMany
//    private List<Grade> grades;


    public Student(String username,
                   String email,
                   String password,
                   boolean isAccountLocked,
                   String firstName,
                   String lastName,
                   School school,
                   Role role,
                   SClass SClass
                   //Set<Parent> parents,
                   //List<Absence> absences,
                   /*List<Grade> grades*/) {
        super(username, email, password, role, isAccountLocked);
        FirstName = firstName;
        LastName = lastName;
//        this.school = school;
        this.SClass = SClass;
//        this.parents = parents;
//        this.absences = absences;
//        this.grades = grades;
    }

    public Student(String username,
                   String email,
                   String password,
                   boolean isAccountLocked,
                   String firstName,
                   String lastName,
                   //School school,
                   Role role,
                   SClass SClass) {
        super(username, email, password, role, isAccountLocked);
        FirstName = firstName;
        LastName = lastName;
//        this.school = school;
//        this.SClass = SClass;
//        this.parents = new HashSet<>();
//        this.absences = new ArrayList<>();
//        this.grades = new ArrayList<>();
    }

    //Getters
    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }


//    public School getSchool() {
//        return school;
//    }
//
    public SClass getSClass() {
        return SClass;
    }
//
//    public Set<Parent> getParents() {
//        return parents;
//    }
//
//    public List<Absence> getAbsences() {
//        return absences;
//    }
//
//    public List<Grade> getGrades() {
//        return grades;
//    }


    //Setters
    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

//    public void setSchool(School school) {
//        this.school = school;
//    }
//
    public void setSClass(SClass SClass) {
        this.SClass = SClass;
    }
//
//    public void setParents(Set<Parent> parents) {
//        this.parents = parents;
//    }
//
//    public void setAbsences(List<Absence> absences) {
//        this.absences = absences;
//    }
//
//    public void setGrades(List<Grade> grades) {
//        this.grades = grades;
//    }
}
