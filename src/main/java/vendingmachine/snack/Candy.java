package vendingmachine.snack;

import vendingmachine.Snack;

public class Candy extends Snack {

  int quantity; // holds the quantity

  public int getQuantity() {
    return quantity;
  }

  /**
   * @param quantity sets quantity
   */

  @Override
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  /**
   * @return the name
   */

  @Override
  public String name() {
    return "Candy";
  }

  @Override
  public String code() {
    return "1004";
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
