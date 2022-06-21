package com.gradebook.Gradebook.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "user_id")
public class Teacher extends AppUser{
    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;


    @ManyToOne
    private School school;

    @OneToMany(mappedBy = "teacher")
    private List<ClassTeachers> classTeachers;

}
