/**
 * Created by branden on 2/9/16 at 13:58.
 */
public class Merchandise extends InventoryItem {

    public Merchandise(String item, int count) {
        super(item, count);
        this.setCategory("Merchandise");
    }
}