package shop.console;

import shop.*;

import java.util.Optional;
import java.util.Scanner;

public class AddCartItemMenuDisplay implements MenuDisplay {

    private static final String EXIT_MENU_KEY = "b";

    private Shop shop;
    private Catalog catalog;
    private Cart cart;

    public AddCartItemMenuDisplay(Shop shop) {
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
        System.out.println("To add an item to cart, enter the identifier followed by a comma and required quantity");
        System.out.println("Example: B-0001, 1");
        System.out.print("Enter identifier followed by quantity or B to to back to the previous menu: ");
    }

    @Override
    public void process(String command) {
        String[] inputs = command.split(",");

        if (inputs.length == 2) {
            String identifier = inputs[0];
            int quantity = Integer.parseInt(inputs[1]);

            Optional<CatalogItem> found = catalog.search(identifier);

            if (found.isPresent()) {
                CatalogItem item = found.get();
                CartItem cartItem = new CartItem(item.getIdentifier(), item.getName(), item.getUnitPrice(), quantity);
                cart.add(cartItem);
            }
        }
    }
}
