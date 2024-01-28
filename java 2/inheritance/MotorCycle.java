//3. Create a class named "Motorcycle" that extends "Vehicle" with an additional attribute: engineCapacity.

public class MotorCycle extends Vehicle{
    
    public MotorCycle(String brand, String model, int year, int rentalPrice){
        super(brand, model, year, rentalPrice);

    }

    public void engineCapacity(int power){
        System.out.println("Engine capacity is: " + power +" cc");
    }

}
