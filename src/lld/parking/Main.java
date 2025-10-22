package lld.parking;

import java.util.*;

// Vehicle Types
abstract class Vehicle {
    String licensePlate;
    public Vehicle(String licensePlate) { this.licensePlate = licensePlate; }
    public abstract String getType();
}

class Car extends Vehicle {
    public Car(String licensePlate) { super(licensePlate); }
    @Override
    public String getType() { return "Car"; }
}

class Bike extends Vehicle {
    public Bike(String licensePlate) { super(licensePlate); }
    @Override
    public String getType() { return "Bike"; }
}

// Vehicle Factory
class VehicleFactory {
    public static Vehicle createVehicle(String type, String licensePlate) {
        switch(type) {
            case "Car": return new Car(licensePlate);
            case "Bike": return new Bike(licensePlate);
            default: throw new IllegalArgumentException("Invalid vehicle type");
        }
    }
}

// Parking Slot
class Slot {
    int slotNumber;
    boolean isOccupied;
    Vehicle vehicle;

    public Slot(int slotNumber) { this.slotNumber = slotNumber; this.isOccupied = false; }

    public boolean park(Vehicle vehicle) {
        if(isOccupied) return false;
        this.vehicle = vehicle;
        isOccupied = true;
        return true;
    }

    public boolean leave() {
        if(!isOccupied) return false;
        this.vehicle = null;
        isOccupied = false;
        return true;
    }

    @Override
    public String toString() {
        return "Slot " + slotNumber + " [" + (isOccupied ? vehicle.getType() + " " + vehicle.licensePlate : "Empty") + "]";
    }
}

// Parking Floor
class Floor {
    int floorNumber;
    List<Slot> slots;

    public Floor(int floorNumber, int numSlots) {
        this.floorNumber = floorNumber;
        slots = new ArrayList<>();
        for(int i=1; i<=numSlots; i++) slots.add(new Slot(i));
    }

    public Slot getAvailableSlot() {
        for(Slot s : slots) if(!s.isOccupied) return s;
        return null;
    }
}

// Parking Lot (Singleton)
class ParkingLot {
    private static ParkingLot instance;
    List<Floor> floors;

    private ParkingLot(int numFloors, int slotsPerFloor) {
        floors = new ArrayList<>();
        for(int i=1; i<=numFloors; i++) floors.add(new Floor(i, slotsPerFloor));
    }

    public static ParkingLot getInstance(int numFloors, int slotsPerFloor) {
        if(instance == null) instance = new ParkingLot(numFloors, slotsPerFloor);
        return instance;
    }

    public Slot parkVehicle(Vehicle vehicle) {
        for(Floor f : floors) {
            Slot slot = f.getAvailableSlot();
            if(slot != null && slot.park(vehicle)) return slot;
        }
        System.out.println("Parking Full!");
        return null;
    }

    public boolean leaveVehicle(Vehicle vehicle) {
        for(Floor f : floors) {
            for(Slot s : f.slots) {
                if(s.isOccupied && s.vehicle.equals(vehicle)) return s.leave();
            }
        }
        System.out.println("Vehicle not found!");
        return false;
    }

    public void showStatus() {
        for(Floor f : floors) {
            System.out.println("Floor " + f.floorNumber + ":");
            for(Slot s : f.slots) System.out.println("  " + s);
        }
    }
}

// Demo
public class Main {
    public static void main(String[] args) {
        ParkingLot lot = ParkingLot.getInstance(2, 3); // 2 floors, 3 slots each

        Vehicle car1 = VehicleFactory.createVehicle("Car", "KA-01-1234");
        Vehicle bike1 = VehicleFactory.createVehicle("Bike", "KA-01-5678");
        Vehicle car2 = VehicleFactory.createVehicle("Car", "KA-01-9999");

        lot.parkVehicle(car1);
        lot.parkVehicle(bike1);
        lot.parkVehicle(car2);

        lot.showStatus();

        lot.leaveVehicle(bike1);
        System.out.println("After Bike leaves:");
        lot.showStatus();
    }
}
