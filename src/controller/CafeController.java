package controller;

import model.*;
import strategy.DiscountStrategy;
import strategy.PercentageDiscountStrategy;
import singleton.DatabaseManager;
import Factory.ProductFactory;
import file.CSVUtil;

import java.util.List;

public class CafeController {
    private List<Product> products;
    private List<Order> orders;

    public CafeController(List<Product> products, List<Order> orders) {
        this.products = products;
        this.orders = orders;
    }

    // Thêm sản phẩm
    public void addProduct(String name, double price, int quantity) {
        Product product = ProductFactory.createProduct(name, price, quantity);
        products.add(product);
    }

    // Xóa sản phẩm
    public void removeProduct(String productName) {
        products.removeIf(product -> product.getName().equalsIgnoreCase(productName));
    }

    // Tạo đơn hàng
    public void createOrder(Order order) {
        orders.add(order);
    }

    //  giảm giá
    public void applyDiscountToOrder(int orderId, Discount discount, DiscountStrategy strategy) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                strategy.applyDiscount(order, discount);
            }
        }
    }

    // Thanh toán đơn hàng
    public void payOrder(int orderId) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                order.markAsPaid();
            }
        }
    }

    // Kết nối cơ sở dữ liệu
    public void connectToDatabase() {
        DatabaseManager dbManager = DatabaseManager.getInstance();
        dbManager.connect();
    }

    // Ngắt kết nối cơ sở dữ liệu
    public void disconnectDatabase() {
        DatabaseManager dbManager = DatabaseManager.getInstance();
        dbManager.disconnect();
    }
}
