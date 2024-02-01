import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Write {

    public static void main(String[] args) {
        try {

            Scanner sc = new Scanner(System.in);
            // write in file
            System.out.print("\nType Your Thought : ");
            String data = sc.nextLine();

            FileWriter fileWriter = new FileWriter("output.txt");
            fileWriter.write(data);
            fileWriter.close();

            try (// read from file
                    BufferedReader br = new BufferedReader(new FileReader("output.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println("----------------");
                    System.out.print("\nyour Thought :");
                    System.out.println('"' + line + '"');
                }
            }

            sc.close();
        } catch (IOException e) {
            System.out.println("Error Occured");
            e.printStackTrace();
        }

    }
}
