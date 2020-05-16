package shop.console;

import shop.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CheckoutMenuDisplay implements MenuDisplay {

    private static final String EXIT_MENU_KEY = "b";

    private Shop shop;
    private Catalog catalog;
    private Cart cart;

    private enum MenuOptions {
        OPTION_P("P"),
        OPTION_B("B");

        private MenuOptions(String option) {
            this.option = option;
        }

        private static final Map<String, MenuOptions> ENUM_MAP;

        public String option;

        public String getOption() {
            return option;
        }

        static {
            Map<String, MenuOptions> map = new ConcurrentHashMap<String, MenuOptions>();
            for (MenuOptions instance : MenuOptions.values()) {
                map.put(instance.getOption(), instance);
            }
            ENUM_MAP = Collections.unmodifiableMap(map);
        }

        public static MenuOptions get(String name) {
            return ENUM_MAP.get(name);
        }
    }

    public CheckoutMenuDisplay(Shop shop) {
        this.shop = shop;
        this.catalog = shop.getCatalog();
        this.cart = shop.getCart();
    }

    @Override
    public void display() {
        String command;

        Scanner scanner = new Scanner(System.in);

        do {
            displayMenuOptions();
            command = scanner.next();
            process(command);
        } while (!command.equalsIgnoreCase(EXIT_MENU_KEY));
    }

    @Override
    public void displayMenuOptions() {
        displayCartItems();
        System.out.println("Select one of the following options.");
        System.out.println("P - Make payment");
        System.out.println("B - Go back to the previous menu");
        System.out.print("Enter your option here: ");
    }

    private void displayCartItems() {
        Map<String, CartItem> cartItems = cart.getItems();

        if (cartItems.size() > 0) {
            CartCalculator cartCalculator = shop.getCartCalculator();

            System.out.println("Identifier\tName\tQuantity\tUnit Price");


            Set<String> keys = cartItems.keySet();
            for (String key : keys) {
                CartItem cartItem = cartItems.get(key);
                System.out.println(cartItem.getIdentifier() + "\t" + cartItem.getName() + "\t" + cartItem.getQuantity() + "\t" + cartItem.getUnitPrice());
            }

            System.out.println("Total: " + cartCalculator.calculateTotalPrice());
        }
        else {
            System.out.println("");
            System.out.println("Your cart is empty");
            System.out.println("");
        }
    }

    @Override
    public void process(String command) {
        MenuOptions selectedOption = MenuOptions.get(command.toUpperCase());

        switch (selectedOption) {
            case OPTION_P:
                makePayment();
                updateCatalog();
                emptyCart();
                break;
            default:
                break;
        }
    }

    private void makePayment() {
        System.out.println("Your items have been paid");
    }

    private void updateCatalog() {
        Map<String, CartItem> cartItems = cart.getItems();
        Set<String> keys = cartItems.keySet();

        List<CatalogItem> catalogItems = catalog.getCatalogItems();

        for (String key : keys) {
            CartItem cartItem = cartItems.get(key);

            for (CatalogItem catalogItem : catalogItems) {
                if (cartItem.getIdentifier().equalsIgnoreCase(catalogItem.getIdentifier())) {
                    catalogItem.reduceQuantityBy(cartItem.getQuantity());
                    catalogItem.increaseSoldQuantityBy(cartItem.getQuantity());
                }
            }
        }
    }

    private void emptyCart() {
        cart.empty();
    }
}
