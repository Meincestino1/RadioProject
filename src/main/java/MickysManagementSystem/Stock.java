package MickysManagementSystem;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Stock {
    private double quantity;
    private List<HistoryEntry> history;

    public Stock(double initialQuantity) {
        this.quantity = Math.round(initialQuantity * 1000.0) / 1000.0;
        this.history = new ArrayList<>();
        // Anfangseintrag (Beispiel: Lagerbestand wird initialisiert)
        this.history.add(new HistoryEntry(this.quantity, 0.0, "System", "Initial"));
    }

    // HIER NOCH ÄNDERUNGEN VORNEHMEN
    // keine negativen Bestände zulassen. evtl. durch passwordeingabe eines berechtigten Users
    public void updateStock(double quantityChange, double price, String seller, String customer) {
        // Berechnung und sofortiges Runden von quantity auf 3 Dezimalstellen
        this.quantity = Math.round((this.quantity + quantityChange) * 1000.0) / 1000.0;
        this.history.add(new HistoryEntry(quantityChange, price, seller, customer));
    }



    // Hinzufügen von Lieferanteneingängen
    public void addStockFromSupplier(double quantityChange, double price, String supplier) {
        double newQuantity = this.quantity + quantityChange;
        this.quantity = Math.round(newQuantity * 1000.0) / 1000.0;
        this.history.add(new HistoryEntry(quantityChange, price, supplier, "Lager"));
    }

    // Methode zur formatierten Anzeige der Menge
    public String getFormattedQuantity() {
        // Direkt die Menge auf 3 Dezimalstellen formatieren
        if (quantity % 1 == 0) {
            return String.format("%.0f", quantity);  // Ganze Zahl ohne Nachkommastellen
        } else {
            // Wenn es eine Dezimalzahl ist, dann maximal 3 Nachkommastellen
            DecimalFormat df = new DecimalFormat("#.###");
            return df.format(quantity);
        }
    }

    public List<HistoryEntry> getHistory() {
        return new ArrayList<>(history);
    }


}
