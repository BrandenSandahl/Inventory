/**
 * Created by branden on 2/8/16 at 12:38.
 */
public class InventoryItem {


    // Set up Vars
    private String item;
    private int count;
    private String category;


// Constructors if used



    public InventoryItem(String item, int count) {
        setItem(item);
        setCount(count);
    }

    /**
     * Start Getters and Setters
     */
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
            this.count = count;
        }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    /** End of Getters and Setters */

}