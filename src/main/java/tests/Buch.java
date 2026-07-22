package tests;

public class Buch implements Prodotto{

    private String name;
    private double preis;

    public Buch(String name, double preis) {
        this.name = name;
        this.preis = preis;
    }

    @Override
    public String getname() {
        return name;
    }

    @Override
    public double getpreis() {
        return preis;
    }

    @Override
    public String toString() {
        return "Buch{" + "name='" + name + '\'' + ", preis=" + preis + '}';
    }
}
