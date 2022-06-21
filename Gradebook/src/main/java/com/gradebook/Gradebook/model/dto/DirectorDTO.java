package com.gradebook.Gradebook.model.dto;

public class DirectorDTO {

    private Long id;
    private String name;
    private String username;
    private String school;

    public DirectorDTO() {

    }

    public DirectorDTO(Long id, String name, String username, String school) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.school = school;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", school='" + school + '\'' +
                '}';
    }
}
