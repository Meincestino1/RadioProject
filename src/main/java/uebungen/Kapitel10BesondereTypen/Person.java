package uebungen.Kapitel10BesondereTypen;

import java.awt.*;
import java.util.Arrays;
import java.util.Objects;


// vorher mach ich lambdas, dann kann ich hier weitermachen
// Z klassen hatte ich schon früher mal gemacht, hab mich entschieden nochmal von vorne anzufangen
// equals methoden auf github hab ich schon angeschaut
public class Person {

    public long id;
    public int age;
    public double income;
    public boolean isDrugLord;
    public String name;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;
        return id == person.id && age == person.age && Double.compare(income, person.income) == 0 && isDrugLord == person.isDrugLord && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(id);
        result = 31 * result + age;
        result = 31 * result + Double.hashCode(income);
        result = 31 * result + Boolean.hashCode(isDrugLord);
        result = 31 * result + Objects.hashCode(name);
        return result;
    }

    public static void main(String[] args) {

        String[] strings = {"A", "X", "C"};
        Arrays.sort(strings);
        for (String string : strings) {
            System.out.println(string);
        }

        Point[] points = {
                new Point(9, 3),
                new Point(3, 4),
                new Point(4, 3),
                new Point(1, 2),
        };
        //Arrays.sort(points);




    }
}
