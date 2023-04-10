package vendingmachine.drink;

import vendingmachine.Drink;

public class Coke extends Drink {

  int quantity; // it will hold yhe quantity of code available

  /**
   * @return the quantity of coke
   */
  public int getQuantity() {
    return quantity;
  }


  @Override
  public String code() {
    return "0001";
  }

  @Override
  public String name() {
    return "Coke";
  }

  /**
   * @return price coke
   */
  @Override
  public double price() {
    return 2.00;
  }

  @Override
  public int quantity() {
    return getQuantity();
  }

  /**
   * @param quantity sets the quantity
   */
  @Override
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

}
