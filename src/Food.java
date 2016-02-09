/**
 * Created by branden on 2/9/16 at 13:56.
 */
public class Food extends InventoryItem {

    public Food(String item, int count) {
        super(item, count);
        this.setCategory("Food");
    }
}