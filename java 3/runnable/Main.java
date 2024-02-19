package runnable;
import java.util.*;

class Runner implements Runnable {
    private String name;
    private int distanceCovered;
    private int totalDistance;
    private Random random;

    public Runner(String name, int totalDistance) {
        this.name = name;
        this.totalDistance = totalDistance;
        this.distanceCovered = 0;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (distanceCovered < totalDistance) {
            try {
            
                int distanceToRun = random.nextInt(10) + 1; 
                distanceCovered += distanceToRun;

               
                Thread.sleep(100);

             
                System.out.println(name + " has covered " + distanceCovered + " units.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Declare the winner
        System.out.println(name + " has finished the race!");
    }
}

public class Main {
    public static void main(String[] args) {
        int totalDistance = 100; 

        // Create three runners
        Runner runner1 = new Runner("Runner 1", totalDistance);
        Runner runner2 = new Runner("Runner 2", totalDistance);
        Runner runner3 = new Runner("Runner 3", totalDistance);

        // Create threads for each runner
        Thread thread1 = new Thread(runner1);
        Thread thread2 = new Thread(runner2);
        Thread thread3 = new Thread(runner3);

        // Start the threads
        thread1.start();
        thread2.start();
        thread3.start();

        try {
            // Wait for all threads to finish
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the winner
        System.out.println("Race finished!");
    }
}
