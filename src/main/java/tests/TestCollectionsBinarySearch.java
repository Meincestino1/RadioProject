package tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class TestCollectionsBinarySearch<T extends Comparable<T>> {

    ArrayList<T> genericList = new ArrayList<>();
    ArrayList<T> genericList2 = new ArrayList<>();

    public void addElements(T... elements) {
        Collections.addAll(genericList, elements);
        Collections.sort(genericList); // Um BinarySearch nutzen zu können muss die Liste sortiert sein
    }

    public void addElementsNotSorted(T... elements) {
        Collections.addAll(genericList2, elements);
    }

    // Die Methode BinarySearch wurde mit Wildcards und nicht mit einem Typ T realisiert, da Generics in Java
    // nicht kovariant, sondern invariant sind! Wenn man dann T als Number einsetzen würde, wäre die Methode genau als
    // Number fesgelegt, und würde eine Liste vom Typ List<Number> erwarten. Aber wegen der Invarianz wäre z.B. eine
    // List<Integer> keine Number. Aus diesem Grund wurde diese Methode mit Wildcards, also List<? extends T> realisiert,
    // so kann man T oder einen Untertyp von T übergeben. Also Number, oder Integer oder Double usw..

    public static void main(String[] args) {

        TestCollectionsBinarySearch<Integer> integerList = new TestCollectionsBinarySearch<Integer>();
        //TestCollectionsBinarySearch<Number> doubleList = new TestCollectionsBinarySearch<Number>();

        integerList.addElements(50, 2, 77, 55, 1000, 700000);
        //doubleList.addElementsNotSorted(5.5, 7.7, 1.3, 6.6, 3.3, 0.05, 0.01, 0.02, 0.06, 0.0111);
        int indexI = Collections.binarySearch(integerList.genericList, 55);
        //Collections.sort(doubleList.genericList2, Comparator.reverseOrder());
        //int indexD = Collections.binarySearch(doubleList.genericList2, 0.05, Comparator.reverseOrder());
        System.out.println("Index of 55: " + indexI);
        //System.out.println("Index of 0.05: " + indexD);

    }

}
