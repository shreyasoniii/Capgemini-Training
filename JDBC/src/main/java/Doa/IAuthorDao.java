package Doa;

import org.example.Author;

import java.sql.SQLException;
import java.util.List;

public interface IAuthorDao {
    public String saveAuthor(Author a);
    public List<Author> getAll() throws SQLException;
    public String updateAuthorName(int authorId,String newName);
    public String deleteAuthor(int authorId);
    List<String> getBooksByAuthor(String firstName);

    String updateBookPriceByAuthor(String firstName, double newPrice);
}
