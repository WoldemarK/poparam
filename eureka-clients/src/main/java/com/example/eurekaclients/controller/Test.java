package com.example.eurekaclients.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    @GetMapping("/test")
    private String testingMethod(){
        return "The testing method APP";
    }
}
