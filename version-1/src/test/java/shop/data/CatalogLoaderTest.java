package shop.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CatalogLoaderTest {

    private CatalogLoader catalogLoader;

    @BeforeEach
    public void setup() {
        this.catalogLoader = new CatalogLoader();
    }

    @Test
    public void catalogLoaderLoadedItemsIsNotNull() throws Exception {
        assertNotNull(catalogLoader.getItems());
    }

    @Test
    public void catalogLoaerLoadedItemsIsNotEmpty() throws Exception {
        assertTrue(catalogLoader.getItems().size() > 0);
    }
}
