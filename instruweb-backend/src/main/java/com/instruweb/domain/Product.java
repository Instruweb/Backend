package com.instruweb.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Product {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String name;
    private String image;
    private String description;
    private String supply;
    private Integer main_categoryId;
    private Integer sub_categoryId;

    public Product() {}

    public Product(UUID id, String name, String image, String description, String supply, Integer main_categoryId, Integer sub_categoryId) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.supply = supply;
        this.main_categoryId = main_categoryId;
        this.sub_categoryId = sub_categoryId;
    }

    public UUID getId() {return id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getImage() {return image;}
    public void setImage(String image) {this.image = image;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    public String getSupply() {return supply;}
    public void setSupply(String supply) {this.supply = supply;}
    public Integer getMain_categoryId() {return main_categoryId;}
    public void setMain_categoryId(Integer main_categoryId) {this.main_categoryId = main_categoryId;}
    public Integer getSub_categoryId() {return sub_categoryId;}
    public void setSub_categoryId(Integer sub_categoryId) {this.sub_categoryId = sub_categoryId;}
}