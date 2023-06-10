package com.example.poparam.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class RegisterUserRequest {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
}
