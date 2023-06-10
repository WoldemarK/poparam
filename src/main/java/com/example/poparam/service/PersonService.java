package com.example.poparam.service;

import com.example.poparam.model.Person;

import java.util.List;

public interface PersonService {
    Person register(Person user);

    List<Person> getAllUsers();

    Person getByUsername(String username);

    Person findById(Long id);

    void delete(Long id);

    String getRole(String token);


}
