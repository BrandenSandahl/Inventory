import java.util.ArrayList;

/**
 * Created by branden on 2/8/16 at 12:37.
 */
public class Inventory {

    static ArrayList<InventoryItem> items = new ArrayList<>();


    public static void main (String[] args) throws ClassNotFoundException {



       while (true) {

           InventoryFunctions.displayInventory();

        }
    }

}