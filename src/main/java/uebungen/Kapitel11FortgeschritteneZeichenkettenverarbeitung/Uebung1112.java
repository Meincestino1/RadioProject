package uebungen.Kapitel11FortgeschritteneZeichenkettenverarbeitung;

import java.util.Arrays;
import java.util.Objects;

public class Uebung1112 {

    public static void printList(String[] names, boolean[] paid) {
        Objects.requireNonNull(names);
        Objects.requireNonNull(paid);

        if (names.length != paid.length) {
            throw new IllegalArgumentException("Number of names and paid entries are not the same, but" +
                    names.length + " and " + paid.length);
        }
        int maxColumnLength = 0;
        for (String name : names) {
            maxColumnLength = Math.max(maxColumnLength, name.length());
        }

        String format = "%-" + maxColumnLength + "s    %spaid%n";

        for (int i = 0; i < names.length; i++) {
            System.out.printf(format, names[i], paid[i] ? "" : "not ");
        }

    }

    public static void main(String[] args) {
        String[] names = {"Klaus", "Claudia", "Claudette"};
        boolean[] paid = {true, true, false};
        printList(names, paid);
    }

}
