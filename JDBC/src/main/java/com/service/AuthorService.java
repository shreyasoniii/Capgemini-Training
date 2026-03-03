package com.service;

import Doa.AuthorDao;
import Doa.IAuthorDao;
import org.example.Author;

import java.sql.SQLException;
import java.util.List;



public class AuthorService implements IAuthorService{
    IAuthorDao dao=new AuthorDao();
    @Override
    public String createAuthor(Author aut) {
      if(aut.getFirstName()==null){
          return "Invalid ";
      }
      else{
          return dao.saveAuthor(aut);
      }

    }

    @Override
    public List<Author> getAllAuthor() {
        try {
            return dao.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String updateAuthorName(int authorId, String name) {
        if (name == null || name.length() < 4 )
            return "Invalid Name";
        return dao.updateAuthorName(authorId,name);
    }

    @Override
    public String removeAuthor(int authorId) {
        if (authorId==0)
            return "Inavalid Id";
        return dao.deleteAuthor(authorId);
    }

    @Override
    public List<String> getBooksByAuthor(String name) {
        return dao.getBooksByAuthor(name);
    }

    @Override
    public String updateBookPrice(String name, double price) {
        return dao.updateBookPriceByAuthor(name,price);
    }
}
