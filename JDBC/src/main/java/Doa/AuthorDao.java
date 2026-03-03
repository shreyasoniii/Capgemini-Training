package Doa;

import org.example.Author;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorDao implements IAuthorDao{
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
    public String saveAuthor(Author a){
        try{
            PreparedStatement ps=con.prepareStatement("insert into author values(?,?,?,?,?)");
            ps.setInt(1,a.getAuthorId());
            ps.setString(2,a.getFirstName());
            ps.setString(3, a.getMiddleName());
            ps.setString(4,a.getLastName());
            ps.setString(5,a.getPhoneNo());
            int rows=ps.executeUpdate();
            if(rows>0){
                return "Author created";
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return "Author Not Created";
    }

    @Override
    public List<Author> getAll() throws SQLException {
        PreparedStatement ps2= null;
        try {
            ps2 = con.prepareStatement("SELECT * from Author ");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ResultSet rs= ps2.executeQuery();
        while(rs.next()){
            System.out.println(rs.getInt("authorId")+"\t"+rs.getString("firstName")
                    +"\t"+rs.getString("middleName")+"\t"+rs.getString("lastName")+"\t"+rs.getString("phoneNo"));
        }
        return null;
    }

    public String updateAuthorName(int authorId,String newName){
        try{
            PreparedStatement ps=con.prepareStatement("update author set firstName=? where authorId=?");
            ps.setString(1,newName);
            ps.setInt(2,authorId);
            int rows=ps.executeUpdate();
            if(rows>0){
                System.out.println("Rows Updated...");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return "Name not found";
    }

    //---delete-----
    @Override
    public String deleteAuthor(int authorId) {
        try {
            PreparedStatement ps = con.prepareStatement("delete from author where authorId = ?");
            ps.setInt(1, authorId);
            int rows = ps.executeUpdate();
            if (rows > 0)
                return "Author Deleted";
            return "Employee Not Found";

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Author Not deleted";
    }

    @Override
    public List<String> getBooksByAuthor(String firstName) {
        List<String> list = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT b.title FROM book b JOIN author a ON b.authorId=a.authorId WHERE a.firstName=?");
            ps.setString(1, firstName);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(rs.getString("title"));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public String updateBookPriceByAuthor(String firstName,double newPrice){
        try{
            PreparedStatement ps=con.prepareStatement("UPDATE book b JOIN author a ON b.authorId=a.authorId SET b.price=? WHERE a.firstName=?");
            ps.setDouble(1,newPrice);
            ps.setString(2,firstName);
            int rows=ps.executeUpdate();
            if(rows>0)
                return "Price Updated";
        }catch(Exception e){
            e.printStackTrace();
        }
        return "Author Not Found";
    }
}
