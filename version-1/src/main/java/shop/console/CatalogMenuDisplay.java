package shop.console;

import shop.Catalog;
import shop.CatalogItem;
import shop.Shop;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CatalogMenuDisplay implements MenuDisplay {

    private static final String EXIT_MENU_KEY = "b";

    private Shop shop;
    private Catalog catalog;

    private enum MenuOptions {
        OPTION_A("A"),
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

    public CatalogMenuDisplay(Shop shop) {
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
        displayCatalog();
        System.out.println("Select one of the following options.");
        System.out.println("A - Add item to cart");
        System.out.println("B - Go back to the previous menu");
        System.out.print("Enter your option here: ");
    }

    private void displayCatalog() {
        System.out.println("Identifier\tName\tUnit Price\tRemaining Quantity");
        List<CatalogItem> items = catalog.getCatalogItems();
        items.forEach(i -> System.out.println(i.getIdentifier() + "\t" + i.getName() + "\t" + i.getUnitPrice() + "\t" + i.getRemainingQuantity()));
    }

    @Override
    public void process(String command) {
        MenuOptions selectedOption = MenuOptions.get(command.toUpperCase());
        MenuDisplay menuDisplay = null;

        switch (selectedOption) {
            case OPTION_A:
                menuDisplay = new AddCartItemMenuDisplay(shop);
                break;
            default:
                break;
        }

        if (Objects.nonNull(menuDisplay))
            menuDisplay.display();
    }
}
