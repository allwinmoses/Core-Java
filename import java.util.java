import java.util.Scanner;

public class StringFunctions {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Get input string from the user
        System.out.print("Enter the input string: ");
        String inputString = scanner.nextLine();

        // Get the delimiter character from the user
        System.out.print("Enter the delimiter character: ");
        char delimiter = scanner.nextLine().charAt(0);

        // 1. Split input string using input delimiter
        String[] splitResult = inputString.split(String.valueOf(delimiter));
        System.out.print("1. Split input string using delimiter: ");
        for (String part : splitResult) {
            System.out.print(part + " ");
        }
        System.out.println();

        // 2. Find the vowels in the input string
        String vowels = inputString.replaceAll("[^aeiouAEIOU]", "");
        System.out.println("2. Vowels in the input string: " + vowels);

        // 3. Find the number of words in the input string
        String[] words = inputString.split("\\s+");
        int wordCount = words.length;
        System.out.println("3. Number of words in the input string: " + wordCount);

        // 4. Find the number of characters in the input string, including whitespaces and special characters
        int charCount = inputString.length();
        System.out.println("4. Number of characters in the input string: " + charCount);

        // Close the scanner
        scanner.close();
    }
}
