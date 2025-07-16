package com.example.demo.challenge_lab3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map; // <-- Import this!
import java.util.HashMap; // <-- Import this!
import java.util.Arrays; // <-- Import this!
import java.util.List; // <-- Import this!

@RestController
public class HelloWorldController {

    @GetMapping("/greeting")
    public String greetWithParam(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/calculate/sum")
    public String sumNumbers(
            @RequestParam("num1") int number1,
            @RequestParam("num2") int number2
    )
    {
        int sum = number1 + number2;
        return "The sum of " + number1 + " and " + number2 + " is " + sum;
    }

    @GetMapping("/info")
    public Map<String, String> getAppInfo() {
        Map<String, String> info = new HashMap<>();
        info.put("appName", "MyFirstSpringBootAPI");
        info.put("version", "1.0.0");
        info.put("status", "Running");
        return info;
    }

    @GetMapping("/features")
    public List<String> getFeatures() {
        return Arrays.asList("REST API", "Spring Boot", "Easy Setup", "Fast Development");
    }
}
