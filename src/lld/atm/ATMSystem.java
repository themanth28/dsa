package lld.atm;

import java.util.*;
import java.time.*;

// Custom Exceptions
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) { super(message); }
}

class InvalidPINException extends Exception {
    public InvalidPINException(String message) { super(message); }
}

class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String message) { super(message); }
}

// Transaction Class
class Transaction {
    String transactionId;
    String type;
    double amount;
    LocalDateTime timestamp;

    public Transaction(String type, double amount) {
        this.transactionId = UUID.randomUUID().toString();
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "[" + timestamp + "] " + type + ": ₹" + amount + " (ID: " + transactionId + ")";
    }
}

// Account Class
class Account {
    String accountId;
    double balance;
    List<Transaction> transactions = new ArrayList<>();

    public Account() {
        this.accountId = UUID.randomUUID().toString();
        this.balance = 0;
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction("Deposit", amount));
        System.out.println("✅ Deposited ₹" + amount + " | Balance: ₹" + balance);
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (balance < amount) throw new InsufficientFundsException("Insufficient funds! Balance: ₹" + balance);
        balance -= amount;
        transactions.add(new Transaction("Withdraw", amount));
        System.out.println("✅ Withdrawn ₹" + amount + " | Balance: ₹" + balance);
    }

    public void showTransactions() {
        System.out.println("--- Transaction History for Account " + accountId + " ---");
        if (transactions.isEmpty()) System.out.println("No transactions yet.");
        for (Transaction t : transactions) System.out.println(t);
        System.out.println("Current Balance: ₹" + balance);
    }

    public double getBalance() { return balance; }
}

// Card Class
class Card {
    String cardNumber;
    String pin;
    Account linkedAccount;

    public Card(Account account, String pin) {
        this.cardNumber = UUID.randomUUID().toString();
        this.pin = pin;
        this.linkedAccount = account;
    }

    public void validatePIN(String inputPin) throws InvalidPINException {
        if (!pin.equals(inputPin)) throw new InvalidPINException("Invalid PIN entered!");
    }
}

// ATM System Class
public class ATMSystem {
    Map<String, Card> cards = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    public Card createCard(Account account, String pin) {
        Card card = new Card(account, pin);
        cards.put(card.cardNumber, card);
        System.out.println("✅ Card created! Card Number: " + card.cardNumber);
        return card;
    }

    public void run() {
        while (true) {
            try {
                System.out.println("\n--- ATM System ---");
                System.out.println("1. Deposit\n2. Withdraw\n3. Check Balance\n4. Show Transactions\n5. Exit");
                System.out.print("Choose option: ");
                int choice = sc.nextInt();
                sc.nextLine(); // consume newline

                System.out.print("Enter Card Number: ");
                String cardNumber = sc.nextLine();
                Card card = cards.get(cardNumber);
                if (card == null) throw new AccountNotFoundException("Card not found!");

                System.out.print("Enter PIN: ");
                String pin = sc.nextLine();
                card.validatePIN(pin);

                Account acc = card.linkedAccount;

                switch (choice) {
                    case 1:
                        System.out.print("Enter amount to deposit: ");
                        double dep = sc.nextDouble();
                        sc.nextLine();
                        acc.deposit(dep);
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double wth = sc.nextDouble();
                        sc.nextLine();
                        acc.withdraw(wth);
                        break;
                    case 3:
                        System.out.println("Current Balance: ₹" + acc.getBalance());
                        break;
                    case 4:
                        acc.showTransactions();
                        break;
                    case 5:
                        System.out.println("👋 Exiting ATM System.");
                        return;
                    default:
                        System.out.println("⚠️ Invalid choice!");
                }
            } catch (InvalidPINException | InsufficientFundsException | AccountNotFoundException e) {
                System.out.println("❌ Error: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("⚠️ Invalid input! Please enter numbers where required.");
                sc.nextLine(); // clear invalid input
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        ATMSystem atm = new ATMSystem();

        // Sample setup
        Account acc1 = new Account();
        atm.createCard(acc1, "1234"); // Card with PIN 1234
        Account acc2 = new Account();
        atm.createCard(acc2, "5678"); // Card with PIN 5678

        atm.run();
    }
}
