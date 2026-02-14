package com.learning.java.uma.ReadingBliss.dao;

import com.learning.java.uma.ReadingBliss.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class BookDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Book book(ResultSet resultSet, int index) throws SQLException {
        return new Book.Builder()
                .bookId(resultSet.getInt(1))
                .bookTitle(resultSet.getString(2))
                .author(resultSet.getString(3))
                .isBookRead(resultSet.getBoolean(4))
                .build();
    }
//    Get All books from my library
//    SELECT b.id, b.title, b.author, l.isRead, l.comment FROM public.Book b JOIN public.MyLibrary l ON b.id = l.book_id;

//    Get All books from my Wishlist
//    SELECT b.id, b.title, b.author, l.buyFrom, l.comment FROM public.Book b JOIN public.MyWishlist l ON b.id = l.book_id;

    public List<Book> getAllBooks(){
        String getAllBooksQry = "SELECT book.id, book.title, book.author, lib.isRead, lib.comment " +
                "FROM Book book " +
                "JOIN MyLibrary lib " +
                "ON book.id = lib.book_id";
        return jdbcTemplate.query(getAllBooksQry, this::book);
    }
}
