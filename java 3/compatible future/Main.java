
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

class FileProcessor {
    public CompletableFuture<FileProcessResult> processFile(String filePath) {
        CompletableFuture<FileProcessResult> future = new CompletableFuture<>();
        
        CompletableFuture.runAsync(() -> {
            try {
                long lineCount = Files.lines(Paths.get(filePath)).count();
                long wordCount = Files.lines(Paths.get(filePath))
                                      .flatMap(line -> Stream.of(line.split("\\s+")))
                                      .filter(word -> !word.isEmpty())
                                      .count();
                FileProcessResult result = new FileProcessResult(filePath, lineCount, wordCount);
                future.complete(result);
            } catch (IOException e) {
                future.completeExceptionally(e);
            }
        });
        
        return future;
    }
}

class FileProcessResult {
    private String filePath;
    private long lineCount;
    private long wordCount;

    public FileProcessResult(String filePath, long lineCount, long wordCount) {
        this.filePath = filePath;
        this.lineCount = lineCount;
        this.wordCount = wordCount;
    }

    public String getFilePath() {
        return filePath;
    }

    public long getLineCount() {
        return lineCount;
    }

    public long getWordCount() {
        return wordCount;
    }
}

public class Main {
    public void processFiles(String[] filePaths) {
        CompletableFuture<Void>[] futures = new CompletableFuture[filePaths.length];
        FileProcessor fileProcessor = new FileProcessor();

        for (int i = 0; i < filePaths.length; i++) {
            String filePath = filePaths[i];
            CompletableFuture<FileProcessResult> future = fileProcessor.processFile(filePath);
            futures[i] = future.thenAccept(this::printFileProcessResult);
        }

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures);
        allOf.join();
    }

    private void printFileProcessResult(FileProcessResult result) {
        System.out.println("File: " + result.getFilePath());
        System.out.println("Line count: " + result.getLineCount());
        System.out.println("Word count: " + result.getWordCount());
        System.out.println();
    }

    public static void main(String[] args) {
        Main fileApp = new Main();
        String[] filePaths = {"file1.txt", "file2.txt", "file3.txt"}; // Replace with actual file paths
        fileApp.processFiles(filePaths);
    }
}

