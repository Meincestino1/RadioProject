package uebungen.anonymeKlassen;
import java.util.Arrays;
import java.util.Comparator;

public class AnonymeKlassen {





    public static void main(String[] args) {

        Integer[] intArray = { 1, 2, 3, 4, 5 };

        Arrays.sort(intArray, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }

        });

        System.out.println(Arrays.toString(intArray));
    }

}
