package shop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElectronicsTest {

    private Electronics electronics;

    @BeforeEach
    public void setup() {
        this.electronics = new Electronics("E-0001", "Calculator", 5.99, 100);
    }

    @Test
    public void typeIsElectronics() throws Exception {
        assertEquals("ELECTRONICS", electronics.getType());
    }
}
