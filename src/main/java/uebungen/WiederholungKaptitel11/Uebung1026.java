package uebungen.WiederholungKaptitel11;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;

public class Uebung1026 {

    Point[] points = {new Point(9, 3), new Point(3, 4), new Point(4, 3), new Point(1, 2)};
    Comparator<Point> pointComparator = (Point p1, Point p2) -> {
        double distanceToZeroPoint1 = p1.distanceSq(0, 0);
        double distanceToZeroPoint2 = p2.distanceSq(0, 0);
        return Double.compare(distanceToZeroPoint1, distanceToZeroPoint2);
    };

    public static void main(String[] args) {
        Uebung1026 compi = new Uebung1026();
        Arrays.sort(compi.points, compi.pointComparator);
        for (int i = 0; i < compi.points.length; i++) {
            System.out.println(compi.points[i]);
        }
    }

}
