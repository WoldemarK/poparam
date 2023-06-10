package com.example.poparam.controller;

import com.example.poparam.model.Person;
import com.example.poparam.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PersonController {
    private final PersonRepository personRepository;

    @GetMapping
    public List<Person> getAllPersonList(@RequestParam(required = false) String user) {
        List<Person> personList = new ArrayList<>();
        if (user == null)
            personList.addAll(personRepository.findAll());
        else
            personList.addAll(personRepository.findByPerconContaining(user));
        if (personList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT)
        }

        return new ResponseEntity<>(personList, HttpStatus.OK);
    }
}
