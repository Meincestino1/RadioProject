package uebungen.Kapitel11FortgeschritteneZeichenkettenverarbeitung;

import java.util.Scanner;

public class Uebung1133 {

    private static boolean checkRelation(int number1, String operator, int number2) {
        return switch (operator) {
            case "<" -> number1 < number2;
            case "=" ->  number1 == number2;
            case ">" -> number1 > number2;
            default -> false;
        };
    }

    public static boolean isCorrect(String string) {
        try (Scanner scanner = new Scanner(string)) {
            int number1 = scanner.nextInt();

            while (scanner.hasNext()) {
                String operator = scanner.next();
                int number2 = scanner.nextInt();

                if (checkRelation(number1, operator, number2)) {
                    number1 = number2;
                } else {
                    return false;
                }
            }
        }
        return true;
    }



    public static void main(String[] args) {

        String values = "1 < 2 > 1 < 10 = 10 > 2";
        System.out.println(isCorrect(values));

    }

}
