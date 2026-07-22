package uebungen.WiederholungKaptitel11;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Store {

    Point location;
    String name;

    public Store(Point location, String name) {
        this.location = new Point(location.x, location.y);
        this.name = name;
    }



    public static List<Store> findStoreAround(Collection<Store> stores, Point center) {

        List<Store> result = new ArrayList<>(stores);

        class DistanceComparator implements Comparator<Store> {
            @Override
            public int compare(Store o1, Store o2) {
                double distanceToCenterO1 = o1.location.distanceSq(center.x, center.y);
                double distanceToCenterO2 = o2.location.distanceSq(center.x, center.y);
                return Double.compare(distanceToCenterO1, distanceToCenterO2);
            }
        }
        result.sort(new DistanceComparator());
        return result;
    }

    public static void main(String[] args) {
        Point center = new Point(0, 0);
        Collection<Store> storeList = new ArrayList<>();
        storeList.add(new Store(new Point(8, 6), "Milan"));
        storeList.add(new Store(new Point(5, 2), "Rome"));
        storeList.add(new Store(new Point(17, 5), "Bozen"));
        List<Store> ausgabeListe = findStoreAround(storeList,center);
        for (Store store : ausgabeListe) {
            System.out.println(store.name);
        }
    }

}
