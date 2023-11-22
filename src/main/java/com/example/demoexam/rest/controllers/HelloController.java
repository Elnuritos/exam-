package com.example.demoexam.rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//to make like /users/smth make mapping above controller "/users"
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "name",defaultValue = "world") String name){
        return "Hello, " + name + "!";
    }
}
