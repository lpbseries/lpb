package shop.console;

import shop.Shop;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class SearchCatalogMenuDisplay implements MenuDisplay {

    private static final String EXIT_MENU_KEY = "b";

    private Shop shop;

    private enum MenuOptions {
        OPTION_S("S"),
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

    public SearchCatalogMenuDisplay(Shop shop) {
        this.shop = shop;
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
        System.out.println("Select one of the following options.");
        System.out.println("S - Search for item");
        System.out.println("B - Go back to the previous menu");
        System.out.print("Enter your option here: ");
    }

    @Override
    public void process(String command) {
        MenuOptions selectedOption = MenuOptions.get(command.toUpperCase());
        MenuDisplay menuDisplay = null;

        switch (selectedOption) {
            case OPTION_S:
                menuDisplay = new SearchCatalogItemMenuDisplay(shop);
                break;
            default:
                break;
        }

        if (Objects.nonNull(menuDisplay))
            menuDisplay.display();
    }
}
