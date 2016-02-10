/**
 * Created by branden on 2/9/16 at 17:15.
 */
public final class User {

    private String name, password;
    private boolean hasAccess;


    public User(String name, String password, boolean hasAccess) {
        setName(name);
        setPassword(password);
        setHasAccess(hasAccess);
    }

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


    //log in control method

    public static void logIn() throws Exception {

        System.out.println(" ");
        System.out.println("Please use our sophisticated and secure log in system to access inventory");
        System.out.println("You may type \"exit\" at any time to exit");
        System.out.printf("User Name: \t\n");
        String userName = InventoryFunctions.nextLine();
        System.out.printf("User Password: \t\n");
        String userPass = InventoryFunctions.nextLine();


        if (Inventory.SYSTEM_USERS.containsKey(userName)) {
            if (Inventory.SYSTEM_USERS.get(userName).getPassword().equals(userPass)) {
                if (Inventory.SYSTEM_USERS.get(userName).getHasAccess()) {
                    while (true) {
                        System.out.printf("Greetings, %s\t", Inventory.SYSTEM_USERS.get(userName).getName());
                        InventoryFunctions.displayInventory();
                    }
                } else {
                    System.out.printf("Come on %s, you have been fired for !drinking on the job.\t", Inventory.SYSTEM_USERS.get(userName).getName());
                    logIn();
                }
            } else {
                System.out.println("Invalid name or password. Try again"); //not telling them which one because it's too much work (also it's not so secure)
                logIn();
            }
        } else {
            System.out.println("You are not in our system. Please contact Branden. But not at home. Or during office hours. Definitely not on weekends. Actually, call Doug.");
            logIn();
        }
    }
}
