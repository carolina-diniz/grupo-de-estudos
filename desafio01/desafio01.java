
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class desafio01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite sua senha: ");
        String password = scanner.nextLine();

        String reversedString = Reverse(password);
        String upperString = upper(password);
        String unvowelString = removeVowel(password);
        String symboledString = changeToSymbol(password);

        System.out.printf("\nOriginal: %s\n", password);
        System.out.printf("Invertida: %s\n", reversedString);
        System.out.printf("Caixa Alta: %s\n", upperString);
        System.out.printf("Sem Vogais: %s\n", unvowelString);
        System.out.printf("Cifrada: %s\n", symboledString);

        scanner.close();
    }

    private static String Reverse(String password) {
        return new StringBuilder().append(password).reverse().toString();
    }

    private static String upper(String password) {
        return password.toUpperCase();
    }

    private static String removeVowel(String password) {
        String passwordModified = password.replaceAll("(?i)[aeiou]", "");

        return passwordModified;
    }

    private static String changeToSymbol(String password) {
        Map<Character, Character> symbolMap = new HashMap<>();

        symbolMap.put('a', '@');
        symbolMap.put('e', '3');
        symbolMap.put('i', '!');
        symbolMap.put('o', '0');
        symbolMap.put('s', '$');
        symbolMap.put('t', '7');
        symbolMap.put('a', '@');

        StringBuilder passwordModified = new StringBuilder();

        for (Character c : password.toCharArray()) {
            if (symbolMap.containsKey(Character.toLowerCase(c))) {
                passwordModified.append(symbolMap.get(c));
            } else {
                passwordModified.append(c);
            }
        }

        return passwordModified.toString();
    }
}
