package shop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {

    private Book book;

    @BeforeEach
    public void setup() {
        this.book = new Book("B-0001", "Little Mermaid", 10.50, 100);
    }

    @Test
    public void typeIsBook() throws Exception {
        assertEquals("BOOK", book.getType());
    }
}
