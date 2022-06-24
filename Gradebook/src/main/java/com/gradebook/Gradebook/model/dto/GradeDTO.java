package com.gradebook.Gradebook.model.dto;

import java.time.LocalDate;

public class GradeDTO {
    private Long id;
    private String subject;
    private Integer grade;
    private Long studentId;
    private Long teacherId;
    private LocalDate date;

    public GradeDTO() {
    }

    public GradeDTO(Long id, String subject, Integer grade, Long studentId, Long teacherId, LocalDate date) {
        this.id = id;
        this.subject = subject;
        this.grade = grade;
        this.studentId = studentId;
        this.teacherId = teacherId;
        this.date = date;
    }

    //Getters
    public Long getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public Integer getGrade() {
        return grade;
    }

    public Long getStudentId() {
        return studentId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public LocalDate getDate() {
        return date;
    }

    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
