package com.gradebook.Gradebook.model.dto;

public class TeacherCourcesDTO {
    private Long teacherId;
    private String courseName;
    private Long courseId;

    public TeacherCourcesDTO() {
    }

    public TeacherCourcesDTO(Long teacherId, String courseName, Long courseId) {
        this.teacherId = teacherId;
        this.courseName = courseName;
        this.courseId = courseId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}
