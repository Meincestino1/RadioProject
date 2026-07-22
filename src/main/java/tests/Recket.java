package tests;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Scanner;

public class Recket<T, V> {

    T name;
    V ard;

    public Recket(T name, V ard) {
        this.name = name;
        this.ard = ard;
    }

    public T getName() {
        return name;
    }

    public static <T, V> Recket<T, V> newInstance(T name, V ard) {
        return new Recket<>(name, ard);
    }


    public static <T> void main(String[] args) {






        /*T[] array = (T[]) Array.newInstance( String.class, 2 );
        array[0] = (T) (String) "Fuhrpark";
        array[1] = (T) String.class.cast("Waltherpark");
        System.out.println(array[0]);
        System.out.println(array[1]);*/

        for (Method field : String.class.getDeclaredMethods()) {
            System.out.println(field.getName() + " -is Syntetic: " + field.isSynthetic());
        }

        Comparator<String> stringComparator = (s1, s2) -> s1.compareTo(s2);
        int ergebnis = stringComparator.compare("Apfel", "Birne");
        System.out.println(ergebnis);
        boolean ignoreCase = new Scanner(System.in).nextBoolean();
        System.out.println(ignoreCase);




    }

}
