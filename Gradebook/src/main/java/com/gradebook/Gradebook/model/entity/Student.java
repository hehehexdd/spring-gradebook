package com.gradebook.Gradebook.model.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "idStudent")
public class Student extends AppUser{

    @Column(nullable = false)
    private String FirstName;

    @Column(nullable = false)
    private String LastName;

    @ManyToOne
    private School school;

    @ManyToOne
    @JoinColumn(name = "classId")
    private SchoolClass schoolClass;

    @Enumerated(value = EnumType.STRING)
    private SClass SClass;

    @OneToMany(mappedBy = "studentClass")
    private List<ClassTeachers> classTeachers;


    @ManyToMany(mappedBy = "kids")
    private List<Parent> parents;

    @ManyToMany
    private List<Absence> absences;

    @OneToMany(mappedBy = "student")
    private List<Grade> grades;


    public Student(String username,
                   String email,
                   String password,
                   boolean isAccountLocked,
                   String firstName,
                   String lastName,
                   School school,
                   SchoolClass schoolClass,
                   RoleType role,
                   SClass SClass,
                   List<Parent> parents,
                   List<Absence> absences,
                   List<Grade> grades) {
        super(username, email, password, role, isAccountLocked);
        FirstName = firstName;
        LastName = lastName;
        this.school = school;
        this.schoolClass = schoolClass;
        this.SClass = SClass;
        this.parents = parents;
        this.absences = absences;
        this.grades = grades;
    }

    public Student(String username,
                   String email,
                   String password,
                   boolean isAccountLocked,
                   String firstName,
                   String lastName,
                   School school,
                   SchoolClass schoolClass,
                   RoleType role,
                   SClass SClass) {
        super(username, email, password, role, isAccountLocked);
        FirstName = firstName;
        LastName = lastName;
        this.school = school;
        this.schoolClass = schoolClass;
        this.SClass = SClass;
        this.parents = new ArrayList<>();
        this.absences = new ArrayList<>();
        this.grades = new ArrayList<>();
    }

    public Student() {
    }

    //Getters
    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public School getSchool() {
        return school;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public SClass getSClass() {
        return SClass;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public List<Absence> getAbsences() {
        return absences;
    }

    public List<Grade> getGrades() {
        return grades;
    }


    //Setters
    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    public void setSClass(SClass SClass) {
        this.SClass = SClass;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public void setAbsences(List<Absence> absences) {
        this.absences = absences;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public void addGrade(Grade grade) {
        if (!grades.contains(grade)) {
            grades.add(grade);
        }
    }
}
