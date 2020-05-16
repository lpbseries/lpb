package shop.console;

import shop.Shop;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class MainMenuDisplay implements MenuDisplay {

    private static final String EXIT_MENU_KEY = "q";

    private Shop shop;

    private enum MenuOptions {
        OPTION_1("1"),
        OPTION_2("2"),
        OPTION_3("3"),
        OPTION_4("4"),
        OPTION_Q("Q");

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

    public MainMenuDisplay(Shop shop) {
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
        System.out.println("1 - Display catalog items");
        System.out.println("2 - Display cart items");
        System.out.println("3 - Search catalog items");
        System.out.println("4 - Check out");
        System.out.println("Q - Quit");
        System.out.print("Enter your option here: ");
    }

    @Override
    public void process(String command) {
        MenuOptions selectedOption = MenuOptions.get(command.toUpperCase());
        MenuDisplay menuDisplay = null;

        switch (selectedOption) {
            case OPTION_1:
                menuDisplay = new CatalogMenuDisplay(shop);
                break;
            case OPTION_2:
                menuDisplay = new CartMenuDisplay(shop);
                break;
            case OPTION_3:
                menuDisplay = new SearchCatalogMenuDisplay(shop);
                break;
            case OPTION_4:
                menuDisplay = new CheckoutMenuDisplay(shop);
                break;
            default:
                break;
        }

        if (Objects.nonNull(menuDisplay))
            menuDisplay.display();
    }
}
