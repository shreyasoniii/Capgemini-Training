package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AuthorMain {
    public static void main(String[] args) {
        DAOService ds=new DAOService();
        List<Author> al=new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your operation choice: 1- CREATE, 2-READ, 3-UPDATE, 4-delete,");
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                System.out.println("Enter the author Name");
                String name=sc.next();
                System.out.print("Enter author Email");
                String email=sc.next();
                Author author=new Author(name,email);
                System.out.println("Books details");
                List<Book> books=new ArrayList<>();
                for(int i=0;i<=3;i++){
                    System.out.println("Enter book data");
                    System.out.println("Enter BookName");
                    String title=sc.nextLine();
                    System.out.println("Enter price:");
                    int price=sc.nextInt();
                    Book b=new Book(title,price);
                    books.add(b);
                }
                ds.createAuthor(author,books);
                break;

            case 2:
                System.out.println("All author detail");
                ds.getData();
                break;

            case 3:
                System.out.println("Enter book Id to update");
                int id=sc.nextInt();
                System.out.println("Enter Price to Update");
                int price=sc.nextInt();
                ds.updatePrice(id,price);
                break;

            case 4:
                System.out.println("enter book id to delete");
                int id1= sc.nextInt();
                ds.deleteBook(id1);
                break;
            default:
                System.out.println("Invalid choice");

        }



    }
}
