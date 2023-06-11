package com.example.poparam.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class AuthUserRequest {

    private String username;
    private String password;

}
