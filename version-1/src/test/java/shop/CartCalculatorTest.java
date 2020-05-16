package shop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartCalculatorTest {

    private Cart cart;
    private CartCalculator calculator;

    @BeforeEach
    public void setup() {
        this.cart = new Cart();
        this.calculator = new CartCalculator(cart);
    }

    @Test
    public void calculateTotalPrice() throws Exception {
        CartItem item1 = new CartItem("B-0001", "Little Mermaid", 10.50, 2);
        CartItem item2 = new CartItem("E-0001", "Calculator", 5.99, 3);
        cart.add(item1);
        cart.add(item2);

        double expected = 38.97;

        assertEquals(expected, calculator.calculateTotalPrice());
    }
}
