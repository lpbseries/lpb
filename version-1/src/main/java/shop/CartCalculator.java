package shop;

import java.util.Map;
import java.util.Set;

public class CartCalculator {

    private Cart cart;

    public CartCalculator(Cart cart) {
        this.cart = cart;
    }

    public double calculateTotalPrice() {
        double total = 0.0;

        Map<String, CartItem> items = cart.getItems();
        Set<String> keys = items.keySet();

        for (String key : keys) {
            CartItem item = items.get(key);
            total += item.getUnitPrice() * item.getQuantity();
        }

        return total;
    }
}
