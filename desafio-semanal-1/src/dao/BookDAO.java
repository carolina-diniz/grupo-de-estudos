package dao;

import model.Book;
import org.postgresql.util.PSQLException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class BookDAO {
  private final String url = "jdbc:postgresql://localhost:5432/desafios_semanais";
  private final String user = "postgres";
  private final String password = "admin";

  public Connection connect() throws SQLException {
    return DriverManager.getConnection(this.url, this.user, this.password);
  }

  public void createBook(Book book) {
    String sql = "INSERT INTO books (title, author) VALUES (?, ?)";

    try (Connection conn = this.connect();
         PreparedStatement stmt = conn.prepareStatement(sql)
    ) {

      stmt.setString(1, book.getTitle());
      stmt.setString(2, book.getAuthor());
      stmt.executeUpdate();
      System.out.println("Livro inserido com sucesso!");

    } catch (SQLException e) {
      System.out.println("Erro ao inserir livro: " + e.getMessage());
    }
  }

  public List<Book> listBooks() {
    List<Book> books = new ArrayList<>();
    String sql = "SELECT * FROM books";

    try (Connection conn = connect();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)
    ) {

      while (rs.next()) {
        Book book = new Book(rs.getInt("id"),rs.getString("title"),rs.getString("author"));
        books.add(book);
      }

    } catch (SQLException e) {
      System.out.println("Erro ao listar livros: " + e.getMessage());
    }

    return books;
  }

  public void updateBook(Book book) {
    String sql = "UPDATE books SET title = ?, author = ? WHERE id = ?";

    try (Connection conn = connect();
         PreparedStatement stmt = conn.prepareStatement(sql)
    ) {

      stmt.setString(1, book.getTitle());
      stmt.setString(2, book.getAuthor());
      stmt.setInt(3, book.getId());
      stmt.executeUpdate();
      System.out.println("Livro atualizado com sucesso!");

    } catch (SQLException e) {
      System.out.println("Erro ao atualizar livro: " + e.getMessage());
    }
  }

  public void deleteBook(int id) {
    String sql = "DELETE FROM books WHERE id = ?";

    try (Connection conn = connect();
         PreparedStatement stmt = conn.prepareStatement(sql)
    ) {

      stmt.setInt(1, id);
      stmt.executeUpdate();
      System.out.println("Livro deletado com sucesso!");

    } catch (SQLException e) {
      System.out.println("Erro ao deletar livro: " + e.getMessage());
    }
  }
}
