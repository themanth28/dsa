package lld.paymentMethods;

import java.util.*;

// ----------------- Strategy Interface -----------------
interface PaymentStrategy {
    void pay(double amount) throws PaymentFailedException;
}

// ----------------- Concrete Strategies -----------------
class UPIPayment implements PaymentStrategy {
    private String upiId;

    public UPIPayment(String upiId) { this.upiId = upiId; }

    @Override
    public void pay(double amount) throws PaymentFailedException {
        if (upiId == null || upiId.isEmpty()) throw new PaymentFailedException("Invalid UPI ID");
        System.out.println("✅ Paid ₹" + amount + " using UPI: " + upiId);
    }
}

class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolder;

    public CreditCardPayment(String cardNumber, String cardHolder) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }

    @Override
    public void pay(double amount) throws PaymentFailedException {
        if (cardNumber == null || cardNumber.length() != 16)
            throw new PaymentFailedException("Invalid Credit Card Number");
        System.out.println("✅ Paid ₹" + amount + " using Credit Card: " + cardNumber + " | Holder: " + cardHolder);
    }
}

class WalletPayment implements PaymentStrategy {
    private String walletId;
    private double balance;

    public WalletPayment(String walletId, double balance) {
        this.walletId = walletId;
        this.balance = balance;
    }

    @Override
    public void pay(double amount) throws PaymentFailedException {
        if (balance < amount) throw new PaymentFailedException("Insufficient wallet balance!");
        balance -= amount;
        System.out.println("✅ Paid ₹" + amount + " using Wallet: " + walletId + " | Remaining balance: ₹" + balance);
    }
}

// ----------------- Context Class -----------------
class PaymentContext {
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) { this.strategy = strategy; }

    public void payAmount(double amount) {
        try {
            strategy.pay(amount);
        } catch (PaymentFailedException e) {
            System.out.println("❌ Payment failed: " + e.getMessage());
        }
    }
}

// ----------------- Custom Exception -----------------
class PaymentFailedException extends Exception {
    public PaymentFailedException(String message) { super(message); }
}

// ----------------- Demo -----------------
public class PaymentStrategyDemo {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Pay using UPI
        context.setPaymentStrategy(new UPIPayment("user@upi"));
        context.payAmount(500);

        // Pay using Credit Card
        context.setPaymentStrategy(new CreditCardPayment("1234567812345678", "John Doe"));
        context.payAmount(1200);

        // Pay using Wallet
        context.setPaymentStrategy(new WalletPayment("wallet123", 800));
        context.payAmount(700);

        // Attempt to pay more than wallet balance
        context.setPaymentStrategy(new WalletPayment("wallet123", 50));
        context.payAmount(100);
    }
}
