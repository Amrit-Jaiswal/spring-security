package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1")
public class HelloController {

    @GetMapping(value = "/{user}")
    public String hello(@PathVariable("user")String user){
        return "Hello "+ user;
    }
}
