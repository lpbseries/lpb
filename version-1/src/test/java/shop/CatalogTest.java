package shop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CatalogTest {

    private Catalog catalog;
    private List<CatalogItem> catalogItems;

    @BeforeEach
    public void setup() {
        this.catalogItems = new ArrayList<CatalogItem>();
        Book book = new Book("B-0001", "Little Mermaid", 10.50, 100);
        Electronics electronics = new Electronics("E-0001", "Calculator", 5.99, 100);
        catalogItems.add(book);
        catalogItems.add(electronics);
        this.catalog = new Catalog(catalogItems);
    }

    @Test
    public void catalogHasItems() throws Exception {
        assertNotNull(catalog.getCatalogItems());
    }

    @Test
    public void catalogItemsAreNotEmpty() throws Exception {
        assertTrue(catalog.getCatalogItems().size() > 0);
    }

    @Test
    public void searchCatalogItem() throws Exception {
        String identifier = "B-0001";

        Optional<CatalogItem> item = catalog.search(identifier);

        assertTrue(item.isPresent());
    }
}
