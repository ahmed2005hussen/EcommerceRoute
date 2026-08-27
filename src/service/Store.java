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

    public void showAllCategories(){
        if(categories.isEmpty()){
            System.out.println("We don't have any categories yet");
            return;
        }
        int count = 1;
        System.out.println("Categories: ");
        for (String c : categories){
            System.out.println(count++ + ". " + c);
        }
    }
}
