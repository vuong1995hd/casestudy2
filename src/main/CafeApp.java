package main;

import model.*;
import controller.CafeController;
import strategy.PercentageDiscountStrategy;
import file.CSVUtil;

import java.util.*;

public class CafeApp {
    public static void main(String[] args) {

        List<Product> products = CSVUtil.readProductsFromCSV("products.csv");
        List<Order> orders = new ArrayList<>();
        CafeController controller = new CafeController(products, orders);

        // Thêm sản phẩm mới
        controller.addProduct("Cà phê sữa", 25.0, 10);

        // Tạo đơn hàng và áp dụng giảm giá
        List<Product> orderProducts = Arrays.asList(products.get(0));
        Order order = new Order(1, new Customer("hoàng vệt vương", "0123456789"), orderProducts);
        controller.createOrder(order);

        // Áp dụng giảm giá
        Discount discount = new Discount("Giamgia2024", 10);
        controller.applyDiscountToOrder(1, discount, new PercentageDiscountStrategy());

        // Thanh toán đơn hàng
        controller.payOrder(1);

        // Lưu lại sản phẩm vào CSV
        CSVUtil.writeProductToCSV(products, "products.csv");

        System.out.println("Ứng dụng cafe đã hoạt động thành công!");
    }
}
