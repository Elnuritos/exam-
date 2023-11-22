package com.example.demoexam.model;

import com.example.demoexam.core.model.Task;
import com.example.demoexam.core.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class UserTest {
    @Test
    void shouldCreateNewTest() {
        User user = new User();


        user.setId("someId");
        user.setEmail("title" );
        user.setUsername("description");



        Assertions.assertEquals("title", user.getEmail());
        Assertions.assertEquals("description", user.getUsername());
    }
}
