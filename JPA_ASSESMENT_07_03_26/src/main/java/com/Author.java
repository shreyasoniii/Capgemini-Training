package com;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int authorId;
    String authorName;
    String email;
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    List<Book> books;
    public Author(){

    }

    public Author(String authorName, String email) {

        this.authorName = authorName;
        this.email = email;


    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
