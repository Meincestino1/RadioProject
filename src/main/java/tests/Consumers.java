package tests;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Consumers {

    public static <T> Consumer<T> executionTimeLogger(Consumer<T> block) {
        return t -> {       // t steht für ein Element das später übergeben wird, wie unten 1 oder 2 oder 3 oder 4
            long start = System.nanoTime();
            block.accept(t);
            long duration = System.nanoTime() - start;
            System.getLogger("execution time").log(System.Logger.Level.INFO, "Execution time (ns): {0}", duration);
        };

    }
    Predicate<String> istLeer = s -> !s.isEmpty();
    Predicate<List<?>> containsMinTwoObjects = s -> s.size() >= 2;

    public static String zuBig(String string) {
        return string.toUpperCase();
    }

    public static void main(String[] args) {
        Arrays.asList(1, 2, 3, 4).forEach(executionTimeLogger( (s) -> System.out.println(s)));
        System.out.println("".isEmpty());

        Consumers predicateMi = new Consumers();
        System.out.println(predicateMi.istLeer.test(""));
        System.out.println("Deswilliwissen:");
        System.out.println(predicateMi.containsMinTwoObjects.test(Arrays.asList("wow")));

        Predicate<String> isHello = Predicate.isEqual("Hello");
        Predicate<String> isEqualIgnoreCase = s -> "Hello".equalsIgnoreCase(s);

        System.out.println(isHello.test("Hello"));
        System.out.println(isHello.test("World"));
        System.out.println("Ignorecase");
        System.out.println(isEqualIgnoreCase.test("HelLo"));

        Predicate<Character> isDigit = Character::isDigit;
        Predicate<Character> isNotDigit = isDigit.negate();
        List<Character> lista = new ArrayList<>(Arrays.asList('7', 'u', 'f'));
        System.out.println(lista);
        lista.removeIf(isDigit);
        System.out.println(lista);
        lista.removeIf(Predicate.not(isDigit));
        System.out.println(lista);

        String boh = "Hallo Welt!";
        Function<String, String> zuGross = String::toUpperCase;;
        String big = zuGross.apply(boh);
        System.out.println(big);

        System.out.println(zuBig(boh));

        List<Package> list = Arrays.asList(Package.getPackages());
        Collections.sort(list, Comparator.comparing(Package::getName));
        System.out.println(list);

        Function<String, String> identityFunction = Function.identity();

        Function<Integer, Integer> multiply2 = i -> i * 2;
        Function<Integer, Integer> add5 = i -> i + 5;
        System.out.println(multiply2.andThen(add5).apply(5));
        System.out.println(multiply2.compose(add5).apply(5));

        List<? extends Number> list1 = List.of(1, 2.5, 3);
        Number a = list1.get(0);
        System.out.println(list1.get(0));
        Object ob = 17;
        Number nu = 19;

        Number numb = list1.get(0);
        Object s = list1.get(0);
        System.out.println(s);


        /*List<? super Number> list2 = List.of(new Object(), 3);
        Object b = list2.get(0);
        list2.add(77);
        Object obj = 17;
        Number num = 19;
        list2.add(num);
        System.out.println(list2);*/




    }

}
