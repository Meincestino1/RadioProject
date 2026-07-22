package MickysManagementSystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HistoryEntry {
    private double quantityChange;
    private double price;
    private String seller;
    private String customer;
    private String dateChange;

    public HistoryEntry(double quantityChange, double price, String seller, String customer) {
        this.quantityChange = quantityChange;
        this.price = price;
        this.seller = seller;
        this.customer = customer;

        // Aktuelles Datum und Uhrzeit im Format "dd.MM.yyyy HH:mm:ss"
        LocalDateTime now = LocalDateTime.now(); // Dynamische Uhrzeit
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        this.dateChange = now.format(formatter);  // Formatieren in "dd.MM.yyyy HH:mm:ss"
    }

    @Override
    public String toString() {
        return String.format("Menge: %.2f, Preis: %.2f, Verkäufer: %s, Kunde: %s, Datum: %s",
                quantityChange, price, seller, customer, dateChange);
    }


    // Getter / Setter:

    public double getQuantityChange() {
        return quantityChange;
    }

    public void setQuantityChange(double quantityChange) {
        this.quantityChange = quantityChange;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getDateChange() {
        return dateChange;
    }

    public void setDateChange(String dateChange) {
        this.dateChange = dateChange;
    }
}