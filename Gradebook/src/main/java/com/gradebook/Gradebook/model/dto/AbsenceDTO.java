package com.gradebook.Gradebook.model.dto;

import java.time.LocalDate;

public class AbsenceDTO {
    private Long id;
    private Long studentId;
    private Long subjectId;
    private LocalDate date;

    public AbsenceDTO() {
    }

    public AbsenceDTO(Long id, Long studentId, Long subjectId, LocalDate date) {
        this.id = id;
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.date = date;
    }

    //Getters
    public Long getId() {
        return id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public LocalDate getDate() {
        return date;
    }

    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
