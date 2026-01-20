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
   * Creates a MarketYear with all fields.
   * 
   * @param mortgageRate     mortgage rate
   * @param unemploymentRate unemployment rate
   * @param gdp              GDP in trillions
   * @param inflationRate    inflation rate
   * @param averagePrice     average price
   * @param medianPrice      median price
   * @param sales            sales count
   * @param newListings      new listings count
   * @param dom              days on market
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

  /**
   * Creates a MarketYear without DOM.
   */
  public MarketYear(double mortgageRate, double unemploymentRate, double gdp,
      double inflationRate, double averagePrice, double medianPrice,
      int sales, int newListings) {
    this(mortgageRate, unemploymentRate, gdp, inflationRate, averagePrice, medianPrice, sales, newListings, 0);
  }

  /**
   * Creates a MarketYear without listings and DOM.
   */
  public MarketYear(double mortgageRate, double unemploymentRate, double gdp,
      double inflationRate, double averagePrice, double medianPrice,
      int sales) {
    this(mortgageRate, unemploymentRate, gdp, inflationRate, averagePrice, medianPrice, sales, 0, 0);
  }

  /**
   * Creates a MarketYear with basic price data.
   */
  public MarketYear(double mortgageRate, double unemploymentRate, double gdp,
      double inflationRate, double averagePrice, double medianPrice) {
    this(mortgageRate, unemploymentRate, gdp, inflationRate, averagePrice, medianPrice, 0, 0, 0);
  }

  /**
   * Creates a MarketYear with average price only.
   */
  public MarketYear(double mortgageRate, double unemploymentRate, double gdp,
      double inflationRate, double averagePrice) {
    this(mortgageRate, unemploymentRate, gdp, inflationRate, averagePrice, 0, 0, 0);
  }

  /**
   * Creates a MarketYear with economic indicators only.
   */
  public MarketYear(double mortgageRate, double unemploymentRate, double gdp,
      double inflationRate) {
    this(mortgageRate, unemploymentRate, gdp, inflationRate, 0, 0, 0, 0, 0);
  }

  /**
   * Creates a MarketYear with basic economic data.
   */
  public MarketYear(double mortgageRate, double unemploymentRate, double gdp) {
    this(mortgageRate, unemploymentRate, gdp, 0, 0, 0, 0, 0, 0);
  }

  /**
   * Creates a MarketYear with rates only.
   */
  public MarketYear(double mortgageRate, double unemploymentRate) {
    this(mortgageRate, unemploymentRate, 0, 0, 0, 0, 0, 0, 0);
  }

  /**
   * Creates a MarketYear with mortgage rate only.
   */
  public MarketYear(double mortgageRate) {
    this(mortgageRate, 0, 0, 0, 0, 0, 0, 0, 0);
  }

  /**
   * Creates an empty MarketYear.
   */
  public MarketYear() {
    this(0, 0, 0, 0, 0, 0, 0, 0, 0);
  }

  /**
   * Copy constructor.
   * 
   * @param other the MarketYear to copy
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

  /**
   * Gets mortgage rate.
   * 
   * @return mortgage rate
   */
  public double getMortgageRate() {
    return mortgageRate;
  }

  /**
   * Gets unemployment rate.
   * 
   * @return unemployment rate
   */
  public double getUnemploymentRate() {
    return unemploymentRate;
  }

  /**
   * Gets GDP.
   * 
   * @return GDP in trillions
   */
  public double getGdp() {
    return gdp;
  }

  /**
   * Gets inflation rate.
   * 
   * @return inflation rate
   */
  public double getInflationRate() {
    return inflationRate;
  }

  /**
   * Gets average price.
   * 
   * @return average price
   */
  public double getAveragePrice() {
    return averagePrice;
  }

  /**
   * Gets median price.
   * 
   * @return median price
   */
  public double getMedianPrice() {
    return medianPrice;
  }

  /**
   * Gets sales count.
   * 
   * @return sales count
   */
  public int getSales() {
    return sales;
  }

  /**
   * Gets new listings count.
   * 
   * @return new listings count
   */
  public int getNewListings() {
    return newListings;
  }

  /**
   * Gets days on market.
   * 
   * @return days on market
   */
  public double getDom() {
    return dom;
  }

  /**
   * Sets mortgage rate.
   * 
   * @param mortgageRate mortgage rate
   */
  public void setMortgageRate(double mortgageRate) {
    this.mortgageRate = mortgageRate;
  }

  /**
   * Sets unemployment rate.
   * 
   * @param unemploymentRate unemployment rate
   */
  public void setUnemploymentRate(double unemploymentRate) {
    this.unemploymentRate = unemploymentRate;
  }

  /**
   * Sets GDP.
   * 
   * @param gdp GDP in trillions
   */
  public void setGdp(double gdp) {
    this.gdp = gdp;
  }

  /**
   * Sets inflation rate.
   * 
   * @param inflationRate inflation rate
   */
  public void setInflationRate(double inflationRate) {
    this.inflationRate = inflationRate;
  }

  /**
   * Sets average price.
   * 
   * @param averagePrice average price
   */
  public void setAveragePrice(double averagePrice) {
    this.averagePrice = averagePrice;
  }

  /**
   * Sets median price.
   * 
   * @param medianPrice median price
   */
  public void setMedianPrice(double medianPrice) {
    this.medianPrice = medianPrice;
  }

  /**
   * Sets sales count.
   * 
   * @param sales sales count
   */
  public void setSales(int sales) {
    this.sales = sales;
  }

  /**
   * Sets new listings count.
   * 
   * @param newListings new listings count
   */
  public void setNewListings(int newListings) {
    this.newListings = newListings;
  }

  /**
   * Sets days on market.
   * 
   * @param dom days on market
   */
  public void setDom(double dom) {
    this.dom = dom;
  }

  /**
   * Returns string representation of MarketYear.
   * 
   * @return formatted string
   */
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
