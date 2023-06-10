package com.example.poparam.controller;

import com.example.poparam.model.Person;
import com.example.poparam.service.PersonDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final PersonDetailsService personDetailsService;

    @PostMapping
    public ResponseEntity<Person> createNewPerson(@RequestBody @Validated Person person) {
        return new ResponseEntity<>(personDetailsService.save(person), HttpStatus.CREATED);
    }
}
