package com.gradebook.Gradebook.model.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "grades")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "subjectId")
    private Subject subject;

    private Integer grade;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "teacherId")
    private Teacher teacher;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    public Grade() {
    }

    public Grade(Subject subject, Integer grade, Student student, LocalDate date) {
        this.subject = subject;
        this.grade = grade;
        this.student = student;
        this.date = date;
    }

    public Grade(Subject subject, Integer grade, Student student, Teacher teacher, LocalDate date) {
        this.subject = subject;
        this.grade = grade;
        this.student = student;
        this.teacher = teacher;
        this.date = date;
    }

    //Getters
    public Long getId() {
        return id;
    }

    public Subject getSubject() {
        return subject;
    }


    public Integer getGrade() {
        return grade;
    }

    public Student getStudent() {
        return student;
    }

//    public Teacher getTeacher() {
//        return teacher;
//    }

    public LocalDate getDate() {
        return date;
    }

    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }


    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

//    public void setTeacher(Teacher teacher) {
//        this.teacher = teacher;
//    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
