import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Digite sua senha: ");
    String password = scanner.nextLine();

    String reversedString =  new StringBuilder().append(password).reverse().toString();
    String upperString = password.toUpperCase();
    String unvowelString = password.replaceAll("(?i)[aeiou]", "");
    StringBuilder symboledString = new StringBuilder();

    char[] passwordSplited = password.toCharArray();

    for (char letter : passwordSplited) {
      if (letter == 'a') {
        letter = '@';
      }

      if (letter == 'e') {
        letter = '3';
      }

      if (letter == 'i') {
        letter = '!';
      }

      if (letter == 'o') {
        letter = '0';
      }

      if (letter == 's') {
        letter = '$';
      }

      if (letter == 't') {
        letter = '7';
      }

      symboledString.append(letter);
    }

    System.out.printf("\nOriginal: %s\n", password);
    System.out.printf("Invertida: %s\n", reversedString);
    System.out.printf("Caixa Alta: %s\n", upperString);
    System.out.printf("Sem Vogais: %s\n", unvowelString);
    System.out.printf("Cifrada: %s\n", symboledString.toString());

    scanner.close();
  }
}