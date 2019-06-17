package hw1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MultiplicationTest extends BaseTest{
    @Test(dataProvider = "calculator data-provider")
    public void multTest(double a, double b){
        Assert.assertEquals(calculator.mult(a,b),a*b);
    }
}
