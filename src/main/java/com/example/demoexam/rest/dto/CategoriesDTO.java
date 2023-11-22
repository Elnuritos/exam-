package com.example.demoexam.rest.dto;

import com.example.demoexam.core.model.Categories;
import com.example.demoexam.core.model.Task;

import java.util.Date;

public class CategoriesDTO {
    private String id;
    private String name;
    private String description;
    private Date creation_date;

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public CategoriesDTO() {}

    public CategoriesDTO(Categories categories) {
        this.id = categories.getId();
        this.name = categories.getName();
        this.description = categories.getDescription();
        this.creation_date=categories.getCreation_date();

    }
}
