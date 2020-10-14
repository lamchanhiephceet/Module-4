package com.codegym.kiemtramodule4.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "nation")
@Data
public class Nation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "name")
    private String nameNation;
    @OneToMany(mappedBy = "nation", cascade = CascadeType.ALL)
    private List<City> cities;

}
