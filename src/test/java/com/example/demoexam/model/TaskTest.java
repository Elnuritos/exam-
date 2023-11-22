package com.example.demoexam.model;

import com.example.demoexam.core.model.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class TaskTest {
    @Test
    void shouldCreateNewTest() {
        Task task = new Task();


        task.setId("someId");
        task.setTitle("title" );
        task.setDescription("description");
        task.setDue_date(new Date());


        Assertions.assertEquals("title", task.getTitle());
        Assertions.assertEquals("description", task.getDescription());
    }
}
