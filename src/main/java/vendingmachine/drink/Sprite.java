package vendingmachine.drink;

import vendingmachine.Drink;

public class Sprite extends Drink {

  int quantity;

  public int getQuantity() {
    return quantity;
  }

  @Override
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  @Override
  public String code() {
    return "0002";
  }

  @Override
  public String name() {
    return "Sprite";
  }

  /**
   * @return the price
   */
  @Override
  public double price() {
    return 2.00;
  }

  @Override
  public int quantity() {
    return getQuantity();
  }
}
