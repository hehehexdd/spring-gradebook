package com.gradebook.Gradebook.model.dto;

import java.time.LocalDate;

public class AbsenceDTO {
    private Long id;
    private Long studentId;
    private String subject;
    private Long teacherId;
    private LocalDate date;

    public AbsenceDTO() {
    }

    public AbsenceDTO(Long id, Long studentId, String subject, Long teacherId, LocalDate date) {
        this.id = id;
        this.studentId = studentId;
        this.subject = subject;
        this.teacherId = teacherId;
        this.date = date;
    }

    //Getters
    public Long getId() {
        return id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public String getSubject() {
        return subject;
    }

    public LocalDate getDate() {
        return date;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }
}
