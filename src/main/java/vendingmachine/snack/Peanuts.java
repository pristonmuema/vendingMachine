package vendingmachine.snack;

import vendingmachine.Snack;

public class Peanuts extends Snack {

  int quantity;

  public int getQuantity() {
    return quantity;
  }

  @Override
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  /**
   * @return the name
   */
  @Override
  public String name() {
    return "Peanuts";
  }

  /**
   * @return the code
   */
  @Override
  public String code() {
    return "1002";
  }

  /**
   * @return the price
   */
  @Override
  public double price() {
    return 1.50;
  }

  @Override
  public int quantity() {
    return getQuantity();
  }
}
