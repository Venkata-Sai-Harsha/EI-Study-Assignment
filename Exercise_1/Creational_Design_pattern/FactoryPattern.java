package Exercise_1.Creational_Design_pattern;
//usecase-4: Factory Pattern [Creational]

// Vehicle interface
interface Vehicle {
    void drive();
}

// Concrete Vehicle 1: Car
class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a Car.");
    }
}

// Concrete Vehicle 2: Truck
class Truck implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a Truck.");
    }
}

// Concrete Vehicle 3: Bike
class Bike implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Riding a Bike.");
    }
}

// Vehicle Factory
class VehicleFactory {
    // Factory method to create Vehicle objects
    public static Vehicle getVehicle(String vehicleType) {
        if (vehicleType == null) {
            return null;
        }
        switch (vehicleType.toLowerCase()) {
            case "car":
                return new Car();
            case "truck":
                return new Truck();
            case "bike":
                return new Bike();
            default:
                return null;
        }
    }
}

// Demo to test Factory Pattern
public class FactoryPattern {
    public static void main(String[] args) {
        Vehicle vehicle1 = VehicleFactory.getVehicle("car");
        vehicle1.drive();  // Output: Driving a Car.

        Vehicle vehicle2 = VehicleFactory.getVehicle("truck");
        vehicle2.drive();  // Output: Driving a Truck.

        Vehicle vehicle3 = VehicleFactory.getVehicle("bike");
        vehicle3.drive();  // Output: Riding a Bike.
    }
}
