package com.example.demoexam.rest.dto;

import com.example.demoexam.core.model.Task;
import com.example.demoexam.core.model.enums.StatusType;

import java.util.Date;

public class TaskRequestDto {
    private String id;
    private String title;
    private String description;
    private Date due_date;
    private StatusType status;


    public TaskRequestDto() {}

    public TaskRequestDto(Task task) {
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.due_date = task.getDue_date();
        this.status=task.getStatus();
    }
    public Task toEntity(){
        Task task=new Task();
        task.setTitle(title);
        task.setDescription(description);
        task.setDue_date(due_date);
        task.setStatus(status);
        return  task;

    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDue_date() {
        return due_date;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    public StatusType getStatus() {
        return status;
    }
}
