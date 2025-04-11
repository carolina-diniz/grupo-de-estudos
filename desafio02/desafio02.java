
import java.util.Scanner;

public class desafio02 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Tempo disponível: ");
    String rawInput = scanner.nextLine();

    int time = new stringToMinutes().transformToTime(rawInput);

    if (time == -1) {
      System.err.println("Formato de tempo inválido.");
      return;
    }

    System.err.println("Tempo disponível: " + time);
  }

}
