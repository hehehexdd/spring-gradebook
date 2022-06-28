package com.gradebook.Gradebook.model.entity;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "subject")
    private List<ClassTeachers> classTeachers;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<ClassTeachers> getClassTeachers() {
        return classTeachers;
    }
}
