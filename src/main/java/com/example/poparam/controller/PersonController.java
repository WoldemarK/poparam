package com.example.poparam.controller;

import com.example.poparam.service.PersonService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/person")
public class PersonController {

    private final PersonService  personService;
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/healthCheck")
    public String hello() {
        return "Hello, World";
    }
    @GetMapping("/role")
    public ResponseEntity<String> getRole(@RequestHeader(name = "Authorization") String token) {
        return ResponseEntity.ok(personService.getRole(token));
    }
}
