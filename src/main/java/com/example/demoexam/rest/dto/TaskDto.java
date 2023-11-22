package com.example.demoexam.rest.dto;

import com.example.demoexam.core.model.Task;
import com.example.demoexam.core.model.enums.StatusType;

import java.util.Date;

public class TaskDto {
    private String id;
    private String title;
    private String description;
    private Date due_date;

    private StatusType status;

    public String getDescription() {
        return description;
    }

    public Date getDue_date() {
        return due_date;
    }

    public String getId() {
        return id;
    }

    public StatusType getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public TaskDto() {}

    public TaskDto(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.due_date=task.getDue_date();
        this.status=task.getStatus();
    }
}
