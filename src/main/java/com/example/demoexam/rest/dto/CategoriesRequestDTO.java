package com.example.demoexam.rest.dto;

import com.example.demoexam.core.model.Categories;
import com.example.demoexam.core.model.Task;

import java.util.Date;

public class CategoriesRequestDTO {
    private String id;
    private String name;
    private String description;
    private Date creation_date;

    public  CategoriesRequestDTO() { }
    public CategoriesRequestDTO(Categories categories) {
        this.name = categories.getName();
        this.description = categories.getDescription();
        this.creation_date = categories.getCreation_date();
    }
    public Categories toEntity(){
        Categories categories=new Categories();
        categories.setName(name);
        categories.setDescription(description);
        categories.setCreation_date(creation_date);
        return  categories;

    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public String getName() {
        return name;
    }
}
