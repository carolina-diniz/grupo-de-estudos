import dao.BookDAO;
import model.Book;

import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    BookDAO dao = new BookDAO();
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("\n=== Biblioteca do Aprendiz ===");
      System.out.println("1. Adicionar livro");
      System.out.println("2. Listar livros");
      System.out.println("3. Editar livro");
      System.out.println("4. Remover livro");
      System.out.println("5. Sair");
      System.out.print("Escolha: ");
      String answer = scanner.nextLine();


      switch (answer) {
        case "1" -> {
          System.out.print("\nDigite o título: ");
          String title = scanner.nextLine();

          System.out.print("Digite o autor: ");
          String author = scanner.nextLine();

          Book newBook = new Book(title, author);
          dao.createBook(newBook);
        }
        case "2" -> {
          System.out.println("\n\uD83D\uDCDA Lista de livros:");
          List<Book> books = dao.listBooks();
          for (Book book: books) {
            int id = book.getId();
            String title = book.getTitle();
            String author = book.getAuthor();

            System.out.printf("[%d] %s - %s\n", id, title, author);
          }
        }
        case "3" -> {
          System.out.print("Digite o número do livro a editar: ");
          int id = Integer.parseInt(scanner.nextLine());

          System.out.print("Digite o título: ");
          String title = scanner.nextLine();

          System.out.print("Digite o autor: ");
          String author = scanner.nextLine();

          Book updatedBook = new Book(id, title, author);
          dao.updateBook(updatedBook);
        }
        case "4" -> {
          System.out.print("Digite o número do livro a deletar: ");
          int id = Integer.parseInt(scanner.nextLine());

          dao.deleteBook(id);
        }
        case "sair" -> {
          System.out.println("\nSaindo da biblioteca... Até logo!");
          return;
        }
        default -> {
          System.out.print("\nValor inválido!\n");
        }
      }
    }
  }
}