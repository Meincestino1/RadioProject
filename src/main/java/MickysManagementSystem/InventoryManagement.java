package MickysManagementSystem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryManagement {      // Klasse zum verwalten der Lagerbestände
    private Map<String, Stock> inventory = new HashMap<>(); // Fasst alle Artikel im lager in der map inventory zusammen

    // Methode um Lagerstand zu aktualisieren
    public void updateInventory(String itemNumber, double quantityChange, double price, String seller, String customer) {
        Stock stock = inventory.get(itemNumber);
        if (stock == null) {
            stock = new Stock(0);  // Initialer Bestand von 0
            inventory.put(itemNumber, stock);
        }
        stock.updateStock(quantityChange, price, seller, customer);
    }

    public void checkInventoryAndAddStockFromSupplier(String itemNumber, double quantityChange, double price, String supplier) {
        Stock stock = inventory.get(itemNumber); //erstellt nur referenz auf bestehendes Stock Objekt, dadurch
        if (stock == null) {                    // werden alle Änderungen direkt auf das Stock Element vorgenommen
            stock = new Stock(0);  // Initialer Bestand von 0
            inventory.put(itemNumber, stock);
        }
        stock.addStockFromSupplier(quantityChange, price, supplier);
    }

    public String getStockInfo(String itemNumber) {
        Stock stock = inventory.get(itemNumber);
        if (stock != null) {
            return stock.getFormattedQuantity();
        } else {
            return "Artikel nicht gefunden!";
        }
    }

    public List<HistoryEntry> getHistory(String itemNumber) {
        Stock stock = inventory.get(itemNumber);
        if (stock != null) {
            return stock.getHistory();
        } else {
            return null;
        }
    }
}
