package vendingmachine;

import java.io.IOException;

/**
 * Implements IUserVendingMachine interface
 */
public class UserVendingMachine implements IUserVendingMachine {

  Repository repository = new Repository(); // initialises Repository
  CoinBale coinBale = new CoinBale(new int[7]);  // initialises CoinBale

  @Override
  public void displayItems() {
    repository.showAllItems();
  }

  @Override
  public void depositCoins(int[] coins) {
    CoinBale.depositUserCoins(coins);
  }

  @Override
  public void buyItem() throws IOException {
    OrderBuilder orderBuilder = new OrderBuilder();
    orderBuilder.makePurchase();
  }


  @Override
  public void withdrawMoney() {
    coinBale.withdrawUserCoins();
  }

  @Override
  public void viewBalance() {
    coinBale.showBalance();
  }

}
