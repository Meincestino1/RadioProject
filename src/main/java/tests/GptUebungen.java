package tests;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.*;

public class GptUebungen {

    public static void main(String[] args) {

        BiFunction<Double, Double, Double> minFun = Math::min;
        System.out.println(minFun.apply(4.5, 3.2));

        // Supplier<String> randumUUID = UUID.randomUUID()::toString; // Achtung nicht dynamisch
        Supplier<String> randumUUID = () -> UUID.randomUUID().toString();
        System.out.println(randumUUID.get());

        BiFunction<Integer, Integer, Integer> multiply = Math::multiplyExact;
        System.out.println(multiply.apply(7, 7));

        //RunnableTest exit = () -> System.exit(5);
        //exit.run();

        Supplier<Double> randomSupplier = Math::random;
        System.out.println(randomSupplier.get());

        BiFunction<String, String, Path> fullPath = Paths::get;
        System.out.println(fullPath.apply("www.java", ".com"));


        // DAS NOCH GAAAAAAAAAAAAAAANZE GENAU VERSTEHEN
        List<String> fruits = new ArrayList<>(List.of("Apfel", "Banane", "Zitrone", "Mango"));
        fruits.add("Kirsche");
        BiConsumer<List<String>, Comparator<String>> sorter = Collections::sort;
        //BiConsumer<List<String>, Comparator<String>> sorter = (list, c) -> Collections.sort(list, c);
        sorter.accept(fruits, String::compareToIgnoreCase);
        System.out.println(fruits);


        BiFunction<Double, Double, Double> powerFunc = Math::pow;
        System.out.println(powerFunc.apply(2.0, 10.0));

        BiFunction<String, String, Path> pathJoiner = Paths::get;
        System.out.println(pathJoiner.apply("C:\\\\Users", "Downloads"));

        // BiFunction<String, Object, String> formatter = (format, args1) -> String.format(format, args1);
        BiFunction<String, Object[], String> formatter = String::format;
        System.out.println(formatter.apply("Hallo, %s!", new Object[]{"Lisa", "29"}));


        List<String> names = new ArrayList<>(List.of("Alhambra", "Genevieve", "Elsa", "Martha"));
        String placeHolders = String.join(", ", Collections.nCopies(names.size(), "%s")); // %s, %s, %s, %s
        String formatString = "Benutzer: " + placeHolders;                                           // Benutzer: %s, %s, %s, %s
        BiFunction<String, Object[], String> formatter2 = String::format;
        // BiFunction<String, Object[], String> formatter2 = (format, args1) -> String.format(format, args1);
        System.out.println(formatter2.apply(formatString, names.toArray()));

        // ------------------------------------------------------------------------------------------------------------

        //List<String> inputNames = new ArrayList<>();
        //Scanner scanner = new Scanner(System.in);
        //System.out.println("gib einen Namen ein ");
        //System.out.println("Wenn du fertig bist, gib stop ein ");
        //String input = " ";
        //while (true) {
            //input = scanner.nextLine();
            //if (input.equalsIgnoreCase("stop")) {
                //break;
            //}
            //inputNames.add(input);

        //}
        //String placeholders2 = String.join(", ", Collections.nCopies(inputNames.size(), "%s"));
        //String formatString2 = "Willkommen " + placeholders2 + " !";
        //System.out.println(formatString2);
        //BiFunction<String, Object[], String> dynamicFormat = String::format;
        //System.out.println(dynamicFormat.apply(formatString2, inputNames.toArray(new Object[0])));


        BiFunction<Double, Double, Integer> compareDoubles = Double::compare;
        System.out.println(compareDoubles.apply(3.141, 3.145));

        Consumer<String> out = System.out::println;
        out.accept("Luschi");

        //RunnableTest in = System.out::println;
        //in.run();

        Function<String, Integer> len = String::length;
        System.out.println(len.apply("Hallo"));

        Object[] words = { "", '3', null, "2", 1, "" };
        Arrays.stream(words).forEach(System.out::println);




    }

}
