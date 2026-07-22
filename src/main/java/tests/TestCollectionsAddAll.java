package tests;

import java.util.ArrayList;
import java.util.Collections;

public class TestCollectionsAddAll<T> {

    ArrayList<T> genericList = new ArrayList<T>();
    //ArrayList<String> stringList = new ArrayList<String>();

    public void readGenericList() {
        for (T element : genericList) {
            System.out.println(element);
        }
    }

    public ArrayList<T> getGenericList() {
        return genericList;
    }

    public static void main(String[] args) {

        TestCollectionsAddAll<String> stringList = new TestCollectionsAddAll<>();
        TestCollectionsAddAll<Integer> intList = new TestCollectionsAddAll<>();
        TestCollectionsAddAll<Number> numberList = new TestCollectionsAddAll<>();

        Collections.addAll(stringList.genericList, "Hallo", "Asshole", "Bigpussy", "WTF");
        Collections.addAll(intList.genericList, 1, 2);
        Collections.addAll(numberList.genericList, 2, 5.5, 70000L);
        System.out.println(stringList.genericList);
        System.out.println(intList.genericList);
        System.out.println("Methode:");
        stringList.readGenericList();
        intList.readGenericList();
        numberList.readGenericList();


    }

}
