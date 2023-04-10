package vendingmachine;

import java.io.IOException;
import java.util.Scanner;
import vendingmachine.drink.Coke;
import vendingmachine.drink.Lemonade;
import vendingmachine.drink.Sprite;
import vendingmachine.drink.Water;
import vendingmachine.snack.Candy;
import vendingmachine.snack.Chocolate;
import vendingmachine.snack.Crisps;
import vendingmachine.snack.Peanuts;

public class OrderBuilder {

  static Scanner sc = new Scanner(System.in);
  public static final int COKE = 0001;
  public static final int SPRITE = 0002;
  public static final int WATER = 0003;
  public static final int LEMONADE = 0004;
  public static final int CRISPS = 1001;
  public static final int PEANUTS = 1002;
  public static final int CHOCOLATE = 1003;
  public static final int CANDY = 1004;

  public static final int BACK = 5;
  Repository repository = new Repository(); // initializes repository

  Calculator calculator = new MyCalculator(); // initializes Calculator

  /**
   * makes the purchase
   *
   * @throws IOException the exception
   */
  public void makePurchase() throws IOException {
    prepareOrder();
  }

  /**
   * prepares the order
   *
   * @throws IOException the exception
   */
  void prepareOrder() throws IOException {
    int choice = getItemMenu();
    while (choice != 0) {
      switch (choice) {
        case 1:
          handleDrinks(); // handles drink items
          break;
        case 2:
          handleSnacks(); // handles snack items
          break;
        case 3:
          printReceipts(); // prints receipt for the items bought
          break;
        case 4:
          makePayment(); // makes and settles payments
          break;
        case 5:
          cancelPurchase(); // cancels an already purchased item(s) and settles the accounts
          break;
        case 6:
          getBackToBuyer(); // navigates back to the buyer menu
          break;
        default:
          System.out.println("\n Error, choice not recognised");
      }
      choice = getItemMenu();
    }
  }

  /**
   * gets a drink or drinks you are interested in and adds them to a list
   *
   * @throws IOException the exception
   */
  void handleDrinks() throws IOException {
    int choice = getDrinksMenu();
    while (choice != 0) {
      switch (choice) {
        case COKE:
          repository.addOrderedItems(new Coke());
          break;
        case SPRITE:
          repository.addOrderedItems(new Sprite());
          break;
        case WATER:
          repository.addOrderedItems(new Water());
          break;
        case LEMONADE:
          repository.addOrderedItems(new Lemonade());
          break;
        case BACK:
          getBackToItemMenu();
          break;
        default:
      }
      choice = getDrinksMenu();
    }

  }

  /**
   * gets a snack or snacks you are interested in and adds them to a list
   *
   * @throws IOException the exception
   */
  void handleSnacks() throws IOException {
    int choice = getSnacksMenu();
    while (choice != 0) {
      switch (choice) {
        case CRISPS:
          repository.addOrderedItems(new Crisps());
          break;
        case PEANUTS:
          repository.addOrderedItems(new Peanuts());
          break;
        case CHOCOLATE:
          repository.addOrderedItems(new Chocolate());
          break;
        case CANDY:
          repository.addOrderedItems(new Candy());
          break;
        case BACK:
          getBackToItemMenu();
          break;
        default:
      }
      choice = getSnacksMenu();
    }
  }

  /**
   * prints the receipts
   */
  void printReceipts() {
    repository.showOrderedItems();
  }

  /**
   * makePayment Checks the available amount from the user account, if the user current amount is
   * less than 1 returns an error. Gets the total cost of goods to buy, if the total cost of goods
   * is 0.0 returns an error. If the cost of goods is greater than user current amounts returns an
   * error.
   * <p>
   * On successful  purchase we add cost of goods value to the owner account, and deduct the same
   * amount from the user account.
   */
  void makePayment() {
    CoinBale coinBale = new CoinBale(CoinBale.getUserCoins());
    double userCurrentAmount = calculator.calculateTotal(coinBale);
    if (userCurrentAmount < 1) {
      System.out.println("Ensure you have some coins to do the purchase");
      return;
    }
    double costOfGoods = repository.getOrderedCost();
    if (costOfGoods == 0.0) {
      System.out.println("Ensure you pick at least one item");
      return;
    }
    if (costOfGoods > userCurrentAmount) {
      System.out.println("Ensure you have enough amount to make the purchase");
      return;
    }

    double balanceInPounds = userCurrentAmount - costOfGoods;

    // balance owner Accounts
    CoinBale ownerBale = new CoinBale(CoinBale.getOwnerCoins());
    double ownerCurrentAmount = calculator.calculateTotal(ownerBale);
    double ownerTakeInPounds = ownerCurrentAmount + costOfGoods;
    ownerBale.balanceOwnerAccounts(calculator.calculateChange((int) ownerTakeInPounds));

    CoinBale bl = calculator.calculateChange((int) balanceInPounds);
    coinBale.balanceUserAccounts(bl);
    CoinBale.displayCoinsHeading();
    CoinBale.constructCoinsDetails(bl);

  }

  /**
   * cancelPurchase Checks the value of the goods bought, if is zero return an error, otherwise we
   * add cost of goods value to the user account, and deduct the same amount from the owner
   * account.
   */
  void cancelPurchase() {
    double costOfGoods = repository.getOrderedCost();
    if (costOfGoods == 0.0) {
      System.out.println("Ensure you pick at least one item");
      return;
    }
    CoinBale ownerBale = new CoinBale(CoinBale.getOwnerCoins());
    double ownerCurrentAmount = calculator.calculateTotal(ownerBale);
    double ownerTakeInPounds = ownerCurrentAmount - costOfGoods;
    ownerBale.balanceOwnerAccounts(calculator.calculateChange((int) ownerTakeInPounds));

    CoinBale userBale = new CoinBale(CoinBale.getUserCoins());
    double userCurrentAmount = calculator.calculateTotal(userBale);
    double userTakeInPounds = userCurrentAmount + costOfGoods;
    userBale.balanceUserAccounts(calculator.calculateChange((int) userTakeInPounds));
    CoinBale.displayCoinsHeading();
    CoinBale.constructCoinsDetails(userBale);
  }

  void getBackToBuyer() throws IOException {
    SystemUser user = new SystemUser();
    user.handleBuyer();
  }

  void getBackToItemMenu() throws IOException {
    prepareOrder();
  }

  private int getDrinksMenu() {
    System.out.println(" \n Please select the code from the following");
    System.out.println("========================");
    System.out.println(" 0001. COKE   ");
    System.out.println(" 0002. SPRITE  ");
    System.out.println(" 0003. WATER   ");
    System.out.println(" 0004. LEMONADE  ");
    System.out.println(" 0005. BACK");
    System.out.println("========================");
    System.out.print("Enter the code ==> ");
    return sc.nextInt();
  }

  private int getSnacksMenu() {
    System.out.println(" \n Please select the code from the following");
    System.out.println("========================");
    System.out.println(" 1001. CRISPS   ");
    System.out.println(" 1002. PEANUTS  ");
    System.out.println(" 1003. CHOCOLATE   ");
    System.out.println(" 1004. CANDY  ");
    System.out.println(" 0005. BACK");
    System.out.println("========================");
    System.out.print("Enter choice==> ");
    return sc.nextInt();
  }

  private int getItemMenu() {
    System.out.println(" \n Enter the choice of Item");
    System.out.println("========================");
    System.out.println("     1. Drink   ");
    System.out.println("     2. Snacks  ");
    System.out.println("     3. Receipts ");
    System.out.println("     4. Make Payment");
    System.out.println("     5. Cancel Purchase  ");
    System.out.println("     6. Exit        ");
    System.out.println("========================");
    System.out.print("Enter choice==> ");
    return sc.nextInt();
  }
}
