// Create a program that reads a paragraph of text and counts the frequency of each word in the paragraph. The program should display the word and its corresponding frequency.

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class wordFrequenyCounter {

    public static void main(String[] args) {

        // Create a HashMap to store a word-frequency pairs.
        Map<String, Integer> frequencyCounter = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        // prompt the user to enter a paragraph of a text.
        System.out.println("Write a Paaragraph.");
        String para = sc.nextLine();
        System.out.println(para);

        // Split the paragraph into individual words and count the frequency of each
        // word.
        String[] words = para.split("\\s+");

        for (String word : words) {

            word = word.replaceAll("[^a-zA-z]", "").toLowerCase();
            if (!word.isEmpty()) {
                int frequency = frequencyCounter.getOrDefault(word, 0);
                frequencyCounter.put(word, frequency + 1);
            }
        }

        System.out.println(frequencyCounter);
        sc.close();
    }
}
