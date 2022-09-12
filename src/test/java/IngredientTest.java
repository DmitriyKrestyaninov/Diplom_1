import org.junit.runner.RunWith;
import praktikum.Ingredient;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {
    private final String nameTest = "Булочка с кунжутом";
    private final float priceTest = 44;

    @Test
    public void getPriceTest() {
        Ingredient ingredient = getIngridientTest();
        Assert.assertEquals("The passed price and the received price do not match",priceTest, ingredient.getPrice(),0);
    }
    @Test
    public void getNameTest(){
        Ingredient ingredient = getIngridientTest();
        Assert.assertEquals("The passed name and the received name do not match",nameTest, ingredient.getName());
    }
    @Test
    public void getIngredientTypeTest(){
        Ingredient ingredient = getIngridientTest();
        Assert.assertEquals("The passed name and the received name do not match",IngredientType.FILLING, ingredient.getType());
    }
    public Ingredient getIngridientTest(){
        return new Ingredient(IngredientType.FILLING, nameTest,priceTest);
    }

}

