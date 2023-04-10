****************
VENDING MACHINE
****************

Classes

1. VendingMachineSystem.class
- It is the entry point, prints the welcome message and initialises the app
2. SystemUser.class
- Acts as the pivot for the vending machine. This is where you chose the type of user for th w
system. It allows you to interact with the system as per your type.
3. Snack.class
- It is an abstract class that holds all the attributes to be used to create snack items
4. Repository.class
- acts as our database
5. OwnerVendingMachine.class
-implements the IOwnerVendingMachine interface API
6.OrderBuilder.class
- prepare buyer order and settles payments
7. MyCalculator
- implements Calculator interface
8. IUserVendingMachine
- Holds the API that the user uses to interact with the system
9. Item
- It's the core base for creating an item
10. IOwnerVendingMachine
- Holds the API that the owner uses to interact with the system
11. Drink.class
- It is an abstract class that holds all the attributes to be used to create drink items
12. CoinBale.class
- Handles the logic for coin management
13. Coin
- It's an enum holding all available coin type
14. Calculator
- it holds all methods needed to calculate coins total and change/translation
15. drink package
- holds all classes for drink variety  i.e Coke.class, Lemonade.class, Sprite.class, Water.class
16. snack package
- holds all classes for snack variety i.e Candy.class, Chocolate.class, Crisps.class, Peanuts.class