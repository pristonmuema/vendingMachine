package vendingmachine.snack;

import vendingmachine.Snack;

public class Crisps extends Snack {

  int quantity; // holds the quantity

  public int getQuantity() {
    return quantity;
  }

  @Override
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  @Override
  public String name() {
    return "Crisps";
  }

  /**
   * @return the code
   */
  @Override
  public String code() {
    return "1001";
  }

  /**
   * @return the price
   */
  @Override
  public double price() {
    return 1.50;
  }

  /**
   * @return the quantity
   */

  @Override
  public int quantity() {
    return getQuantity();
  }
}
