package com.codegym.kiemtramodule4.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String cityName;
    @Positive(message = "Diện tích phải là số dương")
    private long area;
    @Positive(message = "Dân số phải là số dương")
    private Double population;
    @Positive(message = "GDP phải là số dương")
    private Double gdp;
    private String Description;
    @ManyToOne
    @JoinColumn(name = "nation_id")
    private Nation nation;

    public City() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public Double getPopulation() {
        return population;
    }

    public void setPopulation(Double population) {
        this.population = population;
    }

    public Double getGdp() {
        return gdp;
    }

    public void setGdp(Double gdp) {
        this.gdp = gdp;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }
}
