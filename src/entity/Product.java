package entity;

public class Product implements Comparable<Product>{

    private int id;
    private String name;
    private Double price ;
    private String category;
    private int stockQuantity;

    public Product(int id, String name, double price, String category, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.stockQuantity = stockQuantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    @Override
    public String toString() {
        return "\nProduct:" +
                "\n    id: " + id +
                "\n    name: " + name +
                "\n    price: " + price +
                "\n    category: " + category +
                "\n    stockQuantity: " + stockQuantity;
    }


    @Override
    public int compareTo(Product o) {
        return Double.compare(this.price, o.price);
    }
}
