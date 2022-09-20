import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Database;

@RunWith(Parameterized.class)
public class BunTest {
    private final int indexPassed;
    private final boolean expectedResult;

    private Database database;
    @Before
    public void setUp(){
        database = new Database();
    }
    public BunTest(int indexPassed, boolean expectedResult) {
        this.indexPassed = indexPassed;
        this.expectedResult = expectedResult;
    }
    @Parameterized.Parameters(name="index of buns from database")
    public static Object[][] getDataForTest(){
            return new  Object[][]{
                    {0,true},
                    {1,true},
                    {2,true}
            };
    }

    @Test
    public void getNameTest() {
        Bun bun = getBunTest();
        Assert.assertEquals("The passed name and the received name do not match", database.availableBuns().get(indexPassed).name, bun.getName());
    }
    @Test
    public void getPriceTest(){
        Bun bun = getBunTest();
        Assert.assertEquals("The passed price and the received price do not match", database.availableBuns().get(indexPassed).price, bun.getPrice(),0);
    }

    public Bun getBunTest(){
        //return new Bun(testNameBurger, testPriceBurger);
        return  database.availableBuns().get(indexPassed);
    }
}


