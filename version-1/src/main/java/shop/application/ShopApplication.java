package shop.application;

import shop.Shop;
import shop.console.MainMenuDisplay;

public class ShopApplication {

    public static void main(String[] args) {
        Shop shop = new Shop();

        MainMenuDisplay mainMenuDisplay = new MainMenuDisplay(shop);
        mainMenuDisplay.display();
    }
}
