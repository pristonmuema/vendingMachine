package vendingmachine;

/**
 * Drink class holds all abstracted attributes to create all drink items
 */
public abstract class Drink implements Item {

  /**
   * @return holds the name of the drink
   */
  @Override
  public abstract String name();

  /**
   * @return holds the code of the drink
   */
  @Override
  public abstract String code();

  /**
   * @return holds the price of drink
   */
  @Override
  public abstract double price();

  /**
   * @return holds the quantity of the drink
   */
  @Override
  public abstract int quantity();
}
