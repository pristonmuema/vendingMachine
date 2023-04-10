package vendingmachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import vendingmachine.drink.Coke;
import vendingmachine.drink.Lemonade;
import vendingmachine.drink.Sprite;
import vendingmachine.drink.Water;
import vendingmachine.snack.Candy;
import vendingmachine.snack.Chocolate;
import vendingmachine.snack.Crisps;
import vendingmachine.snack.Peanuts;

/**
 * Acts as our database
 */
public class Repository {

  List<Item> allItems = new ArrayList<Item>(); // initialises all items array
  List<Item> orderedItems = new ArrayList<Item>(); // initialises ordered  items array

  /**
   * Adds all items to the all items list
   */
  public void addItems() {
    allItems.add(new Coke());
    allItems.add(new Lemonade());
    allItems.add(new Sprite());
    allItems.add(new Water());
    allItems.add(new Candy());
    allItems.add(new Chocolate());
    allItems.add(new Crisps());
    allItems.add(new Peanuts());
  }

  /**
   * Updates an Item with specific quantity
   *
   * @param item     the item
   * @param quantity the quantity
   */
  public void addItems(Item item, int quantity) {
    if (allItems.isEmpty()) {
      addItems();
    }
    for (Item item1 : allItems) {
      if (Objects.equals(item1.code(), item.code())) {
        item.setQuantity(quantity);
        allItems.remove(item);
        allItems.add(item);
      }
    }
  }

  /**
   * displays all available items
   */
  public void showAllItems() {
    if (allItems.isEmpty()) {
      addItems();
    }
    stockAllItems();
    displayAllItemsHeading();
    for (Item item : allItems) {
      constructAllItemsDetails(item);
    }
  }

  /**
   * Stock all items to a max of 5, this is the initial stock
   */
  public void stockAllItems() {
    if (allItems.isEmpty()) {
      addItems();
    }
    for (Item item : allItems) {
      item.setQuantity(5);
    }
  }

  /**
   * displays an item
   */
  public void getItem(String code) {
    displayAllItemsWithQuantityHeading();
    if (allItems.isEmpty()) {
      addItems();
    }
    for (Item item : allItems) {
      if (Objects.equals(item.code(), code)) {
        constructAllItemsWithQuantityDetails(item);
        return;
      }
    }
  }

  /**
   * returns an item
   */
  public Item getItemItem(String code) {
    if (allItems.isEmpty()) {
      addItems();
    }
    displayAllItemsWithQuantityHeading();
    for (Item item : allItems) {
      if (Objects.equals(item.code(), code)) {
        return item;
      }
    }
    return null;
  }

  /**
   * Adds an item to the ordered list
   *
   * @param item the item
   */
  public void addOrderedItems(Item item) {
    orderedItems.add(item);
  }

  /**
   * calculates the cost of ordered items
   *
   * @return the total
   */
  public double getOrderedCost() {
    double cost = 0.0;
    for (Item item : orderedItems) {
      cost += item.price();
    }
    return cost;
  }

  /**
   * Displays the ordered items
   */
  public void showOrderedItems() {
    displayOrderedItemsHeading();
    if (orderedItems.isEmpty()) {
      System.out.println("Please add some items to purchase");
      return;
    }
    for (Item item : orderedItems) {
      constructOrderedItemsDetails(item);
    }
    System.out.printf("\nThe total cost is : %.2f ", getOrderedCost());
  }

  /**
   * Show the current stock
   */
  public void showCurrentStock() {
    if (allItems.isEmpty()) {
      addItems();
    }
    displayAllItemsWithQuantityHeading();
    for (Item item : allItems) {
      constructAllItemsWithQuantityDetails(item);
    }
  }

  void displayOrderedItemsHeading() {
    System.out.printf("\n%-15s%-20s%-15s", "Name", "Code", "Price");
  }

  void constructOrderedItemsDetails(Item item) {
    System.out.printf("\n%-15s%-20s%-15.2f", item.name(), item.code(), item.price());
  }

  void displayAllItemsHeading() {
    System.out.printf("\n%-15s%-20s%-15s", "Name", "Code", "Price");
  }

  void constructAllItemsDetails(Item item) {
    System.out.printf("\n%-15s%-20s%-15.2f", item.name(), item.code(), item.price());
  }

  void displayAllItemsWithQuantityHeading() {
    System.out.printf("\n%-15s%-20s%-20s%-15s", "Name", "Code", "Price", "Quantity");
  }

  void constructAllItemsWithQuantityDetails(Item item) {
    System.out.printf("\n%-15s%-20s%-20.2f%-15s", item.name(), item.code(), item.price(),
        item.quantity());
  }

}
