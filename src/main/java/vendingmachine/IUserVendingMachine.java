package vendingmachine;

import java.io.IOException;

/**
 * IUserVendingMachine holds all methods needed to create UserVendingMachine
 */
public interface IUserVendingMachine {

  /**
   * User displays all available items
   */
  void displayItems();

  /**
   * The user deposits coins
   *
   * @param coins the coins to deposit
   */
  void depositCoins(int[] coins);

  /**
   * User buys an item or a list of items
   *
   * @throws IOException the exception
   */
  void buyItem() throws IOException;

  /**
   * User withdraws money
   */
  void withdrawMoney();

  /**
   * User check balance
   */
  void viewBalance();

}
