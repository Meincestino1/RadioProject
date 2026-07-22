package tests;

import java.util.ArrayList;

class Pair<T, U> {

    public final T first;
    public final U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public static void main(String[] args) {

        Pair<String, Double> pair = new Pair<>("Hallo", 12.5);
        String first1 = pair.first;
        Double second1 = pair.second;

        Pair<String, String> pair2 = new Pair<>("Hallo", "Welt");
        System.out.println("Testntest");
        System.out.println(pair2.first + pair2.second);

        String tfw1 = "Hallo Welt";
        int tfw2 = 55;
        ArrayList wtf = new ArrayList();
        wtf.add(tfw1);
        wtf.add(tfw2);
        String object = (String) wtf.get(0);
        int object2 = (int) wtf.get(1);
        System.out.println(object);
        System.out.println(object2);
    }


}
