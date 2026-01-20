// Copyright (c) 2026 Erik Petrosyan, Ruan Viesti Moares
package culminating;

import java.util.*;
import java.io.IOException;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MarketPredictor predictor = new MarketPredictor();

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   Housing Market Prediction System");
        System.out.println("========================================\n");

        // Load data
        try {
            CSVHandler.loadFromCSV(predictor);
            System.out.println("Data loaded from market_data.csv\n");
        } catch (IOException e) {
            System.out.println("Error loading CSV file: " + e.getMessage());
            System.out.println("Starting with empty data.\n");
        }

        // Run the program
        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    predictYear();
                    break;
                case "2":
                    listKnownYears();
                    break;
                case "3":
                    running = false;
                    System.out.println("\nThank you for using the Housing Market Prediction System!");
                    break;
                default:
                    System.out.println("\nInvalid choice. Please try again.\n");
            }
        }

        scanner.close();
    }

    // default mentu to print
    private static void printMenu() {
        System.out.println("Main Menu:");
        System.out.println("1. Predict Future Year");
        System.out.println("2. List Known Years");
        System.out.println("3. Exit");
        System.out.print("\nEnter your choice: ");
    }

    // predict year function
    private static void predictYear() {
        System.out.println("\n=== Predict Future Year ===");

        if (predictor.getKnownYears().isEmpty()) {
            System.out.println("Error: No known years available. Please add at least one known year first.\n");
            return;
        }

        System.out.print("Enter target year to predict: ");
        int targetYear = Integer.parseInt(scanner.nextLine().trim());

        // Check if target year is in the past
        int maxKnownYear = Collections.max(predictor.getKnownYears().keySet());
        if (targetYear <= maxKnownYear) {
            System.out.println("Warning: Target year is not in the future. Predictions work best for future years.\n");
        }

        try {
            System.out.println("\nCalculating predictions...");
            MarketPredictor.PredictionResult result = predictor.predictYear(targetYear);

            // Display worst and best case scenarios
            System.out.println("\n=== Prediction Results for " + targetYear + " ===");
            System.out.println("\n--- Worst Case Scenario ---");
            System.out.println(result.getWorstCase().toString());
            System.out.println("\n--- Best Case Scenario ---");
            System.out.println(result.getBestCase().toString());

            // Calculate margin of error
            double avgPriceWorst = result.getWorstCase().getAveragePrice();
            double avgPriceBest = result.getBestCase().getAveragePrice();
            double avgPriceMid = (avgPriceWorst + avgPriceBest) / 2.0;
            double marginOfError = ((avgPriceBest - avgPriceWorst) / avgPriceMid) * 100.0;

            System.out.println("\n--- Summary ---");
            System.out.printf("Average Price Range: $%.2f - $%.2f\n", avgPriceWorst, avgPriceBest);
            System.out.printf("Mid-point Average Price: $%.2f\n", avgPriceMid);
            System.out.printf("Margin of Error: ±%.2f%%\n", marginOfError / 2.0);

            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();

        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage() + "\n");
        } catch (Exception e) {
            System.out.println("Error during prediction: " + e.getMessage());
            e.printStackTrace();
            System.out.println();
        }
    }

    private static void listKnownYears() {
        System.out.println("\n=== Known Years ===");

        Map<Integer, MarketYear> knownYears = predictor.getKnownYears();
        if (knownYears.isEmpty()) {
            System.out.println("No known years added yet.\n");
            return;
        }

        List<Integer> years = new ArrayList<>(knownYears.keySet());
        Collections.sort(years);

        for (Integer year : years) {
            System.out.println("\nYear " + year + ":");
            System.out.println(knownYears.get(year).toString());
        }
        System.out.println();
    }
}
