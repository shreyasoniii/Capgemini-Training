package com.jdbc;
import java.sql.*;
import java.util.Scanner;
public class MyConnection {

    public static void main(String[] args) {

        Connection con = null;
        PreparedStatement pt = null;
        Scanner sc = new Scanner(System.in);

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Book", "root", "shreya123");

            String query = "INSERT INTO Author (firstName, middleName, lastName, phoneNo) VALUES (?,?,?,?)";

            pt = con.prepareStatement(query);

            System.out.print("Enter First Name: ");
            String firstName = sc.next();

            System.out.print("Enter Middle Name: ");
            String middleName = sc.next();

            System.out.print("Enter Last Name: ");
            String lastName = sc.next();

            System.out.print("Enter Phone No: ");
            String phoneNo = sc.next();

            pt.setString(1, firstName);
            pt.setString(2, middleName);
            pt.setString(3, lastName);
            pt.setString(4, phoneNo);

            int rows = pt.executeUpdate();

            if (rows > 0) {
                System.out.println("Author Inserted Successfully");
            } else {
                System.out.println("Insert Failed");
            }
            //Update INTO Table
            String query2="UPDATE Author Set firstName=?,middleName=?,lastName=?,phoneNo=? where Authorid=?";
            PreparedStatement pt2=con.prepareStatement(query2);
            System.out.print("Enter Author ID to Update: ");
            int id = sc.nextInt();

            System.out.print("First Name: ");
            String nwefirstName = sc.next();

            System.out.print(" Middle Name: ");
            String newmiddleName = sc.next();

            System.out.print("New Last Name: ");
            String newlastName = sc.next();

            System.out.print("New Phone No: ");
            String newphoneNo = sc.next();
            pt2.setString(1,nwefirstName);
            pt2.setString(2,newmiddleName);
            pt2.setString(3,newlastName);
            pt2.setString(4,newphoneNo);
            pt2.setInt(5,id);
            int next= pt2.executeUpdate();
            if(next>0){
                System.out.println("Author Updated Sccuessfully");
            }
            else{
                System.out.println("Not updated succesfully");
            }
            //Delete into table

            String query3="Delete from Author where firstName=? ";
            PreparedStatement pt3= con.prepareStatement(query3);
            System.out.println("first name of author to delete");
            String delete_author=sc.next();
            pt3.setString(1,delete_author);
            int step=pt3.executeUpdate();
            if(step>0){
                System.out.println("Delete Sccusfully ");
            }
            else{
                System.out.println("Not delete");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}