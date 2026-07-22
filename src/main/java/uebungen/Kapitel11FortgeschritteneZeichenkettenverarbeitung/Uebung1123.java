package uebungen.Kapitel11FortgeschritteneZeichenkettenverarbeitung;

import java.util.Scanner;

public class Uebung1123 {

    private final static String[] searches = {
            "000", "11", "22", "333", "44", "55555", "6", "77777", "888", "999"
    };

    private static int parseOcrNumbers (String string) {
        String line = new Scanner(string).nextLine().replaceAll("\\s+", "");

        for (int i = 0; i < searches.length; i++) {
            line = line.replaceAll(searches[i], "" + i );
        }
        return Integer.parseInt(line);
    }

    public static void main(String[] args) {
        String ocr = "4  4 77777  11    11     4  4  22\n"+
                     "4  4    7  111   111     4  4 2  2\n"+
                     "4444  7     11    11     4444   2\n"+
                     "   4  7     11    11        4  2\n"+
                     "   4  7     1111 1111       4 2222";
        System.out.println(parseOcrNumbers(ocr));
    }

}
