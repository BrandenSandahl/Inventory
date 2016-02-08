import java.util.Scanner;

/**
 * Created by branden on 2/8/16 at 12:47.
 */
public class InventoryFunctions {


    // Set up Vars
    static Scanner scanner = new Scanner(System.in);


    public static void displayInventory() {
        int i = 1;
        for (InventoryItem item : Inventory.items) {
            System.out.println(i + ". " + "[" + item.getCount() + "] " + item.getItem());
            i++;
        }
        System.out.println();
        System.out.println("Inventory Management System");
        System.out.println("1. Enter a New Inventory Item ");
        System.out.println("2. Remove an Inventory Item ");
        System.out.println("3. Update quantity of item");
        System.out.println("4. Exit Inventory Manager");

        String userSelection = scanner.nextLine();

        switch (userSelection) {
            case "1":
                enterItem();
                break;
            case "2":
                removeItem();
                break;
            case "3":
                updateQuantity();
                break;
            case "4":
                exitProgram();
            default:
                System.out.println("You have entered an invalid option");
        }
    }

    public static void enterItem() {
        //item
        System.out.println("Please enter the item description");
        String itemDescription = scanner.nextLine();
        //quantity
        //lets make sure user doesn't give us a negative or 0 starting value
        boolean isValid = false;
        int itemQuantity;
        do {
            System.out.println("Please enter the starting inventory");
            itemQuantity = Integer.parseInt(scanner.nextLine());
            if (itemQuantity >= 0) {
                isValid = true;
            }
        } while (!isValid);
        Inventory.items.add(new InventoryItem(itemDescription, itemQuantity));
    }

    //Consider making a GET ITEM BY NUMBER type method
    public static void removeItem() {
        System.out.println("Which item number would you like to remove?");
        int removalNumber = Integer.parseInt(scanner.nextLine());
        removalNumber--;
        System.out.println("Removing " + Inventory.items.get(removalNumber).getItem());
        Inventory.items.remove(removalNumber);
    }

    public static void updateQuantity() {
        System.out.println("Which item number would you like to update?");
        int updateNumber = Integer.parseInt(scanner.nextLine());
        updateNumber--;
        boolean isValid = false;
        int updateQuantity;
        do {
            System.out.println("What do you want to change the quantity of " + Inventory.items.get(updateNumber).getItem() + " to be set to?");
            updateQuantity = Integer.parseInt(scanner.nextLine());
            if (updateQuantity >= 0) {
                isValid = true;
            }
        } while (!isValid);
        Inventory.items.get(updateNumber).setCount(updateQuantity);
    }

    public static void exitProgram() {
        System.out.println("Thanks");
        System.out.println("And remember, ");
        System.out.println("The Horadric cube should not be in your stash.");
        System.exit(666);
    }


}