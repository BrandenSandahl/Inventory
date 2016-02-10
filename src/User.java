/**
 * Created by branden on 2/9/16 at 17:15.
 */
public final class User {

    //vars
    private String name, password;
    private boolean hasAccess;


    //constructor
    public User(String name, String password, boolean hasAccess) {
        setName(name);
        setPassword(password);
        setHasAccess(hasAccess);
    }


    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getHasAccess() {
        return hasAccess;
    }

    public void setHasAccess(boolean hasAccess) {
        this.hasAccess = hasAccess;
    }


    //log in control method Attached to user class because...it just is!
    public static void logIn() throws Exception {

        System.out.println(" ");
        System.out.println("Please use our sophisticated and secure log in system to access inventory");
        System.out.println("You may type \"exit\" at any time to exit");
        System.out.printf("User Name: \t\n");
        String userName = InventoryFunctions.nextLine();
        System.out.printf("User Password: \t\n");
        String userPass = InventoryFunctions.nextLine();


        //Start of a whole pile of ifs
        if (Inventory.SYSTEM_USERS.containsKey(userName)) {    //if the HashMap has the name that the user entered (as a key)
            if (Inventory.SYSTEM_USERS.get(userName).getPassword().equals(userPass)) {       //if the password the user entered equals the one we set
                if (Inventory.SYSTEM_USERS.get(userName).getHasAccess()) {   //if the user has been granted access
                    while (true) {
                        System.out.printf("Greetings, %s\t", Inventory.SYSTEM_USERS.get(userName).getName());  //greet and go into inventory system
                        InventoryFunctions.displayInventory();
                    }
                } else {  //otherwise the user was not granted access. Silly message.
                    System.out.printf("Come on %s, how are you not in jail?\t", Inventory.SYSTEM_USERS.get(userName).getName());
                    logIn();
                }
            } else {  //otherwise the user did not enter the right password user name combo
                System.out.println("Invalid name or password. Try again"); //not telling them which one because it's too much work (also it's not so secure)
                logIn();
            }
        } else {  //otherwise there is no record of the user
            System.out.println("You are not in our system. Please contact Branden. But not at home. Or during office hours. Definitely not on weekends. Actually, call Doug.");
            logIn();
        }
    }    //PHEW!!


}
