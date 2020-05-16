package shop;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<String, CartItem> items;

    public Cart() {
        this.items = new HashMap<>();
    }

    public Map<String, CartItem> getItems() {
        return items;
    }

    public void add(CartItem item) {
        items.put(item.getIdentifier(), item);
    }

    public void remove(String identifier) {
        items.remove(identifier);
    }

    public void empty() {
        this.items = new HashMap<>();
    }
}
