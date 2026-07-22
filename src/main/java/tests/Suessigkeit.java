package tests;

import java.util.Objects;

public class Suessigkeit implements Comparable<Suessigkeit>{

    int calories;
    double weight;

    public Suessigkeit(int calories, double weight) {
        this.calories = calories;
        this.weight = weight;
    }

    @Override
    public int compareTo(Suessigkeit o) {
        int caloriesCompariser = Integer.compare(this.calories, o.calories);
        if (caloriesCompariser != 0) {
            return caloriesCompariser;
        }
        return Double.compare(this.weight, o.weight);
    }

    Integer boh = Integer.valueOf("g");

    public static void main(String[] args) {
        Suessigkeit schleckerle = new Suessigkeit(1, 5.4);
        Suessigkeit drecksZuig = new Suessigkeit(1, 5.5);
        int ergebnis = schleckerle.compareTo(drecksZuig);
        System.out.println(ergebnis);

        int az = 55;
        Number num = 77;
        byte bz = num.byteValue();

    }



}
