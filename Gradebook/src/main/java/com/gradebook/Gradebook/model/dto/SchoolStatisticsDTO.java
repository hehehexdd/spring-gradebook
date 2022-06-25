package com.gradebook.Gradebook.model.dto;

public class SchoolStatisticsDTO {

    private Long id;
    private String schoolName;
    private int totalTeachers;
    private int totalStudents;
    private double averageGrade;

    public SchoolStatisticsDTO() {
    }

    public SchoolStatisticsDTO(Long id, String schoolName, int totalTeachers, int totalStudents, double averageGrade) {
        this.id = id;
        this.schoolName = schoolName;
        this.totalTeachers = totalTeachers;
        this.totalStudents = totalStudents;
        this.averageGrade = averageGrade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public int getTotalTeachers() {
        return totalTeachers;
    }

    public void setTotalTeachers(int totalTeachers) {
        this.totalTeachers = totalTeachers;
    }

    public int getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(int totalStudents) {
        this.totalStudents = totalStudents;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }
}
