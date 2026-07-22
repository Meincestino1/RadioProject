package MickysManagementSystem;

public class Part {

    private String itemNumber;
    private String description;
    private Stock stock;    // Attention, please use the getter getFormattedStockQuantity
    private double price;
    private int commodityGroup;

    private boolean duty;
    private String tag1;
    private String tag2;
    private String tag3;
    private String notes;

    public Part(String itemNumber, String description, Stock stock, double price, int commodityGroup) {
        this.itemNumber = itemNumber;
        this.description = description;
        this.stock = stock;
        this.price = price;
        this.commodityGroup = commodityGroup;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public String getDescription() {
        return description;
    }

    // Getter für die formatierte Menge
    public String getFormattedStockQuantity() {
        return stock.getFormattedQuantity();  // Auf die Methode von Stock delegieren
    }

    public double getPrice() {
        return price;
    }

    public int getCommodityGroup() {
        return commodityGroup;
    }

    public boolean isDuty() {
        return duty;
    }

    public String getTag1() {
        return tag1;
    }

    public String getTag2() {
        return tag2;
    }

    public String getTag3() {
        return tag3;
    }

    public String getNotes() {
        return notes;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCommodityGroup(int commodityGroup) {
        this.commodityGroup = commodityGroup;
    }

    public void setDuty(boolean duty) {
        this.duty = duty;
    }

    public void setTag1(String tag1) {
        this.tag1 = tag1;
    }

    public void setTag2(String tag2) {
        this.tag2 = tag2;
    }

    public void setTag3(String tag3) {
        this.tag3 = tag3;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }


}
