package com.gradebook.Gradebook.model.dto;

import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

public class ParentDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private List<String> childrenUsernames;

    public ParentDTO(Long id, String firstName, String lastName, List<String> childrenUsernames, String username) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.childrenUsernames = childrenUsernames;
        this.username = username;
    }

    public ParentDTO() {
    }

    public ParentDTO(Long id, String firstName, String lastName, String username) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
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

    public List<String> getChildrenUsernames() {
        return childrenUsernames;
    }

    public void setChildrenUsernames(List<String> childrenUsernames) {
        this.childrenUsernames = childrenUsernames;
    }
    public void addKidUsername(String username){
        if(!this.isExisting(username)) {
            this.childrenUsernames.add(username);
        }
    }
    public void removeKidUsername(String username){
        if(this.isExisting(username)) {
            this.childrenUsernames.remove(username);
        }

    }
    private boolean isExisting(String username){
        return this.childrenUsernames.contains(username);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
