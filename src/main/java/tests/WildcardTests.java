package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class  WildcardTests <T> {

    List<String> src = List.of("Halunke", "Wauwau", "MiaoMiao");
    List<String> dest = new ArrayList<>();



    public static <T> void copyFirst(
            List<  ? extends T  > src,
            List<  ? super T  > dest
    ) {
        if (!src.isEmpty()) {
            dest.add( src.get(0) );
        }
    }

    public static void printAll(List<? extends CharSequence> list) {
        for (CharSequence element : list) {
            System.out.println(element);
        }
    }

    public static void addHello(List<? super String> list) {
        list.add("Hello");
    }

    public static void copyStrings(List<String> source, List<? super String> destination) {
        for(String element : source) {
            destination.add(element);
        }
    }

    public static void filterAndAdd(List<? extends Number> source, List<? super Number> destination, double threshold) {

            for (Number element : source) {
            if (element.doubleValue() > threshold) {
                destination.add(element);
            }
        }
    }

    public static <T> void mergeLists(List<? extends T> source, List<? super T> destination) {
        for (T element : source) {
            destination.add(element);
        }
        System.out.println(destination);
    }









    public static void main(String[] args) {

        List<Number>   numList   = new ArrayList<>(List.of(1, 2.5, 3));
        List<Integer>  intList   = List.of(4, 5, 6);        // (immutable)
        List<Double>   dblList   = List.of(2.5, 3.5);       // (immutable)
        List<Object>   objList   = new ArrayList<>();

        copyFirst(intList, numList);
        copyFirst(dblList, numList);
        //copyFirst(numList, intList);
        copyFirst(intList, objList);
        copyFirst(dblList, objList);
        copyFirst(numList, objList);
        //copyFirst(objList, numList);
        //copyFirst();
        WildcardTests fuckZugriff = new WildcardTests();
        copyFirst(fuckZugriff.src, fuckZugriff.dest);
        System.out.println(fuckZugriff.dest);

        List<String> horrorList = new ArrayList<>();
        horrorList.add("Sibo");
        printAll(List.of("Hallo", "Welt"));
        printAll(List.of(new StringBuilder("Hi"), new StringBuffer("Du")));
        printAll(horrorList);

        addHello(horrorList);
        System.out.println(horrorList);


        List<String> strings = List.of("A", "B", "C");
        List<CharSequence> seqs = new ArrayList<>();
        List<Object> objs = new ArrayList<>();

        copyStrings(strings, seqs);
        copyStrings(strings, objs);
        System.out.println(seqs);
        System.out.println(objs);

        List<Integer> ints = List.of(1, 5, 9);
        List<Number> nums = new ArrayList<>();
        filterAndAdd(ints, nums, 6);  // soll nur 5 und 9 hinzufügen
        System.out.println(nums);


        List<Integer> ints2 = List.of(1, 2, 3);
        List<Number> nums2 = new ArrayList<>();
        mergeLists(ints2, nums2); // nums enthält jetzt 1, 2, 3

        List<Number> list = new ArrayList<>(List.of(5));
        //replaceIfGreater(list, 7);  // ersetzt 5 durch 7
        System.out.println(list);

    }




}
