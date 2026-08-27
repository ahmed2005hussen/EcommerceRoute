package entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Order {
    private int orderId;
    private String customerName;
    private List<CartItem> items;
    private double total;
    private OrderStatus orderStatus;

    public Order(int orderId, String customerName, OrderStatus orderStatus) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderStatus = orderStatus;
        this.items = new ArrayList<>();
        this.total = 0.0;
    }

    public void addItem(CartItem newItem) {

        for (CartItem item : items) {

            if (item.getProduct().getId() == newItem.getProduct().getId()) {
                item.setQuantity(item.getQuantity() + newItem.getQuantity());
                calculateTotal();
                return;
            }
        }

        items.add(newItem);
        calculateTotal();
    }

    public boolean removeItem(CartItem item) {
        if (items.isEmpty()) return false;

        boolean isRemoved = items.remove(item);
        if (isRemoved) {
            calculateTotal();
        }

        return isRemoved;
    }

    private void calculateTotal() {
        total = 0;

        for (CartItem item : items) {
            total += item.calculateSubtotal();
        }
    }

    public int getOrderId() {
        return orderId;
    }

    public double getTotal() {
        return total;
    }

    public void updateStatus(OrderStatus status) {
        this.orderStatus = status;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public CartItem findItemByProductId(int productId) {
        for (CartItem item : items) {
            if (item.getProduct().getId() == productId) {
                return item;
            }
        }

        return null;
    }


    public void displayOrder() {
        System.out.println("\nOrder ID: " + orderId);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Status: " + orderStatus);

        System.out.println("Items:");

        if (items.isEmpty()) {
            System.out.println("  No items.");
        } else {
            for (CartItem item : items) {
                System.out.println(
                        "  Product: " + item.getProduct().getName() +
                                " | Quantity: " + item.getQuantity() +
                                " | Subtotal: " + item.calculateSubtotal()
                );
            }
        }

        System.out.println("Final Total: " + total);
    }

    public boolean hasItems() {
        return !items.isEmpty();
    }

}
