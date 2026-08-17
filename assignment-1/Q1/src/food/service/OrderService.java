package food.service;

import food.model.FoodOrder;
import food.utility.OrderUtility;
import food.utility.OrderValidator;

public class OrderService {

    public static void processOrder(FoodOrder order) {

        if (!OrderValidator.validateOrderId(order.getOrderId())) {
            System.out.println("Invalid Order ID");
            return;
        }

        if (!OrderValidator.validateCustomerName(
                order.getCustomerName())) {

            System.out.println("Invalid Customer Name");
            return;
        }

        if (!OrderValidator.validateAmount(order.getAmount())) {
            System.out.println("Invalid Amount");
            return;
        }

        OrderUtility.generateOrderSummary(order);
    }
}