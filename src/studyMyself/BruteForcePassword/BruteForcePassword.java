package studyMyself.BruteForcePassword;

import java.time.*;
import java.util.*;

public class BruteForcePassword {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            // String chars = "abcdefghijklmnopqrstuvwxyz";
            String guess = "";
            List<String> guesses = new ArrayList<>();

            // Define the character set for brute-forcing
            String charSet = "abcdefghijklmnopqrstuvwxyz";

            Instant start = Instant.now();

            outerLoop: for (int length = 1; length <= password.length(); length++) { // Iterate through possible
                                                                                     // password lengths
                List<String> currentGuesses = new ArrayList<>();
                if (length == 1) {
                    for (char c : charSet.toCharArray()) {
                        currentGuesses.add(String.valueOf(c));
                    }
                } else {
                    // Generate guesses of the current length based on previous length's guesses
                    for (String prevGuess : guesses) {
                        for (char c : charSet.toCharArray()) {
                            currentGuesses.add(prevGuess + c);
                        }
                    }
                }
                guesses = currentGuesses; // Update guesses for the next iteration

                for (String currentGuess : guesses) {
                    System.out.println(currentGuess); // Print each guess
                    if (currentGuess.equals(password)) {
                        guess = currentGuess; // Store the correct guess
                        break outerLoop; // Exit all loops once password is found
                    }
                }
            }

            Instant end = Instant.now();
            double timeTaken = Duration.between(start, end).toNanos() / 1_000_000_000.0;

            System.out.println("Your password: " + guess); // Print the found password
            System.out.printf("Time taken: %.6f seconds%n", timeTaken);
        }
    }
}
