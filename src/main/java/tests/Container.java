package tests;

import java.util.ArrayList;
import java.util.List;

class Tier {}

class Hund extends Tier {
    String name;
    public Hund(String name) {this.name = name;}
}

class Katz extends Tier{
    String name;
    public Katz(String name) {this.name = name;}
}

class Maus extends Tier{
    String name;
    public Maus(String name) {this.name = name;}
}

public class Container<T> {

    private final List<T> content = new ArrayList<>();

    public void add(T item) {content.add(item);}

    // Methode mit Varargs für mehrere Objekte
    public void addAll(T... items) {
        for (T item : items) {
            content.add(item);
        }
    }

    public <U extends Tier> void copyFrom(Container<U> other) {
        for (U item : other.content) {
            content.add((T) item);  // Typumwandlung nötig
        }
    }

    

    public static void main(String[] args) {
        Hund hund = new Hund("Bello");
        Katz cat = new Katz("Juli");
        Maus maus = new Maus("Piepsi");
        Container<Tier> container1 = new Container<>();
        Container<Maus> container2 = new Container<>();
        container1.add(maus);
        container1.addAll(hund, cat);
        //container2.add(hund);
    }

}
