import java.util.Scanner;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to calculate its factorial: ");
        int number = scanner.nextInt();

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Long> future = executor.submit(new FactorialTask(number));

        System.out.println("Calculating factorial...");

        try {
            long result = future.get();
            System.out.println("Factorial: " + result);
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("An error occurred during calculation: " + e.getMessage());
        }

        executor.shutdown();
    }

    static class FactorialTask implements Callable<Long> {
        private final int number;

        FactorialTask(int number) {
            this.number = number;
        }

        @Override
        public Long call() {
            long factorial = 1;
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }
            return factorial;
        }
    }
}
