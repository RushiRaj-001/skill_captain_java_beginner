//1. Create a class named "Vehicle" with attributes: brand, model, year, and rentalPrice.

public class Vehicle {

	String brand;
	String model;
	int year;
	int rentalPrice;

	public Vehicle(String brand, String model, int year, int rentalPrice) {
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.rentalPrice = rentalPrice;
	}

	// Implement a method to display the vehicle information.
	void display() {
		System.out.println("Vehicle Information : ");
		System.out.println("vehicle brand : " + brand);
		System.out.println("vehicle model : " + model);
		System.out.println("vehicle year : " + year);
		System.out.println("vehicle rentalPrice : " + rentalPrice);

	}

	public static void main(String[] args) {
		Car c1 = new Car("Mercedes", "G-wagon", 2024, 50000);
		MotorCycle m1 = new MotorCycle("RoyalEnfield", "continental GT 650", 2024, 20000);
		c1.display();
		c1.seats(4);
		System.out.println("---------------------------");

		m1.display();
		m1.engineCapacity(650);
	}
}
