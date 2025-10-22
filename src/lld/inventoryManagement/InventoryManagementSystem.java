package lld.inventoryManagement;

import java.util.*;

// Custom Exceptions
class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String message) { super(message); }
}

class InsufficientStockException extends Exception {
    public InsufficientStockException(String message) { super(message); }
}

// ----------------- Product Class -----------------
class Product {
    String productId;
    String name;
    Supplier supplier;

    public Product(String name, Supplier supplier) {
        this.productId = UUID.randomUUID().toString();
        this.name = name;
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return name + " (ID: " + productId + ") | Supplier: " + supplier.name;
    }
}

// ----------------- Supplier Class -----------------
class Supplier {
    String supplierId;
    String name;

    public Supplier(String name) {
        this.supplierId = UUID.randomUUID().toString();
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " (ID: " + supplierId + ")";
    }
}

// ----------------- Stock Class -----------------
class Stock {
    Product product;
    int quantity;

    public Stock(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public void addStock(int qty) {
        quantity += qty;
        System.out.println("✅ Added " + qty + " units. New quantity: " + quantity);
    }

    public void reduceStock(int qty) throws InsufficientStockException {
        if (quantity < qty) throw new InsufficientStockException("Insufficient stock! Available: " + quantity);
        quantity -= qty;
        System.out.println("✅ Reduced " + qty + " units. Remaining quantity: " + quantity);
    }

    @Override
    public String toString() {
        return product + " | Quantity: " + quantity;
    }
}

// ----------------- Inventory System -----------------
public class InventoryManagementSystem {
    Map<String, Product> products = new HashMap<>();
    Map<String, Stock> stocks = new HashMap<>();
    Map<String, Supplier> suppliers = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    public Supplier addSupplier(String name) {
        Supplier s = new Supplier(name);
        suppliers.put(s.supplierId, s);
        System.out.println("✅ Supplier added: " + s);
        return s;
    }

    public Product addProduct(String name, Supplier supplier, int initialQty) {
        Product p = new Product(name, supplier);
        products.put(p.productId, p);
        stocks.put(p.productId, new Stock(p, initialQty));
        System.out.println("✅ Product added: " + p + " | Initial Qty: " + initialQty);
        return p;
    }

    public void addStock(String productId, int qty) throws ProductNotFoundException {
        if (!stocks.containsKey(productId)) throw new ProductNotFoundException("Product not found!");
        stocks.get(productId).addStock(qty);
    }

    public void reduceStock(String productId, int qty) throws ProductNotFoundException, InsufficientStockException {
        if (!stocks.containsKey(productId)) throw new ProductNotFoundException("Product not found!");
        stocks.get(productId).reduceStock(qty);
    }

    public void showStock(String productId) throws ProductNotFoundException {
        if (!stocks.containsKey(productId)) throw new ProductNotFoundException("Product not found!");
        System.out.println(stocks.get(productId));
    }

    public void run() {
        while (true) {
            try {
                System.out.println("\n--- Inventory Management ---");
                System.out.println("1. Add Supplier\n2. Add Product\n3. Add Stock\n4. Reduce Stock\n5. Show Stock\n6. Exit");
                System.out.print("Choose option: ");
                int choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter supplier name: ");
                        String sName = sc.nextLine();
                        addSupplier(sName);
                        break;
                    case 2:
                        System.out.print("Enter product name: ");
                        String pName = sc.nextLine();
                        System.out.print("Enter supplier ID: ");
                        String supId = sc.nextLine();
                        Supplier sup = suppliers.get(supId);
                        if (sup == null) { System.out.println("❌ Supplier not found!"); break; }
                        System.out.print("Enter initial quantity: ");
                        int qty = sc.nextInt();
                        sc.nextLine();
                        addProduct(pName, sup, qty);
                        break;
                    case 3:
                        System.out.print("Enter product ID: ");
                        String pidAdd = sc.nextLine();
                        System.out.print("Enter quantity to add: ");
                        int addQty = sc.nextInt();
                        sc.nextLine();
                        addStock(pidAdd, addQty);
                        break;
                    case 4:
                        System.out.print("Enter product ID: ");
                        String pidRed = sc.nextLine();
                        System.out.print("Enter quantity to reduce: ");
                        int redQty = sc.nextInt();
                        sc.nextLine();
                        reduceStock(pidRed, redQty);
                        break;
                    case 5:
                        System.out.print("Enter product ID: ");
                        String pidShow = sc.nextLine();
                        showStock(pidShow);
                        break;
                    case 6:
                        System.out.println("👋 Exiting Inventory System.");
                        return;
                    default:
                        System.out.println("⚠️ Invalid choice!");
                }
            } catch (ProductNotFoundException | InsufficientStockException e) {
                System.out.println("❌ Error: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("⚠️ Invalid input! Please enter numbers where required.");
                sc.nextLine(); // clear input
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();
        ims.run();
    }
}
