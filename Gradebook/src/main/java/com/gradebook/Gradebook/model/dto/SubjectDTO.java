package com.gradebook.Gradebook.model.dto;

public class SubjectDTO {
    private Long id;
    private String name;

    public SubjectDTO() {
    }

    public SubjectDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    //Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

}

