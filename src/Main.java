import entity.Product;
import service.Store;

import java.util.Scanner;

class Main {
    Scanner sc = new Scanner(System.in);
    Store store = new Store();

    int menu() {
        System.out.println(
                "1. Add Product\n" +
                        "2. Remove Product\n" +
                        "3. Display All Products\n" +
                        "4. Search Product by ID\n" +
                        "5. Show All Categories\n" +
                        "6. Display Products Ordered by Price\n" +
                        "7. Create Order\n" +
                        "8. Add Item to Order\n" +
                        "9. Remove Item from Order\n" +
                        "10. Display Order\n" +
                        "11. Add Order to the Shipping List\n" +
                        "12. Ship Next Order\n" +
                        "13. Cancel Order\n" +
                        "14. Search Order by ID\n" +
                        "15. Add Review to a Product\n" +
                        "16. Show All Reviews for a Product\n" +
                        "17. Remove Out-of-Stock Products\n" +
                        "18. Display Orders Ordered by Total\n" +
                        "19. Exit\n"
        );

        return sc.nextInt();
    }

    boolean checkPositive(double number) {
        if (number <= 0) return false;

        return true;
    }

    public void addProduct() {

        System.out.print("Enter product Id: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter product name: ");
        String name = sc.nextLine();

        System.out.print("Enter product price: ");
        double price = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter category: ");
        String category = sc.nextLine();

        System.out.print("Enter stock quantity: ");
        int stockQuantity = sc.nextInt();
        sc.nextLine();

        if (!checkPositive(id) || !checkPositive(stockQuantity) || !checkPositive(price)) {
            System.out.println("Invalid values id, stock quantity and price must be greater than 0");
            System.out.println("----------------------------");

            return;
        }

        if (store.addProduct(new Product(id, name, price, category, stockQuantity))) {
            System.out.println("Created");
        } else {
            System.out.println("Used id, try with another id");
        }
        System.out.println("----------------------------");
    }

    void main(String[] args) {

        System.out.println("Welcome in the store");
        System.out.println("--------------------");

        loop:
        while (true) {
            int choice = menu();

            switch (choice) {
                case 1 -> addProduct();
            }
        }


    }

}