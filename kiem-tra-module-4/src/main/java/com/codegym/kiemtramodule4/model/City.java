package com.codegym.kiemtramodule4.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name="cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    private String name;

    @ManyToOne
    @JoinColumn(name="nation_id")
    private Nation nation;

    @Column(nullable = false)
    @Range(min=100, max =10000000)
    private int area;

    @Column(nullable = false)
    @Range(min = 100, max = 1000000000)
    private long population;

    @Column(nullable = false)
    @Range(min =100,max=1000000)
    private int GDP;

    @Column(nullable = false)
    @NotBlank
    private String description;


    public City() {}

    public City(String name, Nation nation,int area,long population,int GDP,String description) {
        this.name = name;
        this.nation = nation;
        this.area = area;
        this.population = population;
        this.GDP = GDP;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Nation getNation() {
        return nation;
    }

    public int getArea() {
        return area;
    }

    public long getPopulation() {
        return population;
    }

    public int getGDP() {
        return GDP;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public void setGDP(int GDP) {
        this.GDP = GDP;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
