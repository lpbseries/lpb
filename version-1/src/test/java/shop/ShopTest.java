package shop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ShopTest {

    private Shop shop;

    @BeforeEach
    public void setup() {
        this.shop = new Shop();
    }

    @Test
    public void cartIsNotNull() throws Exception {
        assertNotNull(shop.getCart());
    }

    @Test
    public void catalogIsNotNull() throws Exception {
        assertNotNull(shop.getCatalog());
    }
}
