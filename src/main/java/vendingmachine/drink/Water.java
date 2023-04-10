package vendingmachine.drink;

import vendingmachine.Drink;

public class Water extends Drink {

  int quantity; // holds the quantity

  public int getQuantity() {
    return quantity;
  }

  @Override
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  @Override
  public String code() {
    return "0003";
  }

  /**
   * @return the name
   */
  @Override
  public String name() {
    return "Water";
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
