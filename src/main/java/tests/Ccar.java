package tests;

public class Ccar {

    String brand;
    int year;

    public Ccar() {
        this.brand = "Unbekannt";
        this.year = 0;
    }

    public Ccar(String brand) {
        this.brand = brand;
        this.year = 0;
    }

    public Ccar(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Ccar{" + "brand='" + brand + '\'' + ", year=" + year + '}';
    }
}
