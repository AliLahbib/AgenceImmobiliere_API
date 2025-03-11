package com.example.AgenceImmobil.controllers;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
    @PostConstruct
    public void init() {
        System.out.println("✅ HelloController is loaded and mapped to /hello/test");
    }
    @GetMapping
    public String test() {
        return "API is working!";
    }
}

