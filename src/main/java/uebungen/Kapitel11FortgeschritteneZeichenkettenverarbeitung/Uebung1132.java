package uebungen.Kapitel11FortgeschritteneZeichenkettenverarbeitung;

import java.util.*;

public class Uebung1132 {

    // Lösung von GPT
    public static void printAllWords(String string) {
        String[] words = string.split("(\\p{Punct}|\\s)+");
        for (String word : words) {
            System.out.printf("%s ", new StringBuilder(word).reverse());
        }
    }

    public static void main(String[] args) {

        String reversedString = "erehW did eht etarip esahcrup sih kooh? tA eht dnah-dnoces pohs!";

        List<String> words = Arrays.asList(reversedString.split("[ !?.]+"));
        List<String> output = new ArrayList<>();
        for (String word : words) {
            output.add(new StringBuilder(word).reverse().append(' ').toString());
        }

        output.forEach(System.out::print);

    }

}
