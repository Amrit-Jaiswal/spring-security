package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/v1")
public class HomeController {

    @GetMapping("/welcome")
    public String welcome(Principal principal) {
        return "Welcome " + principal.getName();
    }

    @GetMapping("/user")
    public String user(Principal principal) {
        return "Welcome " + principal.getName();
    }

    @GetMapping("/admin")
    public String admin() {
        return "Welcome admin";
    }
}
