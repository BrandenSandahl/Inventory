/**
 * Created by branden on 2/9/16 at 13:14.
 */
public class Beer extends InventoryItem {

    public Beer(String item, int count) {
        super(item, count);
        this.setCategory("beer");
    }


}