package file;

import model.Product;
import model.Order;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVUtil {

    public static List<Product> readProductsFromCSV(String filename) {
        List<Product> products = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                products.add(new Product(values[0], Double.parseDouble(values[1]), Integer.parseInt(values[2])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

    public static List<Order> readOrdersFromCSV(String filename) {
        List<Order> orders = new ArrayList<>();

        return orders;
    }

    public static void writeProductToCSV(List<Product> products, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Product product : products) {
                writer.write(product.getName() + "," + product.getPrice() + "," + product.getQuantity());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
