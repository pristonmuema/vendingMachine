package vendingmachine.drink;

import vendingmachine.Drink;

public class Lemonade extends Drink {

  int quantity; // the quantity

  public int getQuantity() {
    return quantity;
  }

  /**
   * @param quantity sets the quantity
   */
  @Override
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  @Override
  public String code() {
    return "0004";
  }

  @Override
  public String name() {
    return "Lemonade";
  }

  /**
   * @return the price
   */

  @Override
  public double price() {
    return 1.75;
  }

  @Override
  public int quantity() {
    return getQuantity();
  }
}
