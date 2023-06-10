package com.example.poparam.controller;

import com.example.poparam.model.Person;
import com.example.poparam.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PersonController {
    private final PersonRepository personRepository;

    @PostMapping
    public Person createNewPerson(@RequestBody @Validated Person person) {
        return personRepository.save(person);
    }

    @GetMapping
    public List<Person> getAllPersonList() {
      return  personRepository.findAll();
    }
}
