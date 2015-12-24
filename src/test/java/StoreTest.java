import bootcamp.Mobile;
import bootcamp.Store;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by techops on 24/12/15.
 */

public class StoreTest {

    private List<Mobile> mobiles;

    @Before
    public void setup() {
        Mobile sonyMobile = new Mobile();
        sonyMobile.setPrice(4000);
        Mobile samsungMobile = new Mobile();
        samsungMobile.setPrice(6000);
        Mobile lgMobile = new Mobile();
        lgMobile.setPrice(2000);
        Mobile motoMobile = new Mobile();
        motoMobile.setPrice(9000);
        Mobile micromaxMobile = new Mobile();
        micromaxMobile.setPrice(5500);
        mobiles = Arrays.asList(sonyMobile, samsungMobile, lgMobile, motoMobile, micromaxMobile);
    }

    @Test
    public void shouldBeAbleToGetMobilesWithMaxPriceRange() {
        Store store = new Store(mobiles);
        List<Mobile> recMobiles = store.getMobilesWithMaxPrice(5000);

        assertThat(recMobiles.size(), Is.is(2));
        assertThat(recMobiles.get(0).getPrice(), Is.is(4000));
        assertThat(recMobiles.get(1).getPrice(), Is.is(2000));
    }

    @Test
    public void shouldNotGetMobilesWhosePriceIsGreaterThanMaxPrice() {
        Store store = new Store(mobiles);
        List<Mobile> recMobiles = store.getMobilesWithMaxPrice(1000);
        assertThat(recMobiles.size(), Is.is(0));
    }
}
