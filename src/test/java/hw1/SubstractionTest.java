package hw1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SubstractionTest extends BaseTest {
    @Test(dataProvider = "calculator data-provider")
    public void subTest(double a, double b){
        Assert.assertEquals(calculator.sub(a,b),a-b);
    }
}
