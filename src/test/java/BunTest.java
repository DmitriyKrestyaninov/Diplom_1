import org.junit.Assert;
import org.junit.Test;

import praktikum.Bun;

public class BunTest {
    private final String testNameBurger = "Лев бургер";
    private final float testPriceBurger = 44;
    @Test
    public void getNameTest() {
        Bun bun = getBunTest();
        Assert.assertEquals("The passed name and the received name do not match", testNameBurger, bun.getName());
    }
    @Test
    public void getPriceTest(){
        Bun bun = getBunTest();
        Assert.assertEquals("The passed price and the received price do not match", testPriceBurger, bun.getPrice(),0);
    }

    public Bun getBunTest(){
        return new Bun(testNameBurger, testPriceBurger);
    }

}


