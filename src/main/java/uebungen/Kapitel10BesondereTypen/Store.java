package uebungen.Kapitel10BesondereTypen;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Store {
    String name;
    Point location;


    public Store(String name, Point location) {
        this.name = name;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Store{" + "name='" + name + '\'' + ", location=" + location + '}';
    }

    public static List<Store> findStoresAround(Collection<Store> stores, Point center) {

        List<Store> returnList = new ArrayList<>(stores);
        returnList.sort(Comparator.comparingDouble(p -> p.location.distance(center)));
        returnList.forEach(System.out::println);
        return returnList;
    }

    public static void main(String[] args) {

        ArrayList<Store> storeList = new ArrayList<Store>();
        storeList.add(new Store("Erster Schtore", new Point(2, 5)));
        storeList.add(new Store("Zweiter Schtore", new Point(17, 3)));
        storeList.add(new Store("Dritter Schtore", new Point(11, 6)));
        storeList.add(new Store("Vierter Schtore", new Point(15, 7)));

        findStoresAround(storeList, new Point(0, 0));



    }
}
