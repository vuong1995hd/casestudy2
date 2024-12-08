package strategy;

import model.Order;
import model.Discount;

public class PercentageDiscountStrategy implements DiscountStrategy {
    @Override
    public void applyDiscount(Order order, Discount discount) {
        double totalAmount = order.getTotalAmount();
        double discountAmount = totalAmount * (discount.getPercentage() / 100);
        order.setTotalAmount(totalAmount - discountAmount);
        System.out.println("Giảm giá " + discount.getPercentage() + "% đã được áp dụng.");
    }
}
