package hw1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DivisionTest extends BaseTest {
    @Test(dataProvider = "calculator data-provider")
    public void divTest(double a, double b){
        Assert.assertEquals(calculator.div(a,b),a/b);
    }
}
