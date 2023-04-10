package vendingmachine;

/**
 * IOwnerVendingMachine holds all methods needed to create OwnerVendingMachine API
 */
public interface IOwnerVendingMachine {

  /**
   * Owner withdraws coins
   */
  public void withdrawCoins();

  /**
   * Owner deposits coins
   *
   * @param coins the coins
   */
  public void insertCoins(int[] coins);

  /**
   * Owner adds an item to the machine
   *
   * @param item     the specific item to add
   * @param quantity the number of items to add
   */
  public void addItems(Item item, int quantity);

  /**
   * Owner tops up the stock to capacity
   */
  public void addStock();

  /**
   * @param code the code of the item to check its availability
   */
  void checkStock(String code);

  /**
   * Owner check all items
   */
  void checkStock();
}
