package shop;

public class CartItem {

    private String identifier;
    private String name;
    private double unitPrice;
    private int quantity;

    public CartItem(String identifier, String name, double unitPrice, int quantity) {
        this.identifier = identifier;
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }
}
