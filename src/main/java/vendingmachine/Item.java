package vendingmachine;

/**
 * It's the core base for creating an item
 */
public interface Item {

  String code(); // the code for the item

  String name(); // name of the item

  double price(); // price of item

  int quantity(); // quantity of the item

  void setQuantity(int quantity); // sets the quantity
}
