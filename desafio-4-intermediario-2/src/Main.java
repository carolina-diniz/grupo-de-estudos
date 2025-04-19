import dao.TarefaDAO;
import model.Tarefa;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    TarefaDAO dao = new TarefaDAO();
    Scanner scanner = new Scanner(System.in);

    while(true) {
      System.out.println("\nMenu:");
      System.out.println("1 – Adicionar tarefa");
      System.out.println("2 – Listar tarefas");
      System.out.println("3 – Marcar concluída");
      System.out.println("4 – Encerrar");

      System.out.print(">>> ");
      String answer = scanner.nextLine();

      switch(answer) {
        case "1" -> {
          System.out.print("Digite uma descrição: ");
          String description = scanner.nextLine();

          dao.add(description);
        }
        case "2" -> {
          dao.list();
        }
        case "3" -> {
          System.out.print("Digite o ID da tarefa: ");
          int id = scanner.nextInt();
          scanner.nextLine();

          dao.complete(id);
          System.out.println("Valor inválido, tente novamente.");
        }
        case "4" -> {
          dao.end();
        }
        default -> {
          System.out.println("Valor inválido, tente novamente.");
        }
      }
    }
  }
}