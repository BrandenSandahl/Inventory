/**
 * Created by branden on 2/9/16 at 13:55.
 */
public class Liquor extends InventoryItem {

    public Liquor(String item, int count) {
        super(item, count);
        this.setCategory("Liquor");
    }
}