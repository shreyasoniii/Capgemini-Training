package com;

import jakarta.persistence.*;
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int bookId ;
    String title;
    int price;
    @ManyToOne
    @JoinColumn(name = "authorId")
    Author author;

    public Book(){

    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Book(String title, int price) {
        this.title = title;
        this.price = price;

    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
