package com.gradebook.Gradebook.model.entity;

import javax.persistence.*;

@Entity
public class TermProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "termProgram")
    private ClassTeachers classTeachers;

    private String timestamp;

    @Enumerated(value = EnumType.STRING)
    private WeekDay weekDay;

    public TermProgram() {
    }

    public TermProgram(ClassTeachers classTeachers, String timestamp, WeekDay weekDay) {
        this.classTeachers = classTeachers;
        this.timestamp = timestamp;
        this.weekDay = weekDay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClassTeachers getClassTeachers() {
        return classTeachers;
    }

    public void setClassTeachers(ClassTeachers classTeachers) {
        this.classTeachers = classTeachers;
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
}
