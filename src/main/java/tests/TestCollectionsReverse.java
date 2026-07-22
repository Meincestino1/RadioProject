package tests;

import java.util.*;
import java.util.random.RandomGenerator;

public class TestCollectionsReverse<T> {

    ArrayList<T> bohList = new ArrayList<>();




    public static void main(String[] args) {

        TestCollectionsReverse<Integer> umdrehen = new TestCollectionsReverse<>();
        Collections.addAll(umdrehen.bohList, 3, 5, 17, 7, 9, 11);

        //Collections.sort(umdrehen.bohList);
        //Collections.reverse(umdrehen.bohList);
        //umdrehen.bohList.sort(Comparator.naturalOrder());
        //System.out.println(umdrehen.bohList);
        //System.out.println(Collections.binarySearch(umdrehen.bohList, 17));
        //System.out.println(umdrehen.bohList);
        //System.out.println(Collections.binarySearch(umdrehen.bohList, 5, Comparator.naturalOrder()));

        //Collections.shuffle(umdrehen.bohList);
        //Collections.shuffle(umdrehen.bohList, new Random(22));
        //Collections.addAll(umdrehen.bohList, 550);
        //Collections.shuffle(umdrehen.bohList);
        //System.out.println(umdrehen.bohList);

        // public static void shuffle(List<?> list)
        // Da shuffle keine neuen Elemente hinzfügt sondern nur die bestehende Reihenfolge ändert, reicht eine
        // einfache ? Wildcard. Diese bedeutet einfach "Liste mit beliebigem Typ", ohne Lese- oder Schreibbeschränkungen

        //System.out.println(umdrehen.bohList);
        //Collections.swap(umdrehen.bohList, 0, 1);
        //System.out.println(umdrehen.bohList);

        //System.out.println(umdrehen.bohList);
        //Collections.fill(umdrehen.bohList, 500);
        //System.out.println(umdrehen.bohList);

        //List<Object> source = new ArrayList<>(Arrays.asList(1, 3, 5, 7, "Cock sucker"));
        //List<Object> destination = new ArrayList<>(Arrays.asList(200, 300, 400, 500, 600, "Hello World"));
        //Collections.copy(destination, source);
        //System.out.println(destination);

        //List<String> list = new ArrayList<>(Arrays.asList("Hihou", "Hoho", "Hi", "Hxllo World"));
        // System.out.println(Collections.min(list));
//        System.out.println(Collections.min(list, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return Integer.compare(o1.length(), o2.length());
//            }
//        }));
//
//        System.out.println(Collections.max(list, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return Integer.compare(o1.length(), o2.length());
//            }
//        }));

//        List<String> list = new ArrayList<>(Arrays.asList("Hihou", "Hoho", "Hi", "Hxllo World"));
//        Collections.rotate(list, -1);
//        System.out.println(list);

//        List<Object> list = new ArrayList<>(Arrays.asList("Hihou", "Hoho", "Hi", "Hxllo World", 17, 5.55, 70000L));
//        Collections.replaceAll(list, 17, "Vaffanbrodo");
//        System.out.println(list);

        // List<Integer> ersteListe = new ArrayList(Arrays.asList(10, 17, 3, 5, 17, 3, 22));
        //List<Number> zweiteListee = new ArrayList(Arrays.asList(17, 3));
        // System.out.println(Collections.indexOfSubList(ersteListe, zweiteListee));
        // System.out.println(Collections.lastIndexOfSubList(ersteListe, zweiteListee));

        // public static <T> Collection<T> unmodifiableCollection(Collection<? extends T> c)
//        List<String> myList = new ArrayList<>(Arrays.asList("Hallo", "Du", "Vogel"));
//        List<Object> unmodList = Collections.unmodifiableList(myList);
//        System.out.println(unmodList);
//
//        SequencedCollection<Number> numberCollection = new ArrayList<>(Arrays.asList(1, 5, 3, 11, 8));
//        SequencedCollection<Number> unmodNumberCollection = Collections.unmodifiableSequencedCollection( numberCollection);
//        unmodNumberCollection.add(3);
//        System.out.println(unmodNumberCollection);

//        List<Integer> wtfList = new ArrayList<>(Arrays.asList(1, 5.5, 90000L, 88));
//        List<Number> checkedWtfList = Collections.checkedList(wtfList, Integer.class);
//        wtfList.add(5);
//        checkedWtfList.add(5);
//        wtfList.add(5.5);
//        checkedWtfList.add(5.5);

//        List<String> lalaListe = Collections.nCopies(22, "Foock");
//        System.out.println(lalaListe);


        




    }




}
