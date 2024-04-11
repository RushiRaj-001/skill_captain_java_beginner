package ThreadLocal;

import java.util.HashMap;

public class Main {

    // Define a ThreadLocal variable to store session data for each thread
    private static ThreadLocal<HashMap<String, String>> threadSession = ThreadLocal.withInitial(HashMap::new);

    // Method to set login session data for the current thread
    public static void setLoginSessionData(String key, String value) {
        HashMap<String, String> sessionData = threadSession.get();
        sessionData.put(key, value);
    }

    // Method to get login session data for the current thread
    public static String getLoginSessionData(String key) {
        HashMap<String, String> sessionData = threadSession.get();
        return sessionData.get(key);
    }

    public static void main(String[] args) {
        // Create and start multiple threads
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            final int threadId = i;
            threads[i] = new Thread(() -> {
                // Set login session data for each thread
                setLoginSessionData("username", "user" + threadId);
                setLoginSessionData("password", "password" + threadId);
                
                // Print login session data for the current thread
                System.out.println("Thread " + threadId + " login session data:");
                System.out.println("Username: " + getLoginSessionData("username"));
                System.out.println("Password: " + getLoginSessionData("password"));
                System.out.println();
            });
            threads[i].start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
