package bootcamp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by techops on 24/12/15.
 */
public class Store {

    List<Mobile> mobiles;
    private List<Mobile> recommendedMobiles;

    public Store(List<Mobile> inventory) {
        mobiles = inventory;

    }

    public List<Mobile> getMobilesWithMaxPrice(int maxPrice) {

        recommendedMobiles = new ArrayList<Mobile>();
        for (Mobile mobile:mobiles) {
            if(mobile.getPrice() < maxPrice) {
                recommendedMobiles.add(mobile);
            }
        }
        return recommendedMobiles;
    }
}
