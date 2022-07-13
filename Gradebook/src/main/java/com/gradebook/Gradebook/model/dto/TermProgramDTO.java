package com.gradebook.Gradebook.model.dto;

import com.gradebook.Gradebook.model.entity.WeekDay;

public class TermProgramDTO {

    private Long id;

    private String timestamp;
    private WeekDay weekDay;

    private Long classTeacherId;
    private Long classId;
    private String className;
    private Long teacherId;
    private String teacherName;
    private Long subjectId;
    private String subjectName;

    public TermProgramDTO(Long id, String timestamp, WeekDay weekDay, Long classTeacherId,
                          Long classId, String className,
                          Long teacherId, String teacherName,
                          Long subjectId, String subjectName) {
        this.id = id;
        this.timestamp = timestamp;
        this.weekDay = weekDay;
        this.classTeacherId = classTeacherId;
        this.classId = classId;
        this.className = className;
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }

    public TermProgramDTO(Long id, String timestamp, WeekDay weekDay, Long classId, Long teacherId, Long subjectId) {
        this.id = id;
        this.timestamp = timestamp;
        this.weekDay = weekDay;
        this.classId = classId;
        this.teacherId = teacherId;
        this.subjectId = subjectId;
    }

    public Long getClassTeacherId() {
        return classTeacherId;
    }

    public void setClassTeacherId(Long classTeacherId) {
        this.classTeacherId = classTeacherId;
    }

    public TermProgramDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public WeekDay getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(WeekDay weekDay) {
        this.weekDay = weekDay;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
