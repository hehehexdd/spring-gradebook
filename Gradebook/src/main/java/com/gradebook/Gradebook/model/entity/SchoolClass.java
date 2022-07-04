package com.gradebook.Gradebook.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "schoolClass")
public class SchoolClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "className", nullable = false)
    private String name;

    @Enumerated(value = EnumType.STRING)
    private SClass classYear;

    @OneToMany
    private List<Student> students;

    @OneToMany
    private List<ClassTeachers> classTeachers;

    public SchoolClass() {
    }

    public SchoolClass(String name, SClass classYear, List<Student> students, List<ClassTeachers> classTeachers) {
        this.id = null;
        this.name = name;
        this.classYear = classYear;
        this.students = students;
        this.classTeachers = classTeachers;
    }

    public SchoolClass(Long id, String name, SClass classYear) {
        this.id = id;
        this.name = name;
        this.classYear = classYear;
        this.students = new ArrayList<>();
        this.classTeachers = new ArrayList<>();
    }

    //Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public SClass getClassYear() {
        return classYear;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<ClassTeachers> getClassTeachers() {
        return classTeachers;
    }

    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClassYear(SClass classYear) {
        this.classYear = classYear;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void setClassTeachers(List<ClassTeachers> classTeachers) {
        this.classTeachers = classTeachers;
    }
}
