package hw1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AdditionTest extends BaseTest {
    @Test(dataProvider = "calculator data-provider")
    public void sumTest(double a, double b){
        Assert.assertEquals(calculator.sum(a,b),a+b);
    }
}
