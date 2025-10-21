package lld.taxi;

import java.util.*;

class Booking {
    int bookingId;
    int customerId;
    char from, to;
    int pickupTime, dropTime;
    int amount;

    public Booking(int bookingId, int customerId, char from, char to, int pickupTime, int dropTime, int amount) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.from = from;
        this.to = to;
        this.pickupTime = pickupTime;
        this.dropTime = dropTime;
        this.amount = amount;
    }
}

class Taxi {
    int id;
    char currentPoint = 'A';
    int freeTime = 0;
    int totalEarnings = 0;
    List<Booking> trips = new ArrayList<>();

    public Taxi(int id) {
        this.id = id;
    }

    public boolean isFreeAt(int pickupTime) {
        return pickupTime >= freeTime;
    }

    public void addBooking(Booking booking) {
        trips.add(booking);
        totalEarnings += booking.amount;
        currentPoint = booking.to;
        freeTime = booking.dropTime;
    }

    @Override
    public String toString() {
        return "Taxi-" + id + " at " + currentPoint + " (Earnings: Rs." + totalEarnings + ")";
    }
}

class CallTaxiBookingService {
    List<Taxi> taxis = new ArrayList<>();
    int bookingCounter = 1;

    public CallTaxiBookingService(int taxiCount) {
        for (int i = 1; i <= taxiCount; i++) {
            taxis.add(new Taxi(i));
        }
    }

    public void bookTaxi(int customerId, char from, char to, int pickupTime) {
        Taxi chosenTaxi = findNearestTaxi(from, pickupTime);
        if (chosenTaxi == null) {
            System.out.println("No taxi can be allotted.\n");
            return;
        }

        int distance = Math.abs(from - to) * 15;
        int fare = 100 + Math.max(0, distance - 5) * 10;
        int dropTime = pickupTime + Math.abs(from - to);

        Booking booking = new Booking(bookingCounter++, customerId, from, to, pickupTime, dropTime, fare);
        chosenTaxi.addBooking(booking);

        System.out.println("Taxi can be allotted.");
        System.out.println("Taxi-" + chosenTaxi.id + " is allotted.\n");
    }

    private Taxi findNearestTaxi(char from, int pickupTime) {
        Taxi result = null;
        int minDistance = Integer.MAX_VALUE;

        for (Taxi taxi : taxis) {
            if (taxi.isFreeAt(pickupTime)) {
                int distance = Math.abs(taxi.currentPoint - from);
                if (distance < minDistance) {
                    minDistance = distance;
                    result = taxi;
                } else if (distance == minDistance && taxi.totalEarnings < result.totalEarnings) {
                    result = taxi;
                }
            }
        }

        return result;
    }

    public void displayTaxiDetails() {
        for (Taxi taxi : taxis) {
            System.out.println("Taxi-" + taxi.id + "    Total Earnings: Rs." + taxi.totalEarnings);
            System.out.println("BookingID   CustomerID   From   To   PickupTime   DropTime   Amount");
            for (Booking b : taxi.trips) {
                System.out.printf("%-11d %-13d %-6c %-5c %-12d %-10d %-5d\n",
                        b.bookingId, b.customerId, b.from, b.to, b.pickupTime, b.dropTime, b.amount);
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        CallTaxiBookingService service = new CallTaxiBookingService(4);

        service.bookTaxi(1, 'A', 'B', 9);
        service.bookTaxi(2, 'B', 'D', 9);
        service.bookTaxi(3, 'B', 'C', 12);

        service.displayTaxiDetails();
    }
}
