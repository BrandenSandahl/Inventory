
import java.util.Scanner;

/**
 * Created by branden on 2/8/16 at 12:47.
 */
public class InventoryFunctions {


    // Set up Vars
    static Scanner scanner = new Scanner(System.in);
    static final String[] CATEGORIES = {"Beer", "Food", "Liquor", "Merchandise", "Wine"};


    public static void displayInventory() throws Exception {
        if (!Inventory.items.isEmpty()) {
            System.out.printf("%-5s %-18s %-15s %s%n", "#", "QUANTITY", "ITEM", "CATEGORY");
            int i = 1; //Used to place numbers by items
            for (InventoryItem item : Inventory.items) {
                System.out.printf("%d%-5s %s%d%s %20.30s %18s%n", i, ".", "[", item.getCount(), "]", item.getItem(), item.getCategory());
                i++;
            }
        }
        System.out.println();
        System.out.println("Inventory Management System");
        System.out.println("\t1. Enter a New Inventory Item ");
        System.out.println("\t2. Remove an Inventory Item ");
        System.out.println("\t3. Update quantity of item");
        System.out.println("\t4. Exit Inventory Manager");

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

    public static void enterItem() throws Exception {
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
        String category = (CATEGORIES[(Integer.parseInt(nextLine()) - 1)]);   //get the name from the index number

        // 0 beer 1 food 2 liquor 3 merchandise 4 wine
        switch (category) {
            case "Beer":
                Inventory.items.add(new Beer(itemDescription, itemQuantity));
                break;
            case "Food":
                Inventory.items.add(new Food(itemDescription, itemQuantity));
                break;
            case "Liquor":
                Inventory.items.add(new Liquor(itemDescription, itemQuantity));
                break;
            case "Merchandise":
                Inventory.items.add(new Merchandise(itemDescription, itemQuantity));
                break;
            case "Wine":
                Inventory.items.add(new Merchandise(itemDescription, itemQuantity));
                break;
            default:
                System.out.printf("Something has gone terribly wrong");
                throw new Exception();  //breaking the program because this SHOULD work. If it didn't I don't want to keep running I want to know what has happened.
        }

        /**
         * None of this shit works.
         * it's just here for me to reflect (pun) upon how badly i failed at making this work
         *
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

    public static void logOut() throws Exception {
        System.out.println("Thanks");
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