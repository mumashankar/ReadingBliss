package com.learning.java.uma.ReadingBliss.controller;

import com.learning.java.uma.ReadingBliss.model.Book;
import com.learning.java.uma.ReadingBliss.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/hello")
    public String welcome(){
        return "Hello and Welcome to my Reading World..!";
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok( bookService.getAllBooks() );
    }

}
