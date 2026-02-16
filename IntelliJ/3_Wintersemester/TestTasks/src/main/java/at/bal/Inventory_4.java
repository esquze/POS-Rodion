package at.bal;

class Product {
    String name;
    int stock;
    double price;

    Product(String n, int s, double p) {
        name = n;
        stock = s;
        price = p;
    }
}

public class Inventory_4 {
    public static void main(String[] args) {

        Product[] products = {
                new Product("Apfel", 3, 1.2),
                new Product("Birne", 10, 1.5)
        };

        for (int i = 0; i < products.length; i++) {
            if (products[i].stock < 5) {
                System.out.println(products[i].name);
            }
        }
    }
}
