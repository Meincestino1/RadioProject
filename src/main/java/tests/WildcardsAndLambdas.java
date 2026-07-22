package tests;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.*;

public class WildcardsAndLambdas {

    public static void collectFormatted(List<? extends Number> input, List<? super String> output) {
        Function<Number, String> toStr = n -> "Zahl: " + n;
        Function<Number, String> toStr2 = Number::toString;
        for(Number element : input) {
            String s = toStr2.apply(element);
            output.add(s);
        }
    }

    public static void filterAndPrint(List<? extends Number> list) {
        Predicate<Number> biggerThenTen = n -> n.doubleValue() >= 10;
        for (Number element : list) {
            if (biggerThenTen.test(element)) {
                System.out.println(element);
            }
        }
    }

    public static <T, U extends T, V extends T> void doSomeBullshit(
            List<? extends U> input1,
            List<? extends V> input2,
            List<? super T> output,
            BiFunction<? super U,? super V,? extends T> bifunc) {
        int size = Math.min(input1.size(), input2.size());
        for (int i = 0; i < size; i++) {
            output.add(bifunc.apply(input1.get(i), input2.get(i)));
        }
        System.out.println("Output: ");
        System.out.println(output);
    }

    public static <T> void removeIfMatch(List<T> list, Predicate<? super T> predicate) {
        list.removeIf(predicate);
    }


    public static void subtractTen(List<? extends Number> input,
                                   List<? super Integer> target,
                                   Function<? super Number, ? extends Integer> func) {
        for (Number num : input) {
            target.add(func.apply(num));
        }
    }

    public static void main(String[] args) {

        List<Integer> input = List.of(1, 2, 3, 27, 5, 11);
        List<String> output = new ArrayList<>();

        collectFormatted(input, output);
        System.out.println(output);

        filterAndPrint(input);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(25);
        numbers.add(55);
        numbers.add(2);
        numbers.add(3);
        Predicate<Number> isLowerThenFive = n -> n.doubleValue() < 5;
        removeIfMatch(numbers, isLowerThenFive);
        System.out.println(numbers);


        List<Object> lista = new ArrayList<>();
        lista.addAll(List.of("Hallo", 17, 23, "Welt"));
        List<Object> lista2 = new ArrayList<>();
        lista2.addAll(List.of("Zweite1", "Zweite2", "Zweite3"));
        List<Object> ausgabeListe = new ArrayList<>();
        BiFunction<Object, Object, Object> bullshit = (o1, o2) -> {
            String a = String.valueOf(new StringBuilder(String.valueOf(o1)).reverse());
            String b = String.valueOf(new StringBuilder(String.valueOf(o2)).reverse());
            return a.concat(b);
        };
        doSomeBullshit(lista, lista2, ausgabeListe,bullshit);


        List<Double>  source      = List.of(12.7, 5.5, 20.3);
        List<Number>  destination = new ArrayList<>();
        Function<Number, Integer> subtract = n -> Math.max((int)(n.doubleValue() - 10), 1);
        subtractTen(source, destination, subtract);
        System.out.println(destination);

        //Function<Integer, void> testfunc = n -> System.out.println(n);

        System.out.println("BiPredicate: ");
        BiPredicate<String, String> equalsIgnoreKäse = (s1, s2) -> s1.equalsIgnoreCase(s2);
        System.out.println(equalsIgnoreKäse.test("Peter", "petEr"));

        boolean ignorKäse = "Marmor".equalsIgnoreCase("marmoRr");
        System.out.println(ignorKäse);

        IntConsumer intKonsumierer = value ->System.out.println(5);
        intKonsumierer.accept(17);

        IntPredicate frage = value -> value/2 == 0 ? true : false;
        System.out.println(frage.test(1));

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromStrings(
                List.of("MeinProgramm.java")
        );
        JavaCompiler.CompilationTask task = compiler.getTask(
                null,         // Writer (z. B. System.out für Compiler-Ausgabe)
                fileManager,  // FileManager
                null,         // DiagnosticListener
                null,         // Optionen (z. B. -classpath)
                null,         // zu klassenzielende Klassen (für Annotation Processing)
                compilationUnits // Die zu kompilierenden Dateien
        );



    }

}
