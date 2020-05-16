package shop;

public interface CatalogItem {

    public String getType();
    public String getIdentifier();
    public String getName();
    public double getUnitPrice();
    public int getRemainingQuantity();
    public int getSoldQuantity();
    public void increaseSoldQuantityBy(int quantity);
    public void reduceQuantityBy(int quantity);
}
