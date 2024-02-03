

abstract class Vehicle {
    String make;
    String model;
    int year;
    double price;

    public Vehicle(String make, String model, int year, int price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;

    }

    public abstract void displayDetails();
}

class Car extends Vehicle {

    int numDoors;
    String fuelType;

    public Car(String make, String model, int year, int price, int numDoors, String fuelType) {
        super(make, model, year, price);
        this.numDoors = numDoors;
        this.fuelType = fuelType;
    }

    int calculateMilage() {
        return 0;
    }

    public void displayDetails() {
        System.out.println("make of the car : " + make);
        System.out.println("Model of the car : " + model);
        System.out.println("year of manufacture the Car. : " + year);
        System.out.println("price of the car : " + price);
        System.out.println("number of door : " + numDoors);
        System.out.println("car fueltype : " + fuelType);
        System.out.println("----------------------------------");
    }
}

class MotorCycle extends Vehicle {

    boolean hasSidecar;
    int engineCapacity;

    public MotorCycle(String make, String model, int year, int price, boolean hasSidecar, int engineCapacity) {
        super(make, model, year, price);
        this.hasSidecar = hasSidecar;
        this.engineCapacity = engineCapacity;
    }

    int calculateSpeed(int topSpeed) {
        return 0;
    }

    public void displayDetails() {
        System.out.println("make of the MotorCycle : " + make);
        System.out.println("Model of the MotorCycle : " + model);
        System.out.println("year of manufacture the MotorCycle. : " + year);
        System.out.println("price of the MotorCycle : " + price);
        System.out.println("Sidebar : " + hasSidecar);
        System.out.println("engine Capaity : " + engineCapacity + "cc");
        System.out.println("-------------------------");
    }
}

public class VehicleInventorySystem {

    public static void main(String[] args) {

        Car c1 = new Car("maruti suzuki", "swift", 2024, 600000, 4, "petrol");
        MotorCycle m1 = new MotorCycle("yamaha", "R15", 2024, 250000, false, 150);

        c1.displayDetails();
        m1.displayDetails();
    }
}
