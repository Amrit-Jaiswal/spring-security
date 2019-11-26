package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {

    @Autowired
    @Qualifier("resttemplate")
    private RestTemplate restTemplate;

    @Value("${https.url}")
    private String url;

    @GetMapping(value="/get")
    public String get(){
       return restTemplate.getForObject(url, String.class);
    }

}
