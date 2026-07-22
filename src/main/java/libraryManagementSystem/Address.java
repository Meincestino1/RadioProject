package libraryManagementSystem;

public class Address {
    private String street;
    private String city;
    private String postalCode;
    private String country;

    // Konstruktoren, Getter und Setter
    public Address(String street, String city, String postalCode, String country) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    // Getter und Setter
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    // Weitere Getter und Setter...

    @Override
    public String toString() {
        return street + ", " + city + ", " + postalCode + ", " + country;
    }
}