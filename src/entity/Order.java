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

    public void displayOrder() {
        System.out.println(
                "\nOrder: " +
                        "\n  orderId: " + orderId +
                        "\n  customerName: " + customerName +
                        "\n  items: " + items +
                        "\n  total: " + total +
                        "\n  orderStatus: " + orderStatus
        );
    }

}
