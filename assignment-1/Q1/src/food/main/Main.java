package food.main;

import food.model.FoodOrder;
import food.model.RegularOrder;
import food.model.PremiumOrder;
import food.service.OrderService;

public class Main {

    public static void main(String[] args) {

        FoodOrder[] orders = new FoodOrder[6];

        orders[0] = new RegularOrder(
                101, "Rahul", 500);

        orders[1] = new PremiumOrder(
                102, "Aman", 1200);

        orders[2] = new RegularOrder(
                103, "Priya", 800);

        orders[3] = new PremiumOrder(
                104, "Neha", 1500);

        orders[4] = new RegularOrder(
                105, "Rohit", 1000);

        orders[5] = new PremiumOrder(
                106, "Simran", 2000);

        System.out.println("====================================");
        System.out.println("       " + FoodOrder.getRestaurantName());
        System.out.println("       ONLINE FOOD DELIVERY");
        System.out.println("====================================");

        for (FoodOrder order : orders) {
            OrderService.processOrder(order);
        }

        FoodOrder.displayTotalOrders();
    }
}