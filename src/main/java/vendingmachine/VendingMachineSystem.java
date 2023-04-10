package vendingmachine;

import java.io.IOException;

public class VendingMachineSystem {

  public static void main(String[] args) throws IOException {

    System.out.println(" *********************************************");
    System.out.println("     WELCOME TO THE VENDING MACHINE           ");
    System.out.println(" *********************************************");

    SystemUser systemUser = new SystemUser();
    systemUser.userType();
  }
}


