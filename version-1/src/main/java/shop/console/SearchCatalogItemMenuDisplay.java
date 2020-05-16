package shop.console;

import shop.Catalog;
import shop.CatalogItem;
import shop.Shop;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class SearchCatalogItemMenuDisplay implements MenuDisplay {

    private static final String EXIT_MENU_KEY = "b";

    private Shop shop;
    private Catalog catalog;

    public SearchCatalogItemMenuDisplay(Shop shop) {
        this.shop = shop;
        this.catalog = shop.getCatalog();
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
        System.out.print("Enter identifier to search or B to go back: ");
    }

    @Override
    public void process(String command) {
        List<CatalogItem> items = catalog.getCatalogItems();

        Optional<CatalogItem> found = items.stream().filter(i -> i.getIdentifier().equalsIgnoreCase(command)).findFirst();

        if (found.isPresent()) {
            System.out.println("Identifier\tName\tUnit Price");
            CatalogItem item = found.get();
            System.out.println(item.getIdentifier() + "\t" + item.getName() + "\t" + item.getUnitPrice());
        }
        else {
            System.out.println("Item not found");
        }
    }
}
