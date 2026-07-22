// Datei: FactoryDemo.java
package tests;

import java.util.function.Function;
import java.util.function.Supplier;

public class aFactoryDemo {

    // a) Supplier für parameterlosen Konstruktor
    public static <T> T createBySupplier(Supplier<T> factory) {
        return factory.get();
    }

    // b) Function für Konstruktor mit einem Parameter
    public static <P, T> T createByFunction(Function<P, T> factory, P param) {
        return factory.apply(param);
    }

    public static void main(String[] args) {
        // Erstellt via parameterlosem Konstruktor
        aPerson p1 = createBySupplier(aPerson::new);
        System.out.println(p1);  // Person{name='Unbekannt'}

        // Erstellt via String‑Konstruktor mit Namen
        aPerson p2 = createByFunction(aPerson::new, "Alice");
        System.out.println(p2);  // Person{name='Alice'}
    }
}