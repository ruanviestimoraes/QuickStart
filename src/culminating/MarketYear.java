package culminating;

/**
 * Represents housing market data for a specific year.
 */
public class MarketYear {
  private double mortgageRate;
  private double unemploymentRate;
  private double gdp; // in trillions
  private double inflationRate; // in percentage
  private double averagePrice;
  private double medianPrice;
  private int sales;
  private int newListings;
  private double dom; // in days

  /**
   * Constructor for MarketYear
   */
  public MarketYear(double mortgageRate, double unemploymentRate, double gdp,
      double inflationRate, double averagePrice, double medianPrice,
      int sales, int newListings, double dom) {
    this.mortgageRate = mortgageRate;
    this.unemploymentRate = unemploymentRate;
    this.gdp = gdp;
    this.inflationRate = inflationRate;
    this.averagePrice = averagePrice;
    this.medianPrice = medianPrice;
    this.sales = sales;
    this.newListings = newListings;
    this.dom = dom;
  }

  public MarketYear(double mortgageRate, double unemploymentRate, double gdp,
      double inflationRate, double averagePrice, double medianPrice,
      int sales, int newListings) {
    this(mortgageRate, unemploymentRate, gdp, inflationRate, averagePrice, medianPrice, sales, newListings, 0);
  }

  public MarketYear(double mortgageRate, double unemploymentRate, double gdp,
      double inflationRate, double averagePrice, double medianPrice,
      int sales) {
    this(mortgageRate, unemploymentRate, gdp, inflationRate, averagePrice, medianPrice, sales, 0, 0);
  }

  public MarketYear(double mortgageRate, double unemploymentRate, double gdp,
      double inflationRate, double averagePrice, double medianPrice) {
    this(mortgageRate, unemploymentRate, gdp, inflationRate, averagePrice, medianPrice, 0, 0, 0);
  }

  public MarketYear(double mortgageRate, double unemploymentRate, double gdp,
      double inflationRate, double averagePrice) {
    this(mortgageRate, unemploymentRate, gdp, inflationRate, averagePrice, 0, 0, 0);
  }

  public MarketYear(double mortgageRate, double unemploymentRate, double gdp,
      double inflationRate) {
    this(mortgageRate, unemploymentRate, gdp, inflationRate, 0, 0, 0, 0, 0);
  }

  public MarketYear(double mortgageRate, double unemploymentRate, double gdp) {
    this(mortgageRate, unemploymentRate, gdp, 0, 0, 0, 0, 0, 0);
  }

  public MarketYear(double mortgageRate, double unemploymentRate) {
    this(mortgageRate, unemploymentRate, 0, 0, 0, 0, 0, 0, 0);
  }

  public MarketYear(double mortgageRate) {
    this(mortgageRate, 0, 0, 0, 0, 0, 0, 0, 0);
  }

  public MarketYear() {
    this(0, 0, 0, 0, 0, 0, 0, 0, 0);
  }

  /**
   * Copy constructor
   */
  public MarketYear(MarketYear other) {
    this.mortgageRate = other.mortgageRate;
    this.unemploymentRate = other.unemploymentRate;
    this.gdp = other.gdp;
    this.inflationRate = other.inflationRate;
    this.averagePrice = other.averagePrice;
    this.medianPrice = other.medianPrice;
    this.sales = other.sales;
    this.newListings = other.newListings;
    this.dom = other.dom;
  }

  // Getters
  public double getMortgageRate() {
    return mortgageRate;
  }

  public double getUnemploymentRate() {
    return unemploymentRate;
  }

  public double getGdp() {
    return gdp;
  }

  public double getInflationRate() {
    return inflationRate;
  }

  public double getAveragePrice() {
    return averagePrice;
  }

  public double getMedianPrice() {
    return medianPrice;
  }

  public int getSales() {
    return sales;
  }

  public int getNewListings() {
    return newListings;
  }

  public double getDom() {
    return dom;
  }

  // Setters
  public void setMortgageRate(double mortgageRate) {
    this.mortgageRate = mortgageRate;
  }

  public void setUnemploymentRate(double unemploymentRate) {
    this.unemploymentRate = unemploymentRate;
  }

  public void setGdp(double gdp) {
    this.gdp = gdp;
  }

  public void setInflationRate(double inflationRate) {
    this.inflationRate = inflationRate;
  }

  public void setAveragePrice(double averagePrice) {
    this.averagePrice = averagePrice;
  }

  public void setMedianPrice(double medianPrice) {
    this.medianPrice = medianPrice;
  }

  public void setSales(int sales) {
    this.sales = sales;
  }

  public void setNewListings(int newListings) {
    this.newListings = newListings;
  }

  public void setDom(double dom) {
    this.dom = dom;
  }

  @Override
  public String toString() {
    return String.format(
        "MarketYear{MortgageRate=%.2f%%, UnemploymentRate=%.2f%%, GDP=%.2fT, " +
            "InflationRate=%.2f%%, AveragePrice=$%.2f, MedianPrice=$%.2f, " +
            "Sales=%d, NewListings=%d, DOM=%.1f}",
        mortgageRate, unemploymentRate, gdp, inflationRate, averagePrice, medianPrice,
        sales, newListings, dom);
  }
}
