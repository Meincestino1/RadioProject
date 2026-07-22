package tests;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.function.*;

public class DateKackFuck {

    static void verarbeiteUndGibAus(String s1, String s2, Consumer<String> ausgabe) {
        String result = s1.toUpperCase() + " " + s2.toUpperCase();
        ausgabe.accept(result);
    }



    public static void main(String[] args) {

        Supplier<Date> factory = Date::new;
        System.out.println(factory.get());
        System.out.println( ((Supplier<Date>) Date::new).get() );

        class DbEntry<K, V> {
            K key;
            V value;
            public DbEntry(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        //System.out.println(((BiFunction<String, Integer, DbEntry<String, Integer>>) DbEntry::<String, Integer>new).apply("Test", 123));
        System.out.println(((BiFunction<String, Integer, DbEntry<String, Integer>>) DbEntry::new).apply("Test", 123));



        Consumer<String> ausgabe = System.out::println;
        verarbeiteUndGibAus("Micky", "Mouse", ausgabe);
     //Supplier<Date> factory = Date::new;
        //System.out.println(factory.get());
        //System.out.println("drzwischn");
        // Konstruktorreferenzen
        System.out.println( ((Supplier<Date>)Date::new).get());
        System.out.println( ((Function<String, String>)String::new).apply("Hallo Welt") );
        System.out.println(((Function<Integer, ArrayList<String>>) (ArrayList<String>::new)).apply(3));
        System.out.println(((Function<List<String>, ArrayList<String>>) ArrayList::new).apply(List.of("Walther")));




        //Methodenreferenzen
        System.out.println( ((Function<String, Integer>) Integer::parseInt).apply("1234") );
        System.out.println( ((Function<String, String>) String::toUpperCase).apply("Desdo") );
        System.out.println(((Function<String, String>) String::toUpperCase).apply("Seloane"));
        System.out.println("hoilaschotzele".toUpperCase().toLowerCase().toUpperCase().toLowerCase());
        System.out.println(new StringBuilder("Hallo").append(" Welt").toString().toUpperCase());
        System.out.println(new StringBuilder("Hoila").append("Schnucki").reverse().toString().toUpperCase());


        System.out.println( ((Function<String, Integer>) Integer::parseInt).apply("45") );
        System.out.println(((Function<String, String>) String::toUpperCase).apply("siLongo"));
        System.out.println("silungo".toUpperCase());

        Function<String, String> machGross = String::toUpperCase;
        String a = "Sara";
        String b = "Liam";
        System.out.println(machGross.apply(a));

        Consumer<String> machGrossUndGibAus = s -> {
            String result = s.toUpperCase();
            System.out.println(result);
        };

        BiConsumer<String, String> verketteMachgrossUndGibaus = (s, s2) -> {
            String result = s.toUpperCase() + " " + s2.toUpperCase();
            System.out.println(result);
        };

        machGrossUndGibAus.accept(b);
        verketteMachgrossUndGibaus.accept(a, b);




    }

}
