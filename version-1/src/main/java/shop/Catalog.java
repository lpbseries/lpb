package shop;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Catalog {

    private List<CatalogItem> catalogItems;

    public Catalog(List<CatalogItem> catalogItems) {
        this.catalogItems = catalogItems;
    }

    public List<CatalogItem> getCatalogItems() {
        return catalogItems;
    }

    public Optional<CatalogItem> search(String identifier) {
        if (Objects.isNull(catalogItems) || catalogItems.size() == 0)
            return Optional.empty();

        return catalogItems.stream().filter(i -> i.getIdentifier().equalsIgnoreCase(identifier)).findFirst();
    }
}
