import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Theater {
    private int totalSeats;
    private int availableSeats;
    private Lock lock;

    public Theater(int totalSeats) {
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
        this.lock = new ReentrantLock();
    }

    public boolean reserveSeat(int numSeats) {
        lock.lock();
        try {
            if (availableSeats >= numSeats) {
                availableSeats -= numSeats;
                System.out.println("Seat(s) reserved successfully!");
                return true;
            } else {
                System.out.println("Sorry, not enough seats available.");
                return false;
            }
        } finally {
            lock.unlock();
        }
    }
}

class User implements Runnable {
    private Theater theater;
    private int numSeatsRequested;

    public User(Theater theater, int numSeatsRequested) {
        this.theater = theater;
        this.numSeatsRequested = numSeatsRequested;
    }

    @Override
    public void run() {
        theater.reserveSeat(numSeatsRequested);
    }
}

public class Main {
    public static void main(String[] args) {
        Theater theater = new Theater(50); // Total seats in the theater
        int numUsers = 10; // Number of users trying to reserve seats simultaneously

        for (int i = 0; i < numUsers; i++) {
            Thread userThread = new Thread(new User(theater, 2)); // Each user tries to reserve 2 seats
            userThread.start();
        }
    }
}
