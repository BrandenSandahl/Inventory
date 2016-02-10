

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by branden on 2/8/16 at 12:37.
 */
public class Inventory {

    static ArrayList<InventoryItem> items = new ArrayList<>();
    static final HashMap<String, User> SYSTEM_USERS = new HashMap<>();




    public static void main (String[] args)  {

        //hard coded SYSTEM_USERS
        SYSTEM_USERS.put("oakey", new User("Zach Oakes", "sekao", true));
        SYSTEM_USERS.put("branden7", new User("Branden Sandahl", "secret", true));
        SYSTEM_USERS.put("P_Hustle", new User("Paige McPaiger", "herbmama", false));

        //Start 'er up
        User.logIn();


    }



}
