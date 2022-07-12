package com.gradebook.Gradebook.model.dto;

public class DirectorDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String school;

    private Long schoolId;

    public DirectorDTO() {
    }

    public DirectorDTO(Long id, String firstName, String secondName, String username, String school, Long schoolId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = secondName;
        this.username = username;
        this.school = school;
        this.schoolId = schoolId;
    }

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "DirectorDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", school='" + school + '\'' +
                '}';
    }
}
