package culminating;

import java.io.*;

public class CSVHandler {
    private static final String CSV_FILE = "market_data.csv";

    /**
     * Loads market data from CSV file
     *
     * @param predictor The MarketPredictor to populate with data
     * @param filename  The name of the CSV file to load
     * @throws IOException if there's an error reading the file
     */
    public static void loadFromCSV(MarketPredictor predictor, String filename) throws IOException {
        File file = new File(filename);
        if (!file.exists()) {
            throw new IOException("CSV file not found: " + filename);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            // INTENTIONLLAY SKIP HEADER
            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }

                String[] values = line.split(",");

                try {
                    int year = Integer.parseInt(values[0].trim());
                    double mortgageRate = Double.parseDouble(values[1].trim());
                    double unemploymentRate = Double.parseDouble(values[2].trim());
                    double gdp = Double.parseDouble(values[3].trim());
                    double inflationRate = Double.parseDouble(values[4].trim());
                    double averagePrice = Double.parseDouble(values[5].trim());
                    double medianPrice = Double.parseDouble(values[6].trim());
                    int sales = Integer.parseInt(values[7].trim());
                    int newListings = Integer.parseInt(values[8].trim());
                    double dom = Double.parseDouble(values[9].trim());

                    MarketYear marketYear = new MarketYear(
                            mortgageRate, unemploymentRate, gdp, inflationRate,
                            averagePrice, medianPrice,
                            sales, newListings, dom);

                    predictor.addKnownYear(year, marketYear);
                } catch (NumberFormatException e) {
                    throw new IOException("Invalid number format: " + e.getMessage());
                }
            }
        }
    }

    /**
     * Loads market data from CSV file into the predictor.
     * Default filename is "market_data.csv".
     *
     * @param predictor The MarketPredictor to populate with data
     * @throws IOException if there's an error reading the file
     */
    public static void loadFromCSV(MarketPredictor predictor) throws IOException {
        loadFromCSV(predictor, CSV_FILE);
    }
}
