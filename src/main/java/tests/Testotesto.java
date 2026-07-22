package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Testotesto {

    static void fickDichHart () {
        System.out.println("Fick dich du Arsch");
    }

    public static void main(String... args) {

        //RunnableTest r = Testotesto::fickDichHart;
        //r.run();
        //RunnableTest task = () -> System.out.println("Welt");
        //task.run();


        List<String> names = new ArrayList<>();
        names.add("Hans");
        names.add("Peter");
        names.add("Marco");
        names.removeIf(s -> s.contains("P"));
        names.forEach(System.out::println);

        //Consumer<String> printNow = _ -> System.out.print( System.currentTimeMillis() );

        boolean shouldTrim = false;
        Predicate<String> isEmpty = s -> shouldTrim ? s.trim().isEmpty() : s.isEmpty();

        String w = " ";
        System.out.println(isEmpty.test(w));


    }

}
