package com.example.poparam.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestingController {
    @GetMapping
    public String testingMessage() {
        return "The testing message";
    }
}
