import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Product {
    String name;
    int hm;
    double price;

    public Product(String name, int hm, double price) {
        this.name = name;
        this.hm = hm;
        this.price = price;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Milk", 2, 1.5));
        products.add(new Product("Eggs", 10, 0.2));
        products.add(new Product("pekls", 5, 0.8));
        products.add(new Product("Bread", 1, 1.0));
        products.add(new Product("Chise", 3, 2.5));
        products.add(new Product("appale", 6, 1.2));
        products.add(new Product("Chiken", 2, 5.0));

        int filterHM = 5;

        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.hm > filterHM) {
                filteredProducts.add(product);
            }
        }
        System.out.println("Filtered products: ");
        printProducts(filteredProducts);

        int totalHM = 0;
        for (Product product : products) {
            totalHM += product.hm;
        }
        System.out.println("Products in icebox: " + totalHM);

        double totalSum = 0;
        for (Product product : products) {
            totalSum += product.price;
        }
        double sSum = totalSum / products.size();
        System.out.println("Average price: " + sSum);

        Collections.sort(products, (p1, p2) -> Double.compare(p2.price, p1.price));
        System.out.println("Prices in descending order: ");
        printProducts(products);

        double totalCost = 0;
        for (Product product : products) {
            totalCost += product.price * product.hm;
        }
        System.out.println("Total cost of all products: " + totalCost);
    }

    private static void printProducts(List<Product> products) {
        for (Product product : products) {
            System.out.println(product.name + " | How much: " + product.hm + " | Price: " + product.price);
        }
    }
}