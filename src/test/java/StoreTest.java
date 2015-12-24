import bootcamp.Brands;
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
    private Store store;

    @Before
    public void setup() {
        Mobile sonyMobile = new Mobile();
        sonyMobile.setPrice(4000);
        sonyMobile.setName(Brands.SONY.name());
        Mobile samsungMobile = new Mobile();
        samsungMobile.setPrice(6000);
        samsungMobile.setName(Brands.SAMSUNG.name());
        Mobile lgMobile = new Mobile();
        lgMobile.setPrice(2000);
        lgMobile.setName(Brands.LG.name());
        Mobile motoMobile = new Mobile();
        motoMobile.setPrice(9000);
        motoMobile.setName(Brands.MOTOROLA.name());
        Mobile micromaxMobile = new Mobile();
        micromaxMobile.setPrice(5500);
        micromaxMobile.setName(Brands.MICROMAX.name());
        Mobile motoMobileHighRange = new Mobile();
        motoMobileHighRange.setPrice(20000);
        motoMobileHighRange.setName(Brands.MOTOROLA.name());
        Mobile samsungMobileHighRange = new Mobile();
        samsungMobileHighRange.setPrice(36000);
        samsungMobileHighRange.setName(Brands.SAMSUNG.name());

        mobiles = Arrays.asList(sonyMobile, samsungMobile, lgMobile, motoMobile, micromaxMobile, motoMobileHighRange, samsungMobileHighRange);
        store = new Store(mobiles);
    }

    @Test
    public void shouldBeAbleToGetMobilesWithMaxPriceRange() {
        List<Mobile> recMobiles = store.getMobilesWithMaxPrice(5000);

        assertThat(recMobiles.size(), Is.is(2));
        assertThat(recMobiles.get(0).getPrice(), Is.is(4000));
        assertThat(recMobiles.get(1).getPrice(), Is.is(2000));
    }

    @Test
    public void shouldNotGetMobilesIfNoMobileIsAvailableWithInMaxPrice() {
        List<Mobile> recMobiles = store.getMobilesWithMaxPrice(1000);
        assertThat(recMobiles.size(), Is.is(0));
    }

    @Test
    public void shouldBeAbleToGetMobilesWithBrandName() {
        List<Mobile> recommendedMobiles = store.getMobilesByBrandName(Brands.MOTOROLA);
        assertThat(recommendedMobiles.size(), Is.is(2));
        assertThat(recommendedMobiles.get(0).getName(), Is.is(Brands.MOTOROLA.name()));
        assertThat(recommendedMobiles.get(1).getName(), Is.is(Brands.MOTOROLA.name()));

        recommendedMobiles = store.getMobilesByBrandName(Brands.SONY);
        assertThat(recommendedMobiles.size(), Is.is(1));
        assertThat(recommendedMobiles.get(0).getName(), Is.is(Brands.SONY.name()));
    }

    @Test
    public void shouldBeAbleToGetMobilesWithBrandNameAndWithInMaxPrice() {
        List<Mobile> recMobiles = store.getMobilesByBrandAndWithMaxPrice(Brands.SAMSUNG, 40000);

        assertThat(recMobiles.size(), Is.is(2));
        Mobile mobileOne = recMobiles.get(0);
        assertThat(mobileOne.getName(), Is.is(Brands.SAMSUNG.name()));
        Mobile mobileTwo = recMobiles.get(1);
        assertThat(mobileTwo.getName(), Is.is(Brands.SAMSUNG.name()));
        assertThat(mobileOne.getPrice(), Is.is(6000));
        assertThat(mobileTwo.getPrice(), Is.is(36000));
    }
}
