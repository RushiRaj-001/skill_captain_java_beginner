
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        String directoryPath = "C:\\Users\\HP\\Desktop\\skill Capatin Git Repos\\skill_captain_java_beginner"; 
        File directory = new File(directoryPath);

        if (!directory.isDirectory()) {
            System.out.println("Invalid directory path.");
            return;
        }

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        AtomicInteger totalWordCount = new AtomicInteger(0);

        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                executorService.submit(() -> {
                    try {
                        int wordCount = countWords(file);
                        totalWordCount.addAndGet(wordCount);
                        System.out.println("Word count for " + file.getName() + ": " + wordCount);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        }

        executorService.shutdown();
        while (!executorService.isTerminated()) {
            
        }

        System.out.println("Total word count for all files: " + totalWordCount.get());
    }

    private static int countWords(File file) throws IOException {
        List<String> lines = Files.readAllLines(file.toPath());
        int wordCount = 0;
        for (String line : lines) {
            String[] words = line.split("\\s+");
            wordCount += words.length;
        }
        return wordCount;
    }
}

