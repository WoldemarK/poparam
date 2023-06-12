package ru.opali.dto;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class RegisterUserRequest {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDateTime lastVisit;
    private LocalDateTime updateDate;
    private LocalDateTime createDate;
}
