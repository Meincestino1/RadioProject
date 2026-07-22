package uebungen.Kapitel11FortgeschritteneZeichenkettenverarbeitung;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Uebung1134 {

    private static int conversation(String letter) {
        String upper = letter.toUpperCase();
        int value = 0;

        for (int i = 0; i < upper.length(); i++) {
            value = value * 26 + (upper.charAt(i) - 'A' + 1);
        }
        return value;
    }

    public static int[] parseA1Notation(String string) {
        Matcher match = Pattern.compile("([a-zA-Z]{1,4})(\\d+)").matcher(string);
        int[] output = new int[2]; // [column, row]

        if (match.find()) {
            output[0] = conversation(match.group(1));       // Spalte
            output[1] = Integer.parseInt(match.group(2)); // Zeile
        }

        return output;
    }

    // Lösung Buch:
    private static final int NUMBER_OF_LETTERS = 26;

    private static int parseColumnIndexBuch(String string) {
        int result = 0;
        for (int i = 0; i < string.length(); i++) {
            // Map A..Z to 1..26
            int val = Character.getNumericValue(string.charAt(i)) - 9;
            result = NUMBER_OF_LETTERS * result + val;
        }
        return result;
    }

    public static int[] parseA1NotationBuch(String cell) {
        Matcher matcher = Pattern.compile("([A-Z]+)(\\d+)").matcher(cell);
        if (!matcher.find() || matcher.groupCount() != 2) {
            return new int[]{0, 0};
        }
        int column = parseColumnIndexBuch(matcher.group(1));
        int row    = Integer.parseInt(matcher.group(2));
        return new int[]{column, row};
    }

    public static void main(String[] args) {
        int[] result = parseA1Notation("AAA");

        System.out.println("Column: " + result[0]); // 28
        System.out.println("Row: " + result[1]);    // 12
    }
}
