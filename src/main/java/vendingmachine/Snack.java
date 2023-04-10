package vendingmachine;

/**
 * Snack class holds all abstracted fields to construct Snack items
 */
public abstract class Snack implements Item {

  /**
   * @return holds the name of the snack
   */
  @Override
  public abstract String name();

  /**
   * @return holds the code of the snack
   */
  @Override
  public abstract String code();

  /**
   * @return holds the price of snack
   */
  @Override
  public abstract double price();

  /**
   * @return holds the quantity of the snack
   */
  @Override
  public abstract int quantity();
}
