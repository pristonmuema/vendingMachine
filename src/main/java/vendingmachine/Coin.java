package vendingmachine;

/**
 * Enum of coins available and their values
 */
public enum Coin {
  TWO_POUNDS(2), ONE_POUND(1), FIFTY_PENCE(50),
  TWENTY_PENCE(20), TEN_PENCE(10), FIVE_PENCE(5), ONE_PENCE(1);

  private final int value;

  /**
   * @param value value of the coin type
   */
  Coin(int value) {
    this.value = value;
  }

  /**
   * @return returns the value of the coin
   */
  public int getValue() {
    return value;
  }
}
