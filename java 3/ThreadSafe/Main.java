package ThreadSafe;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class ShoppingCart {
    private final List<String> items = new CopyOnWriteArrayList<>();

    public void addItem(String item) {
        items.add(item);
    }

    public void removeItem(String item) {
        items.remove(item);
    }

    public List<String> getItems() {
        return items;
    }
}

class CustomerThread extends Thread {
    private final ShoppingCart cart;

    public CustomerThread(ShoppingCart cart) {
        this.cart = cart;
    }

    @Override
    public void run() {
        cart.addItem("Item 1");
        cart.addItem("Item 2");
        cart.removeItem("Item 1");
    }
}

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        CustomerThread[] customers = new CustomerThread[5]; // Creating 5 customer threads

        for (int i = 0; i < customers.length; i++) {
            customers[i] = new CustomerThread(cart);
            customers[i].start();
        }

        // Waiting for all customer threads to finish
        for (CustomerThread customer : customers) {
            try {
                customer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Displaying the final items in the shopping cart
        System.out.println("Items in the shopping cart:");
        for (String item : cart.getItems()) {
            System.out.println(item);
        }
    }
}
