package com.gradebook.Gradebook.model.entity;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "subject")
    private List<ClassTeachers> classTeachers;

    @OneToMany(mappedBy = "subject")
    private List<Grade> grades;

    public Subject(String name) {
        this.id = null;
        this.name = name;
        this.classTeachers = new ArrayList<>();
        this.grades = new ArrayList<>();
    }

    public Subject() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ClassTeachers> getClassTeachers() {
        return classTeachers;
    }

    public void setClassTeachers(List<ClassTeachers> classTeachers) {
        this.classTeachers = classTeachers;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }
}
