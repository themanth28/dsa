package lld.railwayTicket;

import java.util.*;

enum SeatType {
    AC, NON_AC, SEATER
}

enum BookingStatus {
    CONFIRMED, WAITING
}

class Passenger {
    int id;
    String name;

    public Passenger(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Booking {
    int pnr;
    Passenger passenger;
    SeatType seatType;
    BookingStatus status;

    public Booking(int pnr, Passenger passenger, SeatType seatType, BookingStatus status) {
        this.pnr = pnr;
        this.passenger = passenger;
        this.seatType = seatType;
        this.status = status;
    }
}

class Coach {
    SeatType seatType;
    int capacity = 60;
    int waitingCapacity = 10;

    List<Booking> confirmed = new ArrayList<>();
    Queue<Booking> waitingList = new LinkedList<>();

    public Coach(SeatType seatType) {
        this.seatType = seatType;
    }

    public boolean hasAvailableSeat() {
        return confirmed.size() < capacity;
    }

    public boolean hasWaitingSeat() {
        return waitingList.size() < waitingCapacity;
    }

    public Booking bookSeat(int pnr, Passenger passenger) {
        if (hasAvailableSeat()) {
            Booking booking = new Booking(pnr, passenger, seatType, BookingStatus.CONFIRMED);
            confirmed.add(booking);
            return booking;
        } else if (hasWaitingSeat()) {
            Booking booking = new Booking(pnr, passenger, seatType, BookingStatus.WAITING);
            waitingList.add(booking);
            return booking;
        } else {
            return null;
        }
    }

    public boolean cancelBooking(int pnr) {
        // cancel from confirmed list
        for (Iterator<Booking> it = confirmed.iterator(); it.hasNext(); ) {
            Booking b = it.next();
            if (b.pnr == pnr) {
                it.remove();
                promoteWaiting();
                return true;
            }
        }

        // cancel from waiting list
        for (Iterator<Booking> it = waitingList.iterator(); it.hasNext(); ) {
            Booking b = it.next();
            if (b.pnr == pnr) {
                it.remove();
                return true;
            }
        }

        return false;
    }

    private void promoteWaiting() {
        if (!waitingList.isEmpty()) {
            Booking next = waitingList.poll();
            next.status = BookingStatus.CONFIRMED;
            confirmed.add(next);
        }
    }

    public void showAvailability() {
        System.out.println(seatType + " - Available Seats: " + (capacity - confirmed.size()) +
                ", Waiting: " + waitingList.size());
    }

    public void prepareChart() {
        System.out.println("\n=== " + seatType + " Coach ===");
        System.out.println("PNR   Name   Status");
        for (Booking b : confirmed)
            System.out.println(b.pnr + "   " + b.passenger.name + "   CONFIRMED");
        for (Booking b : waitingList)
            System.out.println(b.pnr + "   " + b.passenger.name + "   WAITING");
    }
}

class RailwayReservationSystem {
    Map<SeatType, Coach> coaches = new HashMap<>();
    int pnrCounter = 1000;

    public RailwayReservationSystem() {
        for (SeatType type : SeatType.values()) {
            coaches.put(type, new Coach(type));
        }
    }

    public void bookTicket(String name, SeatType type) {
        Passenger p = new Passenger(pnrCounter, name);
        Coach coach = coaches.get(type);

        Booking booking = coach.bookSeat(pnrCounter, p);
        if (booking == null) {
            System.out.println("❌ No seats or waiting list available for " + type);
        } else {
            System.out.println("✅ Booking Successful | PNR: " + booking.pnr + " | " + booking.status + " | " + type);
        }
        pnrCounter++;
    }

    public void cancelTicket(int pnr) {
        boolean cancelled = false;
        for (Coach c : coaches.values()) {
            if (c.cancelBooking(pnr)) {
                System.out.println("🟡 Ticket with PNR " + pnr + " cancelled successfully.");
                cancelled = true;
                break;
            }
        }
        if (!cancelled) {
            System.out.println("❌ PNR not found.");
        }
    }

    public void checkAvailability() {
        System.out.println("\n=== Availability Status ===");
        for (Coach c : coaches.values()) {
            c.showAvailability();
        }
    }

    public void prepareChart() {
        for (Coach c : coaches.values()) {
            c.prepareChart();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        RailwayReservationSystem system = new RailwayReservationSystem();

        // Book some tickets
        system.bookTicket("Hemanth", SeatType.AC);
        system.bookTicket("Arun", SeatType.AC);
        system.bookTicket("Bala", SeatType.NON_AC);
        system.bookTicket("Deva", SeatType.SEATER);

        // Check availability
        system.checkAvailability();

        // Cancel one ticket
        system.cancelTicket(1000);

        // Prepare chart
        system.prepareChart();
    }
}
