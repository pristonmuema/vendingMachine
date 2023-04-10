package vendingmachine;

import java.io.IOException;
import java.util.Scanner;
import vendingmachine.drink.Coke;

/**
 * Acts as the main engine to the vending machine
 */
public class SystemUser {

  public static final int EXIT = 0; // it holds the exit option
  public static final int BACK = 98; // it holds the back option
  public static final int OWNER = 1; // it holds the owner type option
  public static final int BUYER = 2; // it holds the buyer type option

  public static final int INSERT_COINS = 1; // it holds the owner's insert option
  public static final int WITHDRAW = 2; // it holds the owner's withdraw option
  public static final int ADD_STOCK = 3; // it holds the owner's add stock option
  public static final int ADD_STOCK_ONE_ITEM = 4; // it holds the owner's add stock option
  public static final int VIEW_STOCK = 5; // it holds the owner's view stock option
  public static final int VIEW_AN_ITEM = 6; // it holds the owner's view an item stock option

  public static final int DISPLAY_ITEMS = 1; // it holds the buyer's display option
  public static final int DEPOSIT_COINS = 2; // it holds the buyer's deposit coins option
  public static final int BUY_ITEMS = 3; // it holds the buyer's buy items option
  public static final int DISPLAY_ACCOUNT_BALANCE = 4; // it holds the buyer's display option
  public static final int WITHDRAW_MONEY = 5; // it holds the buyer's withdraw money option

  final IUserVendingMachine user = new UserVendingMachine(); // initialises IUserVendingMachine
  final IOwnerVendingMachine admin = new OwnerVendingMachine(); // initialises IOwnerVendingMachine

  // the user scanner
  static Scanner sc = new Scanner(System.in);

  // this allows the system user to select the type of user he/she is in the system
  public void userType() throws IOException {
    int type = getUserTypeMenu();

    while (type != EXIT) {
      switch (type) {
        case OWNER:
          handleOwner();
          break;
        case BUYER:
          handleBuyer();
          break;
        default:
          System.out.println("Error, choice not recognised");
      }
      type = getUserTypeMenu();

    }
  }


  // a helper method to handler owner's flow
  public void handleOwner() throws IOException {
    System.out.println(" \n Welcome to Vending Machine Owner Dashboard");

    int choice = getOwnerMenu();
    while (choice != EXIT) {
      switch (choice) {
        case INSERT_COINS:
          depositCoinsOwner();
          break;
        case WITHDRAW:
          admin.withdrawCoins();
          break;
        case ADD_STOCK:
          admin.addStock();
          break;
        case ADD_STOCK_ONE_ITEM:
          addItems();
          break;
        case VIEW_STOCK:
          admin.checkStock();
          break;
        case VIEW_AN_ITEM:
          viewItem();
          break;
        case BACK:
          backToMainMenu();
          break;
        default:
          System.out.println("Error, choice not recognised");
      }
      choice = getOwnerMenu();
    }

  }

  private void backToMainMenu() throws IOException {
    userType();
  }

  // a helper method to handler buyer's flow
  public void handleBuyer() throws IOException {
    System.out.println(" \n Welcome to Vending Machine Buyer Dashboard");

    int choice = getBuyerMenu();
    while (choice != EXIT) {
      switch (choice) {
        case DISPLAY_ITEMS:
          displayItems();
          break;
        case DEPOSIT_COINS:
          depositCoins();
          break;
        case BUY_ITEMS:
          buyItems();
          break;
        case DISPLAY_ACCOUNT_BALANCE:
          user.viewBalance();
          break;
        case WITHDRAW_MONEY:
          user.withdrawMoney();
          break;
        case BACK:
          backToMainMenu();
          break;
        default:
          System.out.println("Error, choice not recognised");
      }
      choice = getBuyerMenu();
    }
  }

  private void displayItems() {
    user.displayItems();
  }

  private String displayEnterCoinsMessage() {
    System.out.println(" Please enter coins as follows: ");
    System.out.println(
        " num of 2 pounds,num of 1 pounds,num of 50 pence,num of 20 pence,num of 10 pence, num of 5 pence,num of 1 pence coins ");
    System.out.println("                                              ");
    System.out.println(" Example: If you would like to enter 5 1 pounds coins only: 0,5,0,0,0,0,0");
    System.out.println("Please enter coins:");
    return sc.next();
  }

  private void depositCoins() {
    String coins = String.valueOf(displayEnterCoinsMessage());
    int[] coinList = CoinBale.parseCoins(coins);
    user.depositCoins(coinList);
  }

  private void depositCoinsOwner() {
    String coins = String.valueOf(displayEnterCoinsMessage());

    int[] coinList = CoinBale.parseCoins(coins);
    admin.insertCoins(coinList);
  }

  private void buyItems() throws IOException {
    user.buyItem();
  }

  void addItems() {
    admin.addItems(new Coke(), 3);
  }


  private void viewItem() {
    System.out.println("\nPlease enter the code for the item as a string e.g 0001");
    String code = sc.next();
    admin.checkStock(code);
  }


  // this is a helper method to display the user type menu
  private int getUserTypeMenu() {
    System.out.println("\nPlease select from the following");
    System.out.println(OWNER + " Owner");
    System.out.println(BUYER + " Buyer");
    System.out.println(BACK + " Back to main menu");
    System.out.print("Enter choice==> ");
    return sc.nextInt();
  }

  // this is a helper method to display the owner menu
  private int getOwnerMenu() {
    System.out.println("\n Please select from the following");
    System.out.println(INSERT_COINS + " Insert Coins");
    System.out.println(WITHDRAW + " Withdraw ");
    System.out.println(ADD_STOCK + " Add stock for all");
    System.out.println(ADD_STOCK_ONE_ITEM + " Add stock for one");
    System.out.println(VIEW_STOCK + " View stock ");
    System.out.println(VIEW_AN_ITEM + " View an Item ");
    System.out.println(BACK + " Back to main menu");
    System.out.print("Enter choice==> ");
    return sc.nextInt();
  }

  // this is a helper method to display the buyer menu
  private int getBuyerMenu() {
    System.out.println(" \n Please select from the following");
    System.out.println(DISPLAY_ITEMS + " Display Available Items");
    System.out.println(DEPOSIT_COINS + " Deposit coins");
    System.out.println(BUY_ITEMS + " Purchase items");
    System.out.println(DISPLAY_ACCOUNT_BALANCE + " View balance");
    System.out.println(WITHDRAW_MONEY + " Withdraw money");
    System.out.println(BACK + " Back to main menu");
    System.out.print("Enter choice==> ");
    return sc.nextInt();
  }
}
