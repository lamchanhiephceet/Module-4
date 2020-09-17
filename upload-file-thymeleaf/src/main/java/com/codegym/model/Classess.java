package com.codegym.c0320h1.model;


import javax.persistence.*;

@Entity
@Table
public class Classess {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Classess() {
    }

    public Classess(String name){
        this.name = name;
    }

    public Classess(Long id, String name){
        this.id = id;
        this.name = name;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
