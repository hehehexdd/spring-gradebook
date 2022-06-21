package com.gradebook.Gradebook.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "classes_teachers")
public class ClassTeachers {
    @Id
    @ManyToMany()
    private List<Student> classId;

    @Id
    @ManyToMany()
    private List<Teacher> teacherId;

    @Id
    @ManyToMany()
    private  List<Subject> subjectId;

}
