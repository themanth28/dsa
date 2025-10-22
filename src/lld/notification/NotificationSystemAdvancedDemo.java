package lld.notification;

import java.util.*;

// ----------------- OBSERVER INTERFACE -----------------
interface Observer {
    void update(String eventType, String message);
}

// ----------------- CONCRETE OBSERVERS -----------------
class EmailNotifier implements Observer {
    private String email;

    public EmailNotifier(String email) { this.email = email; }

    @Override
    public void update(String eventType, String message) {
        System.out.println("📧 Email to " + email + " | Event: " + eventType + " | Message: " + message);
    }
}

class SMSNotifier implements Observer {
    private String phoneNumber;

    public SMSNotifier(String phoneNumber) { this.phoneNumber = phoneNumber; }

    @Override
    public void update(String eventType, String message) {
        System.out.println("📱 SMS to " + phoneNumber + " | Event: " + eventType + " | Message: " + message);
    }
}

class PushNotifier implements Observer {
    private String deviceId;

    public PushNotifier(String deviceId) { this.deviceId = deviceId; }

    @Override
    public void update(String eventType, String message) {
        System.out.println("📲 Push to " + deviceId + " | Event: " + eventType + " | Message: " + message);
    }
}

// ----------------- SUBJECT INTERFACE -----------------
interface Subject {
    void registerObserver(String eventType, Observer o);
    void removeObserver(String eventType, Observer o);
    void notifyObservers(String eventType, String message);
}

// ----------------- CONCRETE SUBJECT -----------------
class NotificationService implements Subject {
    private Map<String, List<Observer>> observers = new HashMap<>();

    @Override
    public void registerObserver(String eventType, Observer o) {
        observers.putIfAbsent(eventType, new ArrayList<>());
        observers.get(eventType).add(o);
        System.out.println("✅ Registered observer for " + eventType + ": " + o.getClass().getSimpleName());
    }

    @Override
    public void removeObserver(String eventType, Observer o) {
        if (observers.containsKey(eventType)) {
            observers.get(eventType).remove(o);
            System.out.println("❌ Removed observer from " + eventType + ": " + o.getClass().getSimpleName());
        }
    }

    @Override
    public void notifyObservers(String eventType, String message) {
        if (observers.containsKey(eventType)) {
            System.out.println("\n--- Notifying observers for event: " + eventType + " ---");
            for (Observer o : observers.get(eventType)) {
                o.update(eventType, message);
            }
        } else {
            System.out.println("⚠️ No observers registered for event: " + eventType);
        }
    }

    public void triggerEvent(String eventType, String message) {
        System.out.println("\n🎯 Event Triggered: " + eventType + " | Message: " + message);
        notifyObservers(eventType, message);
    }
}

// ----------------- DEMO -----------------
public class NotificationSystemAdvancedDemo {
    public static void main(String[] args) {
        NotificationService service = new NotificationService();

        // Users
        Observer email1 = new EmailNotifier("user1@example.com");
        Observer sms1 = new SMSNotifier("+911234567890");
        Observer push1 = new PushNotifier("device123");

        Observer email2 = new EmailNotifier("user2@example.com");
        Observer sms2 = new SMSNotifier("+919876543210");

        // Register observers for specific events
        service.registerObserver("OrderPlaced", email1);
        service.registerObserver("OrderPlaced", sms1);
        service.registerObserver("OrderPlaced", push1);

        service.registerObserver("OTPGenerated", sms1);
        service.registerObserver("OTPGenerated", sms2);

        service.registerObserver("DeliveryStatus", email2);
        service.registerObserver("DeliveryStatus", push1);

        // Trigger events
        service.triggerEvent("OrderPlaced", "Your order #1234 has been placed!");
        service.triggerEvent("OTPGenerated", "Your OTP is 987654");
        service.triggerEvent("DeliveryStatus", "Order #1234 is out for delivery");

        // Remove observer dynamically
        service.removeObserver("OrderPlaced", push1);
        service.triggerEvent("OrderPlaced", "Your order #1235 has been placed!");
    }
}
