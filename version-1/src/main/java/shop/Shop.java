package shop;

import shop.data.CatalogLoader;

public class Shop {

    private Cart cart;
    private CatalogLoader catalogLoader;
    private Catalog catalog;
    private CartCalculator cartCalculator;

    public Shop() {
        this.cart = new Cart();
        this.catalogLoader = new CatalogLoader();
        this.catalog = new Catalog(catalogLoader.getItems());
        this.cartCalculator = new CartCalculator(cart);
    }

    public Cart getCart() {
        return cart;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public CartCalculator getCartCalculator() {
        return cartCalculator;
    }
}
