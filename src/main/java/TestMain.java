import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Supplier;

public class TestMain {

    //(s) -> System.out.println("Hallo")

    //public static IntFunction<Integer> fact = n -> TestMain.fact.apply(n - 1);



    public static void main(String[] args) {

        //Consumer<String> r = (s) -> System.out.println(s);
        //r.accept("hey");

        Consumer<String> printQuoted = s -> System.out.printf("'%s'", s);

        Consumer<String> printNow = s -> System.out.println(System.currentTimeMillis() );

        Consumer<String> printNow2 = ignored -> System.out.println(System.currentTimeMillis() );

        //printQuoted.accept("Michi");
        //System.out.println();
        //printNow.accept("Mia");
        //System.out.println();
        //printNow2.accept("Liam");

        //Comparator<String> c = (s1, s2)-> 1 / 0;
        //String[] words = { "M", "Skyfall", "Q", "Adele" };
        //Arrays.sort(words, c);

        List<String> list = new ArrayList<>(List.of("aa", "XX", "bb"));
        List<String> list2 = new ArrayList<>(List.of("aa", "XX", "bb"));
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });

        list2.sort(String::compareToIgnoreCase);

        System.out.println(list.toString());
        System.out.println(list2.toString());

        List<String> lista = List.of("Hallo ", " du ", " Ratte");
        lista.forEach(System.out::print);

        System.out.println();

        Supplier<Long> time = System::currentTimeMillis;;
        Long timeAsLong = System.currentTimeMillis();
        System.out.println(time.get());
        System.out.println(timeAsLong);

        BiFunction<Double, Double, Double> max = Math::max;

        System.out.println(max.apply(10.3, 22.5));





    }

}
