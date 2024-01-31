
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Input {
    public static void main(String[] args) throws IOException {

        FileWriter fileWriter = new FileWriter("input.txt");

        fileWriter.write("Java is a popular programming language used for developing a wide range of applications. It is known for its simplicity and versatility. Many developers enjoy working with Java. However, learning Java requires practice and dedication. With enough effort, anyone can become proficient in Java.");
        fileWriter.close();

        int count = 0;

        File file = new File("input.txt");
        try (Scanner sc = new Scanner(file)) {

            while (sc.hasNextLine()) {

                String content = sc.nextLine();
                System.out.println(content);
                String[] words = content.replaceAll("[^a-zA-Z\\s]", "").split("\\s+");

                for (String word : words) {
                    if (word.equalsIgnoreCase("java")) {
                        count++;
                    }
                }
            }

            System.out.println("java : " + count);

            sc.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }

    }
}