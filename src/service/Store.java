package service;

import entity.Order;
import entity.Product;
import entity.Review;

import java.util.*;

public class Store {

    private List<Product> products;
    private List<Order> deliveredOrders;
    private List<Review> reviews;

    private Map<Integer, Product> productsById;
    private Map<Integer, Order> orders;
    private Set<String> categories;

    private Queue<Order> ordersToBeShipped;

    public Store() {
        products = new ArrayList<>();
        deliveredOrders = new ArrayList<>();
        reviews = new ArrayList<>();

        productsById = new HashMap<>();
        orders = new HashMap<>();
        categories = new HashSet<>();

        ordersToBeShipped = new ArrayDeque<>();
    }

    public Product findProductById(int id) {
        return productsById.get(id);
    }

    public boolean addProduct(Product p) {
        if (findProductById(p.getId()) != null) {
            return false;
        }
        products.add(p);
        productsById.put(p.getId(), p);
        categories.add(p.getCategory());

        return true;
    }

}
