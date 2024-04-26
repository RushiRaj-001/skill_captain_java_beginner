class Logger {
    private static volatile Logger instance;

    private Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public synchronized void log(String message) {
        System.out.println(message);
    }
}

class LogWriterThread extends Thread {
    private Logger logger;

    public LogWriterThread(Logger logger) {
        this.logger = logger;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void run() {
        logger.log("Thread " + Thread.currentThread().getId() + " is writing a log message.");
    }
}

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        // Create multiple instances of LogWriterThread and start them concurrently
        int numThreads = 5;
        for (int i = 0; i < numThreads; i++) {
            Thread thread = new LogWriterThread(logger);
            thread.start();
        }
    }
}
