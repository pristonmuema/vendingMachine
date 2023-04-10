package vendingmachine;

/**
 * MyCalculator implements Calculator interface
 */
public class MyCalculator implements Calculator {

  CoinBale change = new CoinBale(new int[7]); // initializes the CoinBale

  /**
   * calculates and returns the total value of the coins in pounds
   *
   * @param coinBale the bale (a batch of coin type)
   * @return total
   */
  @Override
  public double calculateTotal(CoinBale coinBale) {
    return coinBale.getTotal();
  }

  /**
   * Translates totals  or an amount in pounds to CoinBale
   *
   * @param toChange the amount to translate
   * @return CoinBale
   */
  @Override
  public CoinBale calculateChange(int toChange) {

    int remainingAmount = toChange;
    change.number2PoundCoins = remainingAmount / Coin.TWO_POUNDS.getValue();
    remainingAmount = remainingAmount % Coin.TWO_POUNDS.getValue();

    change.number1PoundCoins = remainingAmount / Coin.ONE_POUND.getValue();
    remainingAmount = remainingAmount % Coin.ONE_POUND.getValue();

    change.number50PenceCoins = remainingAmount * 100 / Coin.FIFTY_PENCE.getValue();
    remainingAmount = remainingAmount * 100 % Coin.FIFTY_PENCE.getValue();

    change.number20PenceCoins = remainingAmount / Coin.TWENTY_PENCE.getValue();
    remainingAmount = remainingAmount % Coin.TWENTY_PENCE.getValue();

    change.number10PenceCoins = remainingAmount / Coin.TEN_PENCE.getValue();
    remainingAmount = remainingAmount % Coin.TEN_PENCE.getValue();

    change.number5PenceCoins = remainingAmount / Coin.FIVE_PENCE.getValue();
    remainingAmount = remainingAmount % Coin.FIVE_PENCE.getValue();

    change.number1PenceCoins = remainingAmount / Coin.ONE_PENCE.getValue();

    return change;
  }


}
