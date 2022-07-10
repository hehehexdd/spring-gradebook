package com.gradebook.Gradebook.model.dto;

import java.util.ArrayList;
import java.util.List;

public class ParentDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private List<Long> childrenIds;

    public ParentDTO(Long id, String firstName, String lastName, String username) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.childrenIds = new ArrayList<>();
        this.username = username;
    }


    public ParentDTO() {
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

    public List<Long> getChildrenIds() {
        return childrenIds;
    }

    public void setChildrenIds(List<Long> childrenIds) {
        this.childrenIds = childrenIds;
    }
    public void addKidUsername(Long username){
        if(!this.isExisting(username)) {
            this.childrenIds.add(username);
        }
    }
    public void removeKidUsername(Long username){
        if(this.isExisting(username)) {
            this.childrenIds.remove(username);
        }

    }
    private boolean isExisting(Long username){
        return this.childrenIds.contains(username);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
