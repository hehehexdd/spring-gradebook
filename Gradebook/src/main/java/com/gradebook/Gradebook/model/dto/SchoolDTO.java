package com.gradebook.Gradebook.model.dto;

import java.util.List;

public class SchoolDTO {

    private long id;
    private String address;
    private String name;
    private String directorUsername;
    private List<String> studentUsernames;

    public SchoolDTO() {
    }

    public SchoolDTO(long id, String address, String name, String directorUsername, List<String> studentUsernames) {
        this.id = id;
        this.address = address;
        this.name = name;
        this.directorUsername = directorUsername;
        this.studentUsernames = studentUsernames;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirectorUsername() {
        return directorUsername;
    }

    public void setDirectorUsername(String directorUsername) {
        this.directorUsername = directorUsername;
    }

    public List<String> getStudentUsernames() {
        return studentUsernames;
    }

    public void setStudentUsernames(List<String> studentUsernames) {
        this.studentUsernames = studentUsernames;
    }

    public void addStudentUsername(String username) {
        if (!studentUsernames.contains(username)) {
            studentUsernames.add(username);
        }
    }

    public void removeStudentUsername(String username) {
        studentUsernames.remove(username);
    }
}
