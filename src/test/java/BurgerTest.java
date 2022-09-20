import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import praktikum.*;
import org.mockito.MockitoAnnotations;


@RunWith(Parameterized.class)
public class BurgerTest {
    private final int indexPassed;
    private final int indexExpected;

    public BurgerTest(int indexPassed, int indexExpected) {
        this.indexPassed = indexPassed;
        this.indexExpected = indexExpected;
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        database = new Database();
    }

    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;

    @Spy
    private Burger burger;

    private Database database;

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        Assert.assertEquals("The passed bun and the received bun do not match", bun, burger.bun);
    }

    @Test
    public void addIngridientTest() {
        burger.addIngredient(ingredient);
        Assert.assertTrue("The method addIngridient does not work correctly", burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngridientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(burger.ingredients.indexOf(ingredient));
        Assert.assertFalse(burger.ingredients.contains(ingredient));
    }

    @Parameterized.Parameters(name = "{index}:moveIngredientIndex{0}={1}")
    public static Object[][] getDataForMoveIngredientTest() {
        return new Object[][]{
                {2, 2},
                {3, 3},
                {4, 4}
        };
    }

    @Test
    public void moveIngredientTest() {
        setIngridientInBurger(indexPassed);
        burger.addIngredient(ingredient);
        burger.moveIngredient(burger.ingredients.indexOf(ingredient), indexPassed);
        Assert.assertEquals("The passed index and expected index not to match", indexExpected, burger.ingredients.indexOf(ingredient));
    }

    @Test
    public void getPriceTest() {
        setMockIngredientBurger(indexPassed);
        burger.setBuns(bun);
        burger.getPrice();
        Mockito.verify(bun).getPrice();
        System.out.println(burger.ingredients);
        Mockito.verify(ingredient, Mockito.times(burger.ingredients.size())).getPrice();
    }

    @Test
    public void getReceiptTest() {
        setMockIngredientBurger(indexPassed);
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("test  burger");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(burger.getPrice()).thenReturn(44F);
        String testReceipt = burger.getReceipt();
        Assert.assertNotNull("the method does not return the burger recipe", testReceipt);
    }

    public void setIngridientInBurger(int indexPassed) {
        for (int i = 0; i <= indexPassed; i++) {
            burger.addIngredient(database.availableIngredients().get(i));
        }
    }
    public void setMockIngredientBurger(int indexPassed) {
        for (int i = 0; i <= indexPassed; i++) {
            burger.addIngredient(ingredient);
        }
    }
}

