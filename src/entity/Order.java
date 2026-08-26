package entity;

import java.util.ArrayList;
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
}
