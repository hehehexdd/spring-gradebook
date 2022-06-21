package com.gradebook.Gradebook.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "schools")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "address", nullable = false, unique = true)
    private String address;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne(mappedBy = "school")
    private Director director;

    @OneToMany
    private List<Student> students;

    public School(String address, String name) {
        this.id = null;
        this.address = address;
        this.name = name;
    }

    //Getters
    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    //Setters
    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
