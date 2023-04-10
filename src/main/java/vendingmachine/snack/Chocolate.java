package vendingmachine.snack;

import vendingmachine.Snack;

public class Chocolate extends Snack {

  int quantity; // holds the quantity

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
    return "Chocolate";
  }

  /**
   * @return the code
   */
  @Override
  public String code() {
    return "1003";
  }

  /**
   * @return the price
   */

  @Override
  public double price() {
    return 2.50;
  }

  @Override
  public int quantity() {
    return getQuantity();
  }
}
