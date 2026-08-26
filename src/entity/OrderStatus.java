package entity;

public enum OrderStatus {

    PENDING,
    SHIPPED,
    DELIVERED,
    CANCELLED


    //An order normally starts as Pending.
    //When it is added to the shipping list, it becomes Shipped.
    //When it is marked as delivered, it becomes Delivered.
    //If the order is cancelled, it becomes Cancelled.



}
