package com.gradebook.Gradebook.model.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "absences")
public class Absence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Subject subject;

    @ManyToOne
    private Teacher teacher;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    public Absence() {
    }

    public Absence(Long id, Student student, Subject subject, Teacher teacher, LocalDate date) {
        this.id = id;
        this.student = student;
        this.subject = subject;
        this.teacher = teacher;
        this.date = date;
    }

    //Getters
    public Long getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public Subject getSubject() {
        return subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public LocalDate getDate() {
        return date;
    }

    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
