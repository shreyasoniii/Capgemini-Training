package com.service;

import Doa.BookDao;
import Doa.IBookDAO;
import org.example.Book;

public class BookService implements  IBookService{
    IBookDAO dao=new BookDao();
    @Override
    public String createBook(Book b) {
        return dao.saveBook(b);
    }
}
