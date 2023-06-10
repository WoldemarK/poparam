package com.example.poparam.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class RegisterUserRequest {

    private String username;
    private String password;
    private String last_name;
    private String first_name;
}
