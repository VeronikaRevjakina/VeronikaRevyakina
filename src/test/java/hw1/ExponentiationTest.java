package hw1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ExponentiationTest extends BaseTest {
    @Test(dataProvider = "calculator data-provider")
    public void powTest(double a, double b){
        Assert.assertEquals(calculator.pow(a,b),Math.pow(a, Math.floor(b)));
    }
}
