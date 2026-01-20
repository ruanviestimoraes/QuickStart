package culminating;

import java.util.*;
import java.util.Random;

/**
 * Predicts future housing market years using linear regression and recursive
 * prediction.
 * Handles worst/best case scenarios using confidence intervals.
 */
public class MarketPredictor {
  private Map<Integer, MarketYear> knownYears;
  private static final double CONFIDENCE_INTERVAL = 1.5; // Standard deviations for worst/best cases
  private static final Random random = new Random();

  /**
   * Creates a new MarketPredictor.
   */
  public MarketPredictor() {
    this.knownYears = new HashMap<>();
  }

  /**
   * Adds a known year's market data.
   * 
   * @param year the year
   * @param data the market data
   */
  public void addKnownYear(int year, MarketYear data) {
    knownYears.put(year, data);
  }

  /**
   * Gets all known years.
   * 
   * @return map of years to market data
   */
  public Map<Integer, MarketYear> getKnownYears() {
    return new HashMap<>(knownYears);
  }

  /**
   * Checks if a year is known.
   * 
   * @param year the year to check
   * @return true if year is known
   */
  public boolean hasYear(int year) {
    return knownYears.containsKey(year);
  }

  /**
   * Returns worst and best case scenarios for target year.
   * 
   * @param targetYear the year to predict
   * @return prediction result with worst and best cases
   */
  public PredictionResult predictYear(int targetYear) {
    List<MarketYear> scenarios = predictYearRecursive(targetYear, new HashMap<>(knownYears));

    if (scenarios.isEmpty()) {
      throw new IllegalStateException("Cannot predict year " + targetYear + " - no known years available");
    }

    // Find worst and best case
    MarketYear worstCase = scenarios.get(0);
    MarketYear bestCase = scenarios.get(0);

    for (MarketYear scenario : scenarios) {
      if (scenario.getAveragePrice() < worstCase.getAveragePrice()) {
        worstCase = scenario;
      }
      if (scenario.getAveragePrice() > bestCase.getAveragePrice()) {
        bestCase = scenario;
      }
    }

    return new PredictionResult(worstCase, bestCase, scenarios);
  }

  /**
   * Recursive prediction that works backwards until finding known data.
   * 
   * @param targetYear the year to predict
   * @param known      map of known years
   * @return list of predicted scenarios
   */
  private List<MarketYear> predictYearRecursive(int targetYear, Map<Integer, MarketYear> known) {
    // Base case
    if (known.containsKey(targetYear)) {
      return Arrays.asList(new MarketYear(known.get(targetYear)));
    }

    // Predict previous year first
    int previousYear = targetYear - 1;
    List<MarketYear> previousScenarios = predictYearRecursive(previousYear, known);

    // Predict years based on all scenarios
    List<MarketYear> scenarios = new ArrayList<>();
    for (MarketYear prevScenario : previousScenarios) {
      MarketYear worstCase = predictNextYear(prevScenario, true);
      MarketYear bestCase = predictNextYear(prevScenario, false);
      scenarios.add(worstCase);
      scenarios.add(bestCase);
    }

    return scenarios;
  }

  /**
   * Predicts the next year from a given MarketYear.
   * 
   * @param current   the current year data
   * @param worstCase true for worst case, false for best case
   * @return predicted next year
   */
  private MarketYear predictNextYear(MarketYear current, boolean worstCase) {
    List<MarketYear> history = getHistoricalData();

    // Calculate trends for each field using linear regression
    double mortgageRateChange = calculateTrend(history, m -> m.getMortgageRate(), worstCase);
    double unemploymentChange = calculateTrend(history, m -> m.getUnemploymentRate(), worstCase);
    double gdpChange = calculateTrend(history, m -> m.getGdp(), worstCase);
    double inflationRateChange = calculateTrend(history, m -> m.getInflationRate(), worstCase);
    double avgPriceChange = calculateTrend(history, m -> m.getAveragePrice(), worstCase);
    double medianPriceChange = calculateTrend(history, m -> m.getMedianPrice(), worstCase);
    double salesChange = calculateTrend(history, m -> (double) m.getSales(), worstCase);
    double newListingsChange = calculateTrend(history, m -> (double) m.getNewListings(), worstCase);
    double domChange = calculateTrend(history, m -> m.getDom(), worstCase);

    // Generate new inflation rate: trend-based prediction + random adjustment
    double trendBasedInflation = current.getInflationRate() + inflationRateChange;
    double randomAdjustment = generateInflationAdjustment();
    double newInflationRate = trendBasedInflation + randomAdjustment;
    newInflationRate = Math.max(0, Math.min(6, newInflationRate));

    // So basically, here we using the worst case scenario boolean to predict the
    // next year's prices
    // and when it is true, we are madding more impact, when false, the impact is
    // less.
    double priceAdjustment = 1.0;
    double inflationImpact = newInflationRate / 100.0; // Convert percentage to decimal

    if (worstCase) {
      priceAdjustment -= (mortgageRateChange / 100.0) * 0.1; // 10% impact per 1% change
      priceAdjustment -= (unemploymentChange / 100.0) * 0.15; // 15% impact per 1% change
      priceAdjustment += inflationImpact * 0.8;
    } else {
      priceAdjustment += Math.abs(mortgageRateChange / 100.0) * 0.05;
      priceAdjustment += Math.abs(unemploymentChange / 100.0) * 0.05;
      priceAdjustment += inflationImpact * 1.2;
    }

    // Create predicted year with the adjusted values
    double newMortgageRate = current.getMortgageRate() + mortgageRateChange;
    double newUnemployment = current.getUnemploymentRate() + unemploymentChange;
    double newGdp = current.getGdp() * (1.0 + gdpChange / 100.0);
    double newAvgPrice = current.getAveragePrice() * (1.0 + avgPriceChange / 100.0) * priceAdjustment;
    double newMedianPrice = current.getMedianPrice() * (1.0 + medianPriceChange / 100.0) * priceAdjustment;
    int newSales = (int) (current.getSales() * (1.0 + salesChange / 100.0));
    int newNewListings = (int) (current.getNewListings() * (1.0 + newListingsChange / 100.0));
    double newDom = current.getDom() * (1.0 + domChange / 100.0);

    // Make sure it is not crazy values
    newMortgageRate = Math.max(0.1, Math.min(20.0, newMortgageRate));
    newUnemployment = Math.max(0.1, Math.min(30.0, newUnemployment));
    newGdp = Math.max(0, newGdp);
    // no need here, already done above
    newAvgPrice = Math.max(10000, newAvgPrice);
    newMedianPrice = Math.max(10000, newMedianPrice);
    newSales = Math.max(0, newSales);
    newNewListings = Math.max(0, newNewListings);
    newDom = Math.max(1, newDom);

    return new MarketYear(
        newMortgageRate, newUnemployment, newGdp, newInflationRate,
        newAvgPrice, newMedianPrice,
        newSales, newNewListings, newDom);
  }

  /**
   * Calculates trend using linear regression with confidence intervals.
   * 
   * @param history   list of historical market years
   * @param extractor function to extract value from MarketYear
   * @param worstCase true for worst case, false for best case
   * @return predicted change percentage
   */
  private double calculateTrend(List<MarketYear> history, java.util.function.Function<MarketYear, Double> extractor,
      boolean worstCase) {

    // First, we need to collect all the values we're gonna analyze
    // x is just the position (0, 1, 2, 3...) and y is the actual value from history
    int n = history.size();
    double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;

    List<Double> values = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      double x = i; // position in the list
      double y = extractor.apply(history.get(i)); // actual value (like price, rate, etc)
      values.add(y);
      // These sums are needed for the math formula
      sumX += x;
      sumY += y;
      sumXY += x * y;
      sumX2 += x * x;
    }

    // Now calculate the line that best fits our data (y = mx + b)
    // Slope tells us if things are going up or down over time
    double slope = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
    double intercept = (sumY - slope * sumX) / n;

    // Check how spread out our data is (standard deviation)
    // This helps us figure out worst/best case scenarios asd mainly doing radom
    double sumSquaredResiduals = 0;
    for (int i = 0; i < n; i++) {
      double predicted = slope * i + intercept; // what the line says it should be
      double residual = values.get(i) - predicted; // how far off we were
      sumSquaredResiduals += residual * residual;
    }
    double stdDev = Math.sqrt(sumSquaredResiduals / (n - 2));

    // The slope tells us how much things change per year
    double predictedChange = slope;

    // For worst case, go down from the trend. For best case, go up.
    // We use the spread (stdDev) to figure out how much to adjust
    double adjustment = worstCase ? -CONFIDENCE_INTERVAL * stdDev : CONFIDENCE_INTERVAL * stdDev;

    // For percentage stuff (like rates), convert to percentage change
    // Otherwise just return the raw change
    double avgValue = sumY / n;
    if (avgValue != 0) {
      return (predictedChange + adjustment) / avgValue * 100.0;
    }

    return predictedChange + adjustment;
  }

  /**
   * Gets historical data sorted by year.
   * 
   * @return sorted list of market years
   */
  private List<MarketYear> getHistoricalData() {
    List<Integer> years = new ArrayList<>(knownYears.keySet());
    Collections.sort(years);

    List<MarketYear> history = new ArrayList<>();
    for (Integer year : years) {
      history.add(knownYears.get(year));
    }
    return history;
  }

  /**
   * Generates a random inflation adjustment.
   * 
   * @return adjustment value
   */
  private double generateInflationAdjustment() {
    double meanAdjustment = 0.25;
    double stdDev = 0.3;
    return meanAdjustment + random.nextGaussian() * stdDev;
  }

  /**
   * Result class containing worst case, best case, and all scenarios.
   */
  public static class PredictionResult {
    private final MarketYear worstCase;
    private final MarketYear bestCase;
    private final List<MarketYear> allScenarios;

    /**
     * Creates a prediction result with all scenarios.
     * 
     * @param worstCase    worst case scenario
     * @param bestCase     best case scenario
     * @param allScenarios all predicted scenarios
     */
    public PredictionResult(MarketYear worstCase, MarketYear bestCase, List<MarketYear> allScenarios) {
      this.worstCase = worstCase;
      this.bestCase = bestCase;
      this.allScenarios = allScenarios;
    }

    /**
     * Creates a prediction result with worst and best cases.
     * 
     * @param worstCase worst case scenario
     * @param bestCase  best case scenario
     */
    public PredictionResult(MarketYear worstCase, MarketYear bestCase) {
      this.worstCase = worstCase;
      this.bestCase = bestCase;
      this.allScenarios = new ArrayList<>();
    }

    /**
     * Creates a prediction result with single scenario.
     * 
     * @param worstCase the scenario
     */
    public PredictionResult(MarketYear worstCase) {
      this.worstCase = worstCase;
      this.bestCase = worstCase;
      this.allScenarios = new ArrayList<>();
    }

    /**
     * Creates an empty prediction result.
     */
    public PredictionResult() {
      this.worstCase = new MarketYear();
      this.bestCase = new MarketYear();
      this.allScenarios = new ArrayList<>();
    }

    /**
     * Gets the worst case scenario.
     * 
     * @return worst case market year
     */
    public MarketYear getWorstCase() {
      return worstCase;
    }

    /**
     * Gets the best case scenario.
     * 
     * @return best case market year
     */
    public MarketYear getBestCase() {
      return bestCase;
    }

    /**
     * Gets all predicted scenarios.
     * 
     * @return list of all scenarios
     */
    public List<MarketYear> getAllScenarios() {
      return allScenarios;
    }
  }
}
