package uebungen.anonymeKlassen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AKPerson {

    String name;
    int age;

    public AKPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "AKPerson{" + "name='" + name + '\'' + ", age=" + age + '}';
    }

    public static void main(String[] args) {

        List<AKPerson> family = new ArrayList<>();
        family.add(new AKPerson("Michi", 43));
        family.add(new AKPerson("Mia", 5));
        family.add(new AKPerson("Sara", 24));
        family.add(new AKPerson("Liam", 8));

        Collections.sort(family, new Comparator<AKPerson>() {
            @Override
            public int compare(AKPerson o1, AKPerson o2) {
                //return o1.getAge() - o2.getAge();
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println(family);
    }

}
