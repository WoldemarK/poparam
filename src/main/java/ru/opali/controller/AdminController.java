package ru.opali.controller;

import ru.opali.model.Person;
import ru.opali.service.PersonService;
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
