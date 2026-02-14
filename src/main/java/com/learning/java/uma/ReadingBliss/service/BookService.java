package com.learning.java.uma.ReadingBliss.service;

import com.learning.java.uma.ReadingBliss.dao.BookDao;
import com.learning.java.uma.ReadingBliss.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;

    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }
}
