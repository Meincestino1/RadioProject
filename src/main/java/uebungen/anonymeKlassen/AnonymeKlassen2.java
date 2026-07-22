package uebungen.anonymeKlassen;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AnonymeKlassen2 {



    public static void main(String[] args) {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Jonathan Davies");

        Collections.sort(names, new Comparator<String>(

        ) {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }


        });

        System.out.println(names.toString());

    }

}
