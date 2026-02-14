package com.learning.java.uma.ReadingBliss.model;

public class Book {
    private int bookId;
    private String bookTitle;
    private String author;
    private boolean isBookRead;

    public Book(Builder builder) {
        this.bookId = builder.bookId;
        this.bookTitle = builder.bookTitle;
        this.author = builder.author;
        this.isBookRead = builder.isBookRead;
    }

    public static class Builder {
        private int bookId;
        private String bookTitle;
        private String author;
        private boolean isBookRead;

        public Builder bookId(int bookId) {
            this.bookId = bookId;
            return this;
        }
        public Builder bookTitle(String bookTitle) {
            this.bookTitle = bookTitle;
            return this;
        }
        public Builder author(String author) {
            this.author = author;
            return this;
        }
        public Builder isBookRead(boolean isBookRead) {
            this.isBookRead = isBookRead;
            return this;
        }

        public Book build(){
            return new Book(this);
        }
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isBookRead() {
        return isBookRead;
    }

    public void setBookRead(boolean bookRead) {
        isBookRead = bookRead;
    }
}
