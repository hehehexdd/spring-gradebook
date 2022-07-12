package com.gradebook.Gradebook.model.dto;

import java.time.LocalDate;

public class AbsenceDTO {
    private Long id;
    private Long studentId;
    private String studentName;
    private String subject;
    private Long teacherId;
    private String teacherName;
    private LocalDate date;

    public AbsenceDTO() {
    }

    public AbsenceDTO(Long id, Long studentId, String studentName,
                      String subject, Long teacherId, String teacherName,
                      LocalDate date) {
        this.id = id;
        this.studentId = studentId;
        this.studentName = studentName;
        this.subject = subject;
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.date = date;
    }

    //Getters
    public Long getId() {
        return id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
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

    public String getTeacherName() {
        return teacherName;
    }

    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
