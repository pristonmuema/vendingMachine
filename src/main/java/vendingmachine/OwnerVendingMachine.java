package vendingmachine;


/**
 * OwnerVendingMachine implements IOwnerVendingMachine interface
 */
public class OwnerVendingMachine implements IOwnerVendingMachine {

  Repository repository = new Repository();
  CoinBale coinBale = new CoinBale(new int[7]);

  @Override
  public void withdrawCoins() {
    coinBale.withdrawOwnerCoins();
  }

  @Override
  public void insertCoins(int[] coins) {
    CoinBale.depositOwnerCoins(coins);
  }

  @Override
  public void addItems(Item item, int quantity) {
    Item storedItem = repository.getItemItem(item.code());
    int currentQuantity = storedItem.quantity();
    int total = currentQuantity + quantity;
    if (total > 5) {
      System.out.printf(" \n Total number of stock must be 5 and below, total in stock is : %d",
          currentQuantity);
      return;
    }

    repository.addItems(storedItem, total);
    System.out.printf(" \n Stock successfully updated : %d",
        total);
  }

  @Override
  public void addStock() {
    repository.stockAllItems();
    System.out.printf(" \n Stock successfully added");
  }

  @Override
  public void checkStock(String code) {
    repository.getItem(code);
  }

  @Override
  public void checkStock() {
    repository.showCurrentStock();
  }


}
