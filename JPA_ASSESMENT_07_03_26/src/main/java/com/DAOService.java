package com;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DAOService {
    static EntityManager em;
    static {
        Scanner sc=new Scanner(System.in);
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("my-pu");
        em=emf.createEntityManager();
    }
    public void createAuthor(Author author,List<Book> books){
        em.getTransaction().begin();
        author.setBooks(books);
        em.persist(author);
        for(Book b:books){
            b.setAuthor(author);
        }
        em.getTransaction();
        System.out.println("Author created");

    }
    public  void  getData(){
        List<Author> authors=em.createQuery("from Author",Author.class).getResultList();
        for(Author a:authors){
            System.out.println("Author_id"+a.getAuthorId());
            System.out.println("Author Name"+a.getAuthorName());
            System.out.println();
            for(Book b:a.getBooks()){
                System.out.println(b.getTitle()+ " "+b.getPrice());
            }

        }
    }
    public void updatePrice(int id,int newPrice){
        em.getTransaction().begin();
        Book b=em.find(Book.class,id);
        if(b!=null){
            em.remove(b);
            System.out.println("deleted ");
        }
        else{
            System.out.println("Book not found");
        }
       em.getTransaction().commit();

    }
    public  void deleteBook(int id){
        em.getTransaction().begin();
        Book b=em.find(Book.class,id);
        if(b!=null){
            em.remove(b);
            System.out.println("deleted succesfully");
        }
        else{
            System.out.println("Book not found");
        }
        em.getTransaction().commit();
    }



}
