package com.example.demoexam.rest.dto;





import com.example.demoexam.core.model.User;
import com.example.demoexam.core.model.enums.UserType;

import java.util.Date;

public class UserRequestDTO {

    private String email;
    private String username;
    private String password;

    public  UserRequestDTO() { }

    public UserRequestDTO(User user) {

        this.email = user.getEmail();
        this.username = user.getUsername();
        this.password = user.getPassword();
    }

    public User toEntity() {
        User user = new User();

        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);

        return user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
