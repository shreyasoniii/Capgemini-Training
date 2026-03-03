package com.service;

import org.example.Author;

import java.util.List;

public interface IAuthorService {
    public String createAuthor(Author a);
    public List<Author> getAllAuthor();
    public String updateAuthorName(int authorId,String name);
    public String removeAuthor(int authorId);
    List<String> getBooksByAuthor(String name);
    String updateBookPrice(String name,double price);
}
