package service;

import entity.*;

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

    public Order findOrderById(int id) {
        return orders.get(id);
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

    public boolean removeProductById(int id) {
        Product p = findProductById(id);
        if (p == null) {
            return false;
        }
        products.remove(p);
        productsById.remove(p.getId());
        return true;
    }

    public void displayAllProducts() {
        if (products.isEmpty()) {
            System.out.println("we don't have any products");
            return;
        }

        System.out.println("Products: ");
        int count = 1;
        for (Product p : products) {
            System.out.println(count++ + ". " + p);
        }
    }

    public void showAllCategories() {
        if (categories.isEmpty()) {
            System.out.println("We don't have any categories yet");
            return;
        }
        int count = 1;
        System.out.println("Categories: ");
        for (String c : categories) {
            System.out.println(count++ + ". " + c);
        }
    }

    public void displayProductsOrderedByPrice() {
        if (products.isEmpty()) {
            System.out.println("we don't have any products");
            return;
        }

        System.out.println("Products: ");
        int count = 1;

        List<Product> sortedProducts = new ArrayList<>(products);

        Collections.sort(sortedProducts);

        for (Product p : sortedProducts) {
            System.out.println(count++ + ". " + p);

        }
    }

    public boolean addOrder(Order o) {
        if (findOrderById(o.getOrderId()) != null) {
            return false;
        }
        orders.put(o.getOrderId(), o);
        return true;
    }

    public boolean addItemToOrder(Order o, Product p, int quantity) {
        if (o.getOrderStatus() != OrderStatus.PENDING) {
            System.out.println("This order is: " + o.getOrderStatus());
            return false;
        }
        p.setStockQuantity(p.getStockQuantity() - quantity);
        o.addItem(new CartItem(p, quantity));

        return true;
    }


}
