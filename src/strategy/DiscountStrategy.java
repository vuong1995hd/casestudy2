package strategy;

import model.Order;
import model.Discount;

public interface DiscountStrategy {
    void applyDiscount(Order order, Discount discount);
}
