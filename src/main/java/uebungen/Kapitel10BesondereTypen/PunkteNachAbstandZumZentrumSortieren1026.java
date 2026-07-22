package uebungen.Kapitel10BesondereTypen;

import java.awt.*;
import java.sql.Array;
import java.util.Arrays;
import java.util.Comparator;

public class PunkteNachAbstandZumZentrumSortieren1026 {


    // Aufgabe 10.2.6
    public static class PointDistanceToZeroComparator implements Comparator<Point> {
        @Override
        public int compare(Point p1, Point p2) {
            double x = p1.distanceSq(0, 0);
            double y = p2.distanceSq(0, 0);
            return Double.compare(x, y);
        }
    }

    public static void main(String[] args) {


        Point[] points = {new Point(9, 3), new Point(3, 4), new Point(4, 3), new Point(1, 2)};
        //PunkteNachAbstandZumZentrumSortieren1026 objekt = new PunkteNachAbstandZumZentrumSortieren1026();
        Arrays.sort(points, new PointDistanceToZeroComparator());
        Arrays.asList(points).forEach(System.out::println);
    }

}
