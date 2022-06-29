package com.gradebook.Gradebook.model.dto;

import com.gradebook.Gradebook.model.entity.SClass;

public class SchoolClassDTO {
    private Long id;
    private String name;
    private SClass classYear;

    public SchoolClassDTO() {
    }

    public SchoolClassDTO(Long id, String name, SClass classYear) {
        this.id = id;
        this.name = name;
        this.classYear = classYear;
    }

    //Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public SClass getClassYear() {
        return classYear;
    }

    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClassYear(SClass classYear) {
        this.classYear = classYear;
    }
}
