package food.utility;

public class OrderValidator {

    public static boolean validateAmount(double amount) {
        return amount > 0;
    }

    public static boolean validateCustomerName(String customerName) {
        return customerName != null &&
               !customerName.trim().isEmpty();
    }

    public static boolean validateOrderId(int orderId) {
        return orderId > 0;
    }
}