package Factory;

import model.Product;

public class ProductFactory {
    public static Product createProduct(String name, double price, int quantity) {
        return new Product(name, price, quantity);
    }
}
