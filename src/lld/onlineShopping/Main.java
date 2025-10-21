package lld.onlineShopping;

import java.util.*;
import java.security.MessageDigest;

// ---------- User Management ----------
abstract class User {
    String userId;
    String name;
    String passwordHash;
    String role; // "BUYER" or "SELLER"

    public User(String userId, String name, String password, String role) {
        this.userId = userId;
        this.name = name;
        this.passwordHash = encryptPassword(password);
        this.role = role;
    }

    private String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) sb.append(String.format("%02x", b));
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException("Encryption error");
        }
    }

    public boolean validatePassword(String password) {
        return passwordHash.equals(encryptPassword(password));
    }
}

class Buyer extends User {
    Cart cart = new Cart();

    public Buyer(String userId, String name, String password) {
        super(userId, name, password, "BUYER");
    }
}

class Seller extends User {
    public Seller(String userId, String name, String password) {
        super(userId, name, password, "SELLER");
    }
}

// ---------- Product & Inventory ----------
class Product {
    String productId;
    String name;
    double price;
    int quantity;
    String sellerId;

    public Product(String productId, String name, double price, int quantity, String sellerId) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.sellerId = sellerId;
    }
}

class InventoryService {
    Map<String, Product> products = new HashMap<>();

    public void addItem(Product product) {
        products.put(product.productId, product);
        System.out.println("✅ Product added: " + product.name);
    }

    public void updateItem(String productId, int newQty, double newPrice) {
        Product p = products.get(productId);
        if (p != null) {
            p.quantity = newQty;
            p.price = newPrice;
            System.out.println("🔁 Product updated: " + p.name);
        } else {
            System.out.println("❌ Product not found.");
        }
    }

    public void listInventory() {
        System.out.println("\n=== Inventory List ===");
        for (Product p : products.values()) {
            System.out.println(p.productId + " | " + p.name + " | Price: ₹" + p.price + " | Qty: " + p.quantity);
        }
    }
}

// ---------- Cart, Order & Payment ----------
class Cart {
    Map<String, Integer> items = new HashMap<>(); // productId -> quantity

    public void addToCart(String productId, int qty) {
        items.put(productId, items.getOrDefault(productId, 0) + qty);
        System.out.println("🛒 Added " + qty + "x of " + productId + " to cart");
    }

    public Map<String, Integer> getItems() {
        return items;
    }

    public void clear() {
        items.clear();
    }
}

class Order {
    String orderId;
    String buyerId;
    Map<String, Integer> products;
    double totalAmount;
    boolean isPaid;

    public Order(String orderId, String buyerId, Map<String, Integer> products, double totalAmount) {
        this.orderId = orderId;
        this.buyerId = buyerId;
        this.products = new HashMap<>(products);
        this.totalAmount = totalAmount;
        this.isPaid = false;
    }
}

class PaymentService {
    public boolean makePayment(Order order) {
        System.out.println("💳 Processing payment of ₹" + order.totalAmount + " for Order " + order.orderId);
        order.isPaid = true;
        System.out.println("✅ Payment successful!");
        return true;
    }
}

// ---------- Profile & Order Services ----------
class ProfileService {
    Map<String, User> users = new HashMap<>();

    public void registerUser(User user) {
        users.put(user.userId, user);
        System.out.println("👤 " + user.role + " registered: " + user.name);
    }

    public User login(String userId, String password) {
        User user = users.get(userId);
        if (user != null && user.validatePassword(password)) {
            System.out.println("🔓 Login successful for " + user.name);
            return user;
        } else {
            System.out.println("❌ Invalid credentials.");
            return null;
        }
    }
}

class OrderService {
    InventoryService inventory;
    PaymentService payment;
    Map<String, Order> orderHistory = new HashMap<>();

    public OrderService(InventoryService inventory, PaymentService payment) {
        this.inventory = inventory;
        this.payment = payment;
    }

    public void buyItem(Buyer buyer) {
        double total = 0;
        for (Map.Entry<String, Integer> entry : buyer.cart.getItems().entrySet()) {
            String pid = entry.getKey();
            int qty = entry.getValue();

            Product p = inventory.products.get(pid);
            if (p == null || p.quantity < qty) {
                System.out.println("❌ Product " + pid + " out of stock or insufficient quantity!");
                return;
            }
            total += p.price * qty;
        }

        String orderId = "ORD" + System.currentTimeMillis();
        Order order = new Order(orderId, buyer.userId, buyer.cart.getItems(), total);
        orderHistory.put(orderId, order);

        if (payment.makePayment(order)) {
            for (Map.Entry<String, Integer> entry : buyer.cart.getItems().entrySet()) {
                Product p = inventory.products.get(entry.getKey());
                p.quantity -= entry.getValue();
            }
            buyer.cart.clear();
            System.out.println("📦 Order placed successfully! Order ID: " + orderId);
        }
    }
}

// ---------- Main ----------
public class Main {
    public static void main(String[] args) {
        ProfileService profile = new ProfileService();
        InventoryService inventory = new InventoryService();
        PaymentService payment = new PaymentService();
        OrderService orderService = new OrderService(inventory, payment);

        // Register Users
        Seller seller = new Seller("S1", "Arun", "seller123");
        Buyer buyer = new Buyer("B1", "Hemanth", "buyer123");
        profile.registerUser(seller);
        profile.registerUser(buyer);

        // Seller Login & Add Products
        profile.login("S1", "seller123");
        inventory.addItem(new Product("P1", "Laptop", 60000, 5, seller.userId));
        inventory.addItem(new Product("P2", "Mouse", 500, 10, seller.userId));
        inventory.listInventory();

        // Buyer Login & Place Order
        profile.login("B1", "buyer123");
        buyer.cart.addToCart("P1", 1);
        buyer.cart.addToCart("P2", 2);

        orderService.buyItem(buyer);

        // Updated Inventory
        inventory.listInventory();
    }
}
