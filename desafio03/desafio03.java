import java.util.Random;
import java.util.Scanner;

class Desafio03 {
  public static void main(String[] args) {
    Random rand = new Random();
    Scanner scanner = new Scanner(System.in);
    int points = 0;

    System.out.println("Advinhação de números");

    int previous = rand.nextInt(100) + 1;
    int newNumber;

    while (true) {
      System.out.printf("Número atual: %s\n", previous);
      System.out.print("Próximo número será maior ou menor? [maior/menor]: ");
      String answer = scanner.nextLine();
      newNumber = rand.nextInt(100) + 1;

      switch (answer) {
        case "maior" -> {
          handleResult(newNumber > previous, points, newNumber);
        }
        case "menor" -> {
          handleResult(newNumber < previous, points, newNumber);
        }
        case "sair" -> {
          System.out.printf("\n\nVocê saiu do jogo com %d ponto(s). Até a próxima!\n\n", points);
          return;
        }
        default -> System.out.println("Resposta inválida!");
      }

      previous = newNumber;
    }
  }

  private static void handleResult(boolean condition, int points, int newNumber) {
    try {
      System.out.println("Processando resposta...");
      Thread.sleep(1500);

      if (condition) {
        points++;
        System.out.printf("Novo número: %s\n", newNumber);
        System.out.printf("Acertou! Pontuação: %d\n\n", points);
        return;
      }

      System.out.printf("Novo número: %s\n", newNumber);
      System.out.printf("Errou. Pontuação: %d\n\n", points);

    } catch (InterruptedException e) {
      System.out.print(e);
    }
  }
}