package vendingmachine;

/**
 * Hold the logic of getting coins
 */
public class CoinBale {

  static int[] userCoins = new int[7]; // initializes a list of user coins
  static int[] ownerCoins = new int[7]; // initializes a list of owner coins
  public int number2PoundCoins; // holds number of 2 Pound Coins
  public int number1PoundCoins; // holds number of 1 Pound Coins
  public int number50PenceCoins; // holds number of 50 Pence Coins
  public int number20PenceCoins; // holds number of 20 Pence Coins
  public int number10PenceCoins; // holds number of 10 Pence Coins
  public int number5PenceCoins; // holds number of 5 Pence Coins
  public int number1PenceCoins; // holds  number of 1 Pence Coins

  /**
   * CoinBale constructs the CoinBale object
   *
   * @param enteredCoins list of coins
   */
  public CoinBale(int... enteredCoins) {
    this.number2PoundCoins = enteredCoins[0];
    this.number1PoundCoins = enteredCoins[1];
    this.number50PenceCoins = enteredCoins[2];
    this.number20PenceCoins = enteredCoins[3];
    this.number10PenceCoins = enteredCoins[4];
    this.number5PenceCoins = enteredCoins[5];
    this.number1PenceCoins = enteredCoins[6];
  }

  /**
   * @return returns an aggregated amount of all available coins in Pounds
   */
  public double getTotal() {
    double total = 0.0;
    // convert 2pounds to pence
    total = total + this.number2PoundCoins * Coin.TWO_POUNDS.getValue() * 100;
    // convert 1pounds to pence
    total = total + this.number1PoundCoins * Coin.ONE_POUND.getValue() * 100;
    total = total + this.number50PenceCoins * Coin.FIFTY_PENCE.getValue();
    total = total + this.number20PenceCoins * Coin.TWENTY_PENCE.getValue();
    total = total + this.number10PenceCoins * Coin.TEN_PENCE.getValue();
    total = total + this.number5PenceCoins * Coin.FIVE_PENCE.getValue();
    total = total + this.number1PenceCoins * Coin.ONE_PENCE.getValue();
    // return the totals in pounds.
    return total / 100;
  }

  /**
   * @param coins coins string to be parded
   * @return a list of integers
   */
  public static int[] parseCoins(String coins) {
    String[] numberCoinsInText = coins.split(",");
    int[] result = new int[numberCoinsInText.length];
    for (int index = 0; index < numberCoinsInText.length; index++) {
      result[index] = Integer.parseInt(numberCoinsInText[index]);
    }
    return result;
  }

  /**
   * It returns coins for a user or an owner
   *
   * @param ownerCoins list of coins
   */
  static void displayCoins(int[] ownerCoins) {
    displayCoinsHeading();
    CoinBale coinBale = new CoinBale(ownerCoins);
    constructCoinsDetails(coinBale);
  }

  static void displayCoinsHeading() {
    System.out.printf("\n%-15s%-20s%-20s%-20s%-20s%-20s%-15s", "2 Pounds", "1 pound", "50 Pence",
        "20 Pence", "10 Pence", "5 Pence", "1 Pence");
  }

  static void constructCoinsDetails(CoinBale coinBale) {
    System.out.printf("\n%-15s%-20s%-20s%-20s%-20s%-20s%-15s", coinBale.number2PoundCoins,
        coinBale.number1PoundCoins, coinBale.number50PenceCoins, coinBale.number20PenceCoins,
        coinBale.number10PenceCoins, coinBale.number5PenceCoins, coinBale.number1PenceCoins);
  }

  public static void depositUserCoins(int[] coins) {
    userCoins = coins;
    displayCoins(coins);
  }

  public static int[] getUserCoins() {
    return userCoins;
  }

  public void showBalance() {
    int[] usc = getUserCoins();
    if (usc.length < 1) {
      System.out.println("\n Please deposit some coins");
      return;
    }
    displayCoins(usc);
  }


  public static void depositOwnerCoins(int[] coins) {
    ownerCoins = coins;
    displayCoins(coins);
  }

  public static int[] getOwnerCoins() {

    return ownerCoins;
  }

  void balanceUserAccounts(CoinBale coinBale) {
    userCoins = toIntArray(coinBale);
  }


  void balanceOwnerAccounts(CoinBale coinBale) {
    ownerCoins = toIntArray(coinBale);
  }

  /**
   * Converts a CoinBale to a list of integers
   *
   * @param coinBale the coin bale
   * @return array
   */
  int[] toIntArray(CoinBale coinBale) {
    int[] myArray = new int[7];

    myArray[0] = coinBale.number2PoundCoins;
    myArray[1] = coinBale.number1PoundCoins;
    myArray[2] = coinBale.number50PenceCoins;
    myArray[3] = coinBale.number20PenceCoins;
    myArray[4] = coinBale.number10PenceCoins;
    myArray[5] = coinBale.number5PenceCoins;
    myArray[6] = coinBale.number1PenceCoins;
    return myArray;
  }

  /**
   * Withdraws owner account and set the array to zero
   */
  public void withdrawOwnerCoins() {
    int[] ons = getOwnerCoins();
    if (ons.length < 1) {
      System.out.println("\n Please deposit some coins");
      return;
    }
    CoinBale j = new CoinBale(ons);
    if (j.getTotal() < 1) {
      System.out.println("\n Kindly add your coins, current balance is too low");
      return;
    }
    displayCoins(ons);
    ownerCoins = new int[0];
  }

  /**
   * Withdraws from user account and set the array to zero
   */
  public void withdrawUserCoins() {
    int[] usc = getUserCoins();
    if (usc.length < 1) {
      System.out.println("\n Please deposit some coins");
      return;
    }
    CoinBale j = new CoinBale(usc);
    if (j.getTotal() < 1) {
      System.out.println("\n Please deposit some coins");
      System.out.println("\n Kindly add your coins, current balance is too low");
      return;
    }
    displayCoins(usc);
    userCoins = new int[0];
  }

}
