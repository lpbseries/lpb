package shop.data;

import shop.Book;
import shop.CatalogItem;
import shop.Electronics;

import java.util.ArrayList;
import java.util.List;

public class CatalogLoader {

    private List<CatalogItem> items;

    public CatalogLoader() {
        this.items = new ArrayList<>();
        loadItems();
    }

    public List<CatalogItem> getItems() {
        return items;
    }

    private void loadItems() {
        items.addAll(createBooks());
        items.addAll(createElectronics());
    }

    private List<CatalogItem> createBooks() {
        List<CatalogItem> books = new ArrayList<>();
        Book book1 = new Book("B-0001", "Little Mermaid", 10.50, 100);
        Book book2 = new Book("B-0002", "Earth is round", 40.50, 10);
        Book book3 = new Book("B-0003", "Batman", 12.50, 200);
        Book book4 = new Book("B-0004", "Making Soju", 9.50, 40);
        Book book5 = new Book("B-0005", "Finding Nemo", 8.50, 1);

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        return books;
    }

    private List<CatalogItem> createElectronics() {
        List<CatalogItem> electronics = new ArrayList<>();
        Electronics electronics1 = new Electronics("E-0001", "Calculator", 5.99, 34);
        Electronics electronics2 = new Electronics("E-0002", "Wired Earpiece", 25.99, 34);
        Electronics electronics3 = new Electronics("E-0003", "Headphones", 235.99, 34);
        Electronics electronics4 = new Electronics("E-0004", "Speakers", 45.99, 34);
        Electronics electronics5 = new Electronics("E-0005", "TV", 1299.99, 34);

        electronics.add(electronics1);
        electronics.add(electronics2);
        electronics.add(electronics3);
        electronics.add(electronics4);
        electronics.add(electronics5);

        return electronics;
    }
}
