package com.example.demoexam.model;

import com.example.demoexam.core.model.Categories;
import com.example.demoexam.core.model.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;


public class CategoriesTest {
    @Test
    void shouldCreateNewTest() {
        Categories categories = new Categories();


        categories.setId("someId");
        categories.setName("title" );
        categories.setDescription("description");
        categories.setCreation_date(new Date());


        Assertions.assertEquals("title", categories.getName());
        Assertions.assertEquals("description", categories.getDescription());
    }
}
