package Doa;

import org.example.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookDao implements IBookDAO{
    private static Connection con;
    static {
        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Book","root","shreya123");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String saveBook(Book b) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO book(title,price,authorId) VALUES(?,?,?)");

            ps.setString(1,b.getTitle());
            ps.setDouble(2,b.getPrice());
            ps.setInt(3,b.getAuthorId());
            int rows = ps.executeUpdate();
            if(rows>0)
                return "Book Inserted";
        } catch(Exception e){
            e.printStackTrace();
        }
        return "Book Not Inserted";
    }
}
