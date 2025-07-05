import java.util.HashMap;
import java.util.Map;

class Vehicle {
    String vehicleNo;
    String vehicleType;
    String vehicleModel;
    String phoneNo;
    String customerName;
    long checkInTime;
    long checkOutTime;
}

class ValetParkingSystem {
    private Map<String, Vehicle> vehicles = new HashMap<>();

    public void checkIn(String vehicleNo, String vehicleType, String vehicleModel,
                        String phoneNo, String customerName, long checkInTime) {
        if (vehicles.containsKey(vehicleNo)) {
            System.out.println("Vehicle with the same number is already parked.");
            return;
        }

        Vehicle vehicle = new Vehicle();
        vehicle.vehicleNo = vehicleNo;
        vehicle.vehicleType = vehicleType;
        vehicle.vehicleModel = vehicleModel;
        vehicle.phoneNo = phoneNo;
        vehicle.customerName = customerName;
        vehicle.checkInTime = checkInTime;

        vehicles.put(vehicleNo, vehicle);
        System.out.println("Check-in successful.");
    }

    public void displayValetParkingList() {
        for (Vehicle vehicle : vehicles.values()) {
            System.out.println("Vehicle No: " + vehicle.vehicleNo);
            System.out.println("Vehicle Type: " + vehicle.vehicleType);
            System.out.println("Vehicle Model: " + vehicle.vehicleModel);
            System.out.println("Phone No: " + vehicle.phoneNo);
            System.out.println("Customer Name: " + vehicle.customerName);
            System.out.println("Check-in Time: " + vehicle.checkInTime);
            System.out.println("Check-out Time: " + vehicle.checkOutTime);
            System.out.println();
        }
    }

    public void searchForVehicle(String vehicleNo) {
        if (vehicles.containsKey(vehicleNo)) {
            Vehicle vehicle = vehicles.get(vehicleNo);
            System.out.println("Vehicle No: " + vehicle.vehicleNo);
            System.out.println("Vehicle Type: " + vehicle.vehicleType);
            System.out.println("Vehicle Model: " + vehicle.vehicleModel);
            System.out.println("Phone No: " + vehicle.phoneNo);
            System.out.println("Customer Name: " + vehicle.customerName);
            System.out.println("Check-in Time: " + vehicle.checkInTime);
            System.out.println("Check-out Time: " + vehicle.checkOutTime);
        } else {
            System.out.println("Vehicle not found.");
        }
    }

    public void checkOut(String vehicleNo, long checkOutTime) {
        if (!vehicles.containsKey(vehicleNo)) {
            System.out.println("Vehicle not found.");
            return;
        }

        Vehicle vehicle = vehicles.get(vehicleNo);
        vehicle.checkOutTime = checkOutTime;

        long duration = (vehicle.checkOutTime - vehicle.checkInTime) / (1000 * 60);
        int amount = (int) Math.ceil(duration / 30.0) * 10;

        System.out.println("Total Duration: " + duration + " minutes");
        System.out.println("Total Amount: Rs. " + amount);

        vehicles.remove(vehicleNo);
    }
}

public class Allwin_A {
    public static void main(String[] args) {
        ValetParkingSystem parkingSystem = new ValetParkingSystem();

        parkingSystem.checkIn("KA123", "Car", "Sedan", "9876543210", "John Doe", System.currentTimeMillis());
        parkingSystem.checkIn("MH456", "Bike", "Sport", "8765432109", "Jane Smith", System.currentTimeMillis());

        System.out.println("Valet Parking List:");
        parkingSystem.displayValetParkingList();

        System.out.println("Search for vehicle MH456:");
        parkingSystem.searchForVehicle("MH456");

        long checkOutTime = System.currentTimeMillis() + 45 * 60 * 1000; // 45 minutes later
        parkingSystem.checkOut("KA123", checkOutTime);
    }
}