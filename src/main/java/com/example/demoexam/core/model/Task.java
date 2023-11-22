package com.example.demoexam.core.model;

import com.example.demoexam.core.model.enums.StatusType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Task {
    @Id
    private String id;
    private String title;
    private String description;
    private Date due_date;

    private StatusType status;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public Date getDue_date() {
        return due_date;
    }
}
