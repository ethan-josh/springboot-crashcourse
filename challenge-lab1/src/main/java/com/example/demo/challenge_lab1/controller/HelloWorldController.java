package com.example.demo.challenge_lab1.controller;

import org.springframework.beans.factory.annotation.Value; // <-- Import this!
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Marks this class as a REST controller
public class HelloWorldController {

    @Value("${app.greeting.message}") // Inject value from application.properties
    private String customGreeting;

    @GetMapping("/hello")
    public String sayHello() {
        return customGreeting; // Now returns the custom message
    }

//    @GetMapping("/hello") // Maps HTTP GET requests to the "/hello" URL
//    public String sayHello() {
//        return "Hello, Spring Boot Learners!";
//    }
}