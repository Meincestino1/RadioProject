package tests;

public class Produkt {

    String id;
    String beschreibung;

    public <T> Produkt(Object id) {
        this.id = String.valueOf(id); // ID in String umwandeln
    }

    @Override
    public String toString() {
        return "Produkt: " + id; // Eine einfache Darstellung für `Produkt`
    }
}
