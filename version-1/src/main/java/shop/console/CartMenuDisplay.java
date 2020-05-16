package shop.console;

import shop.Cart;
import shop.CartItem;
import shop.Shop;

import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class CartMenuDisplay implements MenuDisplay {

    private static final String EXIT_MENU_KEY = "b";

    private Shop shop;
    private Cart cart;

    private enum MenuOptions {
        OPTION_B("B"),
        OPTION_E("E");

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

    public CartMenuDisplay(Shop shop) {
        this.shop = shop;
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
        displayCart();
        System.out.println("Select one of the following options.");
        System.out.println("B - Go back to the previous menu");
        System.out.println("E - Empty your cart");
        System.out.print("Enter your option here: ");
    }

    private void displayCart() {
        Map<String, CartItem> cartItems = cart.getItems();
        if (cartItems.size() > 0) {
            System.out.println("You have the following items in your cart");
            System.out.println("Item\tQuantity\tUnit Price");
            int count = 1;
            Set<String> keys = cartItems.keySet();
            for (String key : keys) {
                CartItem cartItem = cartItems.get(key);
                System.out.println(count + ") " + cartItem.getIdentifier() + "\t" + cartItem.getQuantity() + "\t" + cartItem.getUnitPrice());
            }
        }
        else {
            System.out.println("");
            System.out.println("You have nothing in your cart");
            System.out.println("");
        }
    }

    @Override
    public void process(String command) {
        MenuOptions selectedOption = MenuOptions.get(command.toUpperCase());

        switch (selectedOption) {
            case OPTION_E:
                emptyCart();
                break;
            default:
                break;
        }
    }

    private void emptyCart() {
        Cart cart = shop.getCart();
        cart.empty();
    }
}
