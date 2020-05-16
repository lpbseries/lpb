package shop;

public class Book implements CatalogItem {

    private String type;
    private String identifier;
    private String name;
    private double unitPrice;
    private int remainingQuantity;
    private int soldQuantity;
    private double discount;

    public Book(String identifier, String name, double unitPrice, int remainingQuantity) {
        this.type = "BOOK";
        this.identifier = identifier;
        this.name = name;
        this.unitPrice = unitPrice;
        this.remainingQuantity = remainingQuantity;
        this.soldQuantity = 0;
        this.discount = 0.15;
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
        return (1.0 - discount) * unitPrice;
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

    public double getDiscount() {
        return discount;
    }
}
