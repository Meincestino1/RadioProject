package tests;

public class DCar extends DVehicle {

    int year;


    public DCar(String brand, int year) {
        super(brand);
        this.year = year;
    }

    @Override
    public String toString() {
        return "DCar{" + "year=" + year + ", brand='" + super.brand + '\'' + "} " ;
    }


}
