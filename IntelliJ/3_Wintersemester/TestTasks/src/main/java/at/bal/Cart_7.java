package at.bal;

class Item {
    String name;
    int quantity;

    Item(String n) {
        name = n;
        quantity = 1;
    }
}

public class Cart_7 {
    public static void main(String[] args) {

        Item[] cart = new Item[5];
        int size = 0;

        size = add(cart, size, "Milch");
        size = add(cart, size, "Milch");
    }

    static int add(Item[] cart, int size, String name) {
        for (int i = 0; i < size; i++) {
            if (cart[i].name.equals(name)) {
                cart[i].quantity++;
                return size;
            }
        }
        cart[size] = new Item(name);
        return size + 1;
    }
}

