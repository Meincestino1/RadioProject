package tests;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class FuncTest {



    public static void main(String[] args) {

        Arrays.asList("1", "2", "17", "22", 5).forEach(System.out::println);

        Consumer<String> meinKonsument = s -> {System.out.println(s);};
        List<String> words = Arrays.asList("1", "99", "127");
        // words.forEach(System.out::println);
        words.forEach(meinKonsument);

        Iterator<String> myIterator = words.iterator();
        myIterator.forEachRemaining(System.out::println);

    }



}
