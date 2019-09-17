package com.example.controller.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientController {

    @GetMapping(value = "/", produces = "text/html")
	public String home() {
		System.out.println("client called");
		return "home";
	}
}
