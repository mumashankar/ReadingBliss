package com.learning.java.uma.ReadingBliss.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BookController {

    @GetMapping("/hello")
    public String welcome(){
        return "Hello and Welcome to my Reading World..!";
    }

}
