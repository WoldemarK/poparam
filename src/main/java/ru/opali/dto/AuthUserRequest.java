package ru.opali.dto;

import lombok.Data;

@Data
public class AuthUserRequest {
    private String username;
    private String password;
}
