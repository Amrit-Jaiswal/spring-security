package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping(value = "/access", produces = "text/html")
    public String greeting() {
        System.out.println("greeting called");
        return "Welcome to java";
    }
}
