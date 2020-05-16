package shop;

public class Electronics implements CatalogItem {

    private String type;
    private String identifier;
    private String name;
    private double unitPrice;
    private int remainingQuantity;
    private int soldQuantity;

    public Electronics(String identifier, String name, double unitPrice, int remainingQuantity) {
        this.type = "ELECTRONICS";
        this.identifier = identifier;
        this.name = name;
        this.unitPrice = unitPrice;
        this.remainingQuantity = remainingQuantity;
        this.soldQuantity = 0;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getUnitPrice() {
        return unitPrice;
    }

    @Override
    public int getRemainingQuantity() {
        return remainingQuantity;
    }

    @Override
    public int getSoldQuantity() {
        return soldQuantity;
    }

    @Override
    public void increaseSoldQuantityBy(int quantity) {
        soldQuantity = soldQuantity + quantity;
    }

    @Override
    public void reduceQuantityBy(int quantity) {
        remainingQuantity = remainingQuantity - quantity;
    }
}
