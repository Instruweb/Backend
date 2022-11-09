package com.instruweb.domain;

import javax.persistence.*;

@Entity
@Table(name = "main_category")
public class MainCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public MainCategory() {}

    public MainCategory(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {return id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
}
