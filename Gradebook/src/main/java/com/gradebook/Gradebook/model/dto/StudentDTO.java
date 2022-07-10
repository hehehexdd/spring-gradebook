package com.gradebook.Gradebook.model.dto;

import com.gradebook.Gradebook.model.entity.SClass;

public class StudentDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String schoolName;
    private SClass schoolClass;
    private Long sclassId;

    public StudentDTO() {
    }

    public StudentDTO(Long id, String firstName, String lastName, String schoolName, SClass schoolClass, Long sclassId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.schoolName = schoolName;
        this.schoolClass = schoolClass;
        this.sclassId = sclassId;
    }

    //Getters
    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public SClass getSchoolClass() {
        return schoolClass;
    }

    public Long getSclassId() {
        return sclassId;
    }

    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public void setSchoolClass(SClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    public void setSclassId(Long sclassId) {
        this.sclassId = sclassId;
    }
}
