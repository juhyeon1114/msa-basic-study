package com.example.businessservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/business")
    public String home() {
        return "Hello Business Service";
    }

}
