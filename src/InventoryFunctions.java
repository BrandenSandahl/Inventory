
import java.util.Scanner;



/**
 * Created by branden on 2/8/16 at 12:47.
 */
public class InventoryFunctions {


    // Set up Vars
    static Scanner scanner = new Scanner(System.in);
    static final String[] CATEGORIES = {"Beer", "Food", "Liquor", "Merchandise", "Wine"};


    public static void displayInventory() {
        if (!Inventory.items.isEmpty()) {
            System.out.printf("#\t%s\t\t%s\t\t\t%s%n", "QUANTITY", "ITEM", "CATEGORY");
            int i = 1; //Used to place numbers by items
            for (InventoryItem item : Inventory.items) {
                //System.out.println(i + ". " + "[" + item.getCount() + "] " + item.getItem());
                System.out.printf("%d.\t [%d]\t\t\t %s\t\t\t%n", i, item.getCount(), item.getItem());
                i++;
            }
        }
        System.out.println();
        System.out.println("Inventory Management System");
        System.out.println("1. Enter a New Inventory Item ");
        System.out.println("2. Remove an Inventory Item ");
        System.out.println("3. Update quantity of item");
        System.out.println("4. Exit Inventory Manager");

        String userSelection = nextLine();

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
                logOut();
            default:
                System.out.println("You have entered an invalid option");
        }
    }

    public static void enterItem() {
        //item
        System.out.println("Please enter the item description");
        String itemDescription = nextLine();
        //quantity
        //lets make sure user doesn't give us a negative or 0 starting value
        boolean isValid = false;
        int itemQuantity;
        do {
            System.out.println("Please enter the starting inventory");
            itemQuantity = Integer.parseInt(nextLine());
            if (itemQuantity >= 0) {
                isValid = true;
            }
        } while (!isValid);
        System.out.println("Please choose an item category");
        displayCategories();
        String category = CATEGORIES[Integer.parseInt(nextLine()) - 1]; //this is a pretty crazy line. Doing a lot of stuff in one line. Too much? maybe. Some would say, not enough sir. not enough

        Inventory.items.add(new InventoryItem(itemDescription, itemQuantity));


        /**
         * None of this shit works.
        // Class c = Class.forName(category);

        //System.out.println(Class.forName(category));
        //System.out.println(category);

        //Class.forName(CATEGORIES[Integer.parseInt(nextLine())]);

       //Inventory.items.add(new c(itemDescription, itemQuantity));



         */
    }

    //Consider making a GET ITEM BY NUMBER type method
    public static void removeItem() {
        System.out.println("Which item number would you like to remove?");
        int removalNumber = Integer.parseInt(nextLine());
        removalNumber--;
        System.out.println("Removing " + Inventory.items.get(removalNumber).getItem());
        Inventory.items.remove(removalNumber);
    }

    public static void updateQuantity() {
        System.out.println("Which item number would you like to update?");
        int updateNumber = Integer.parseInt(nextLine());
        updateNumber--;
        boolean isValid = false;
        int updateQuantity;
        do {
            System.out.println("What do you want to change the quantity of " + Inventory.items.get(updateNumber).getItem() + " to be set to?");
            updateQuantity = Integer.parseInt(nextLine());
            if (updateQuantity >= 0) {
                isValid = true;
            }
        } while (!isValid);
        Inventory.items.get(updateNumber).setCount(updateQuantity);
    }

    public static void displayCategories() {
        System.out.println("Item Categories: ");
        for (int i = 0; i < CATEGORIES.length; i++) {
            System.out.printf("%d.\t %s%n", (i + 1), CATEGORIES[i]);
        }
    }

    public static void logOut() {
        System.out.println("Thanks");
        System.out.println("And remember, ");
        System.out.println("The Horadric cube should not be in your stash.");
        System.out.println("");
        User.logIn();

    }

    //real quick and dirty exit method
    public static String nextLine(){
        String lineIn = scanner.nextLine();
        while (lineIn.equalsIgnoreCase("exit")) {
            System.out.println("Thanks. Bye.");
            System.exit(0);
        }
        return lineIn;
    }


}