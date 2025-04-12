
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
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

    int originalTime = time;
    int currentTime = time;

    Map<Integer, List<String>> tarefas = Map.of(
        90, List.of("projeto pessoal", "estudo aprofundado", "tarefa doméstica longa"),
        45, List.of("estudar um módulo", "escrever um texto", "resolver exercícios"),
        20, List.of("assistir a uma videoaula", "fazer uma caminhada curta"),
        10, List.of("ler um artigo curto", "revisar anotações", "meditar"),
        5, List.of("beber água", "levantar e alongar", "respirar fundo"));

    List<Integer> faixas = new ArrayList<>(tarefas.keySet());
    Collections.sort(faixas, Collections.reverseOrder());

    Random rand = new Random();

    System.out.printf("Você tem %s (%d minutos). Aqui estão sugestões para aproveitar bem esse tempo:\n\n", rawInput,
        originalTime);

    while (currentTime >= 5) {
      boolean encontrou = false;

      for (int faixa : faixas) {
        if (currentTime >= faixa) {
          List<String> atividades = tarefas.get(faixa);
          String atividade = atividades.get(rand.nextInt(atividades.size()));
          System.out.printf("%s (%d min)\n", capitalize(atividade), faixa);
          currentTime -= faixa;
          System.out.printf("Restou: %d min\n\n", currentTime);
          encontrou = true;
          break;
        }
      }

      if (!encontrou)
        break;
    }
  }

  private static String capitalize(String text) {
    return text.substring(0, 1).toUpperCase() + text.substring(1);
  }
}
