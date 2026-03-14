package com.cg.bean;

public class Librarian {
    private int librarianId;
    private String Name;
    private Book book;

    public Librarian(){

    }

    public Librarian(int librarianId, Book book, String name) {
        this.librarianId = librarianId;
        this.book = book;
        Name = name;
    }

    public int getLibrarianId() {
        return librarianId;
    }

    public void setLibrarianId(int librarianId) {
        this.librarianId = librarianId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    public void issueBook(){
        System.out.println("Librarian Name:-"+Name);
        System.out.println("==========Book Details======");
        System.out.print("Book Id"+book.getBookId());
        System.out.println("Book Author"+book.getAuthor());
        System.out.println("Book Title"+book.getTitle());
    }

}
