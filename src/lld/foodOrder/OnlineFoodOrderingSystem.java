package lld.foodOrder;

import java.util.*;
import java.time.*;

// Custom Exceptions
class InvalidSelectionException extends Exception {
    public InvalidSelectionException(String message) { super(message); }
}

class PaymentFailedException extends Exception {
    public PaymentFailedException(String message) { super(message); }
}

// Item Class
class Item {
    String name;
    double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

// Restaurant Class
class Restaurant {
    String name;
    Map<Integer, Item> menu = new HashMap<>();

    public Restaurant(String name) {
        this.name = name;
    }

    public void addItem(int code, Item item) {
        menu.put(code, item);
    }

    public void showMenu() {
        System.out.println("--- Menu for " + name + " ---");
        for (Map.Entry<Integer, Item> e : menu.entrySet()) {
            System.out.println(e.getKey() + ". " + e.getValue().name + " - ₹" + e.getValue().price);
        }
    }

    public Item getItem(int code) throws InvalidSelectionException {
        if (!menu.containsKey(code)) throw new InvalidSelectionException("Invalid item selection!");
        return menu.get(code);
    }
}

// Order Class
class Order {
    Map<Item, Integer> items = new HashMap<>();
    LocalDateTime timestamp;

    public void addItem(Item item, int quantity) {
        items.put(item, items.getOrDefault(item, 0) + quantity);
    }

    public double calculateTotal() {
        double total = 0;
        for (Map.Entry<Item, Integer> e : items.entrySet()) {
            total += e.getKey().price * e.getValue();
        }
        return total;
    }

    public void showOrder() {
        System.out.println("--- Order Details ---");
        for (Map.Entry<Item, Integer> e : items.entrySet()) {
            System.out.println(e.getKey().name + " x" + e.getValue() + " = ₹" + (e.getKey().price * e.getValue()));
        }
        System.out.println("Total: ₹" + calculateTotal());
    }
}

// Payment Class
class Payment {
    public void pay(double amount, double paid) throws PaymentFailedException {
        if (paid < amount) throw new PaymentFailedException("Insufficient payment! Required: ₹" + amount);
        System.out.println("✅ Payment successful. Change returned: ₹" + (paid - amount));
    }
}

// User Class
class User {
    String name;

    public User(String name) { this.name = name; }

    public void placeOrder(Restaurant restaurant, Scanner sc) {
        Order order = new Order();
        while (true) {
            restaurant.showMenu();
            System.out.print("Enter item code (0 to finish): ");
            int code = sc.nextInt();
            if (code == 0) break;
            try {
                Item item = restaurant.getItem(code);
                System.out.print("Enter quantity: ");
                int qty = sc.nextInt();
                order.addItem(item, qty);
            } catch (InvalidSelectionException e) {
                System.out.println("❌ " + e.getMessage());
            }
        }

        order.showOrder();

        Payment payment = new Payment();
        System.out.print("Enter payment amount: ");
        double paid = sc.nextDouble();
        try {
            payment.pay(order.calculateTotal(), paid);
        } catch (PaymentFailedException e) {
            System.out.println("❌ " + e.getMessage());
        }
    }
}

// Demo / Main Class
public class OnlineFoodOrderingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Setup Restaurants
        Restaurant r1 = new Restaurant("Burger King");
        r1.addItem(1, new Item("Burger", 120));
        r1.addItem(2, new Item("Fries", 50));
        r1.addItem(3, new Item("Coke", 30));

        Restaurant r2 = new Restaurant("Pizza Hut");
        r2.addItem(1, new Item("Pizza", 250));
        r2.addItem(2, new Item("Garlic Bread", 80));
        r2.addItem(3, new Item("Pepsi", 30));

        Map<Integer, Restaurant> restaurants = new HashMap<>();
        restaurants.put(1, r1);
        restaurants.put(2, r2);

        System.out.print("Enter your name: ");
        User user = new User(sc.nextLine());

        while (true) {
            System.out.println("\n--- Restaurants ---");
            for (Map.Entry<Integer, Restaurant> e : restaurants.entrySet()) {
                System.out.println(e.getKey() + ". " + e.getValue().name);
            }
            System.out.println("0. Exit");
            System.out.print("Choose a restaurant: ");
            int choice = sc.nextInt();
            if (choice == 0) {
                System.out.println("👋 Thank you for ordering, " + user.name + "!");
                break;
            }
            if (!restaurants.containsKey(choice)) {
                System.out.println("⚠️ Invalid restaurant selection!");
                continue;
            }
            Restaurant selected = restaurants.get(choice);
            user.placeOrder(selected, sc);
        }
    }
}
