package tests;

public abstract class DVehicle {

    String brand;

    public DVehicle(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "DVehicle{" + "brand='" + brand + '\'' + '}';
    }
}
