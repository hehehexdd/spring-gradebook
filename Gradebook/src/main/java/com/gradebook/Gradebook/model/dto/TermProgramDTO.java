package com.gradebook.Gradebook.model.dto;

import com.gradebook.Gradebook.model.entity.WeekDay;

public class TermProgramDTO {

    private Long id;

    private String timestamp;
    private WeekDay weekDay;

    private Long classTeacherId;
    private Long classId;
    private Long teacherId;
    private Long subjectId;

    public TermProgramDTO(Long id, String timestamp, WeekDay weekDay, Long classTeacherId, Long classId, Long teacherId, Long subjectId) {
        this.id = id;
        this.timestamp = timestamp;
        this.weekDay = weekDay;
        this.classTeacherId = classTeacherId;
        this.classId = classId;
        this.teacherId = teacherId;
        this.subjectId = subjectId;
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
}
