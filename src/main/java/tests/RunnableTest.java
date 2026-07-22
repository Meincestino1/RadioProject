package tests;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class RunnableTest {






    public static void main(String[] args) {

        Runnable printMichi = () -> System.out.println("Michi");
        Runnable printLiam = () -> System.out.println("Liam");
        Runnable printName = Math.random() > 0.5 ? printMichi : printLiam;
        String xxx = "Mia";
        Runnable printMia = () -> System.out.println(xxx);
        printName.run();
        String i = "Mauls";
        Consumer<String> printParameter = s -> System.out.println(s);
        printParameter.accept(i);

        Arrays.asList("Jonny", "Wolter", "Woltemade").forEach(System.out::println);
        List<String> emptyToFull = new ArrayList<>();
        List<String> kids = Arrays.asList("Sara", "Liam", "Mia");
        Iterator<String> listenIterator = kids.iterator();
        while (listenIterator.hasNext()) {
            emptyToFull.add(listenIterator.next());
        }
        emptyToFull.forEach(System.out::println);

        System.out.println("digitzeug:");
        char c = '3';
        Predicate<Character> isDigit = Character::isDigit;
        System.out.println(isDigit.test(c));


    }

}
