package bootcamp;

/**
 * Created by techops on 24/12/15.
 */
public class Mobile {

    private String name;
    private int price;

    public Mobile() {

    }
    public Mobile(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
