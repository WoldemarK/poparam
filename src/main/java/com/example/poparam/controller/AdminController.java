package com.example.poparam.controller;

import com.example.poparam.model.Person;
import com.example.poparam.service.PersonService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin")
public class AdminController {

    private final PersonService userService;
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/getAllUsers")
    public ResponseEntity<List<Person>> getAll(){
        List<Person> allUsers = userService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }
}
