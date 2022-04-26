package com.gradebook.Gradebook.data.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "idDirector")
public class Director extends AppUser{

    private String FirstName;

    private String LastName;

//    @OneToOne
//    private School School;

}
