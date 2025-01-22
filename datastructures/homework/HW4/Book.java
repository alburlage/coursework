//DO NOT REMOVE PACKAGE LINE
//Without this line authograder will not run correctly
//You can comment it while you work on the problem
//When everything works - uncomment and submit!
package com.gradescope.hw4;

/*Header
/HW4
/Names:
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Book {

    public static void main(String[] args) {
        // Example usage
        // Replace "yourfile.txt" with the actual name of your text file
        TreeMap<String, Integer> wordCounts = words("input");
        assert wordCounts != null;
        statistics(wordCounts);
    }

    // Method to remove punctuation and convert to lowercase
    public static String punctuation(String s) {
        // Convert the string to lowercase
        s = s.toLowerCase();

        StringBuilder result = new StringBuilder();

        // Define the characters to remove
        String punctuationChars = ".,'\"!?"; // Add more punctuation characters if needed

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            // If the character is not in the punctuation string, append it to the result
            if (punctuationChars.indexOf(currentChar) == -1) {
                result.append(currentChar);
            }
        }

        return result.toString(); // Return the result as a string
    }


    // Method to read a file and count word occurrences
    public static TreeMap<String, Integer> words(String filename) {
        TreeMap<String, Integer> wordMap = new TreeMap<>();
        File file = new File(filename);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                String cleanedWord = punctuation(word); // Clean the word of punctuation
                if (!cleanedWord.isEmpty()) { // Ensure the cleaned word is not empty
                    wordMap.put(cleanedWord, wordMap.getOrDefault(cleanedWord, 0) + 1);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            return null; // Return null or handle it as per your requirement
        }

        return wordMap;
    }

    // Method to print statistics based on the word occurrences
    public static void statistics(TreeMap<String, Integer> m) {
        if (m.isEmpty()){
            return;
        }
        int numberOfUniqueWords = m.size(); // Unique words
        int totalWords = 0; // Total count of all words
        String commonWord = ""; // To hold most common word
        int maxCount = 0; // To hold max count
        String longestWord = ""; // To hold longest word
        int isCount = m.getOrDefault("is", 0); // Count of the word "is"

        for (Map.Entry<String, Integer> entry : m.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();
            totalWords += count; // add to total word count

            // Check for the most common word
            if (count > maxCount) {
                maxCount = count;
                commonWord = word;
            }

            // Check for the longest word
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        // Print the statistics with the correct expected wording
        System.out.println("Number of different words in book: " + numberOfUniqueWords);
        System.out.println("Total number of in book: " + totalWords); // Corrected wording
        System.out.println("Most common word in book: " + commonWord);
        System.out.println("Longest word in book: " + longestWord);
        System.out.println("Is occurs in book: " + isCount + " times");
    }
}
