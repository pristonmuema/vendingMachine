package vendingmachine;

public interface Calculator {

  /**
   * @param coinBale the bale (a batch of coin type)
   * @return an aggregated amount of all coins
   */
  double calculateTotal(CoinBale coinBale);

  /**
   * @param toChange the amount to translate
   * @return CoinBale with each coin type
   */
  CoinBale calculateChange(int toChange);
}
