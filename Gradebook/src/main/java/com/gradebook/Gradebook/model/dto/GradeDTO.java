package com.gradebook.Gradebook.model.dto;

import java.time.LocalDate;

public class GradeDTO {
    private Long id;
    private String subject;
    private Integer grade;
    private Long studentId;
    private String studentName;
    private Long teacherId;
    private String teacherName;
    private LocalDate date;

    public GradeDTO() {
    }

    public GradeDTO(Long id, String subject, Integer grade,
                    Long studentId, String studentName,
                    Long teacherId, String teacherName, LocalDate date) {
        this.id = id;
        this.subject = subject;
        this.grade = grade;
        this.studentId = studentId;
        this.studentName = studentName;
        this.teacherId = teacherId;
        this.teacherName = teacherName;
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

    public String getStudentName() {
        return studentName;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public String getTeacherName() {
        return teacherName;
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

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
