package shop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CartTest {

    private Cart cart;

    @BeforeEach
    public void setup() {
        this.cart = new Cart();
    }

    @Test
    public void cartHasItems() throws Exception {
        assertNotNull(cart.getItems());
    }

    @Test
    public void cartCanAddItems() throws Exception {
        CartItem item = new CartItem("B-0001", "Little Mermaid", 10.50, 1);
        cart.add(item);

        assertEquals(1, cart.getItems().size());
    }

    @Test
    public void cartCanRemoveItems() throws Exception {
        CartItem item = new CartItem("B-0001", "Little Mermaid", 10.50, 1);
        cart.add(item);

        String identifier = "B-0001";

        cart.remove(identifier);

        assertEquals(0, cart.getItems().size());
    }

    @Test
    public void cartCanBeEmptied() throws Exception {
        CartItem item = new CartItem("B-0001", "Little Mermaid", 10.50, 1);
        cart.add(item);

        String identifier = "B-0001";

        cart.empty();

        assertEquals(0, cart.getItems().size());
    }
}
