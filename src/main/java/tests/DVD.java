package tests;

public class DVD implements Prodotto {

    private String name;
    private double preis;

    public DVD(String name, double preis) {
        this.name = name;
        this.preis = preis;
    }

    @Override
    public String getname() {
        return "";
    }

    @Override
    public double getpreis() {
        return 0;
    }

    @Override
    public String toString() {
        return "DVD: " + name + ", " + preis + " €";
    }
}
