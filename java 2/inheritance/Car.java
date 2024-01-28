public class Car extends Vehicle {
    int numberOfSeats;

    // Implement a method to retrieve the number of seats.
    public Car(String brand, String model, int year, int rentalPrice) {
        super(brand, model, year, rentalPrice);

    }

    public void seats(int numberOfSeats) {
        System.out.println("number of seats : " + numberOfSeats);
    }
}