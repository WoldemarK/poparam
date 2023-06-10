package com.example.poparam.dto;

import com.example.poparam.model.Person;
import lombok.Data;
@Data
public class RegisterUserResponse {

    private String username;
    private String password;
    private String role;
    private String email;

    public RegisterUserResponse(Person person) {
        this.setPassword(person.getPassword());
        this.setUsername(person.getUsername());
        this.setRole(person.getRole().name());
        this.setEmail(person.getEmail());
    }
}
