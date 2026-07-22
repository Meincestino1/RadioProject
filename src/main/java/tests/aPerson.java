package tests;

import java.util.function.Function;
import java.util.function.Supplier;

public class aPerson {

    String name;

    public aPerson() {
        this.name = "Unbekannt";
    }

    public aPerson(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + '}';
    }


}
