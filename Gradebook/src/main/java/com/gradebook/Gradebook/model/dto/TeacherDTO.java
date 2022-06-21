package com.gradebook.Gradebook.model.dto;

public class TeacherDTO  {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private Long schoolId;
    //To-do add variable for class teacher, update constructor and methods for it


    public TeacherDTO() {
    }

    public TeacherDTO(Long id, String firstName, String lastName, String username, Long schoolId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.schoolId = schoolId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }
}
