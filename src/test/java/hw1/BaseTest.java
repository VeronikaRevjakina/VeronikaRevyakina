package hw1;

import com.epam.tat.module4.Calculator;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;


public class BaseTest {
    protected Calculator calculator;

    @BeforeMethod
    public void setCalculator(){
        calculator=new Calculator();
    }

    @DataProvider(name = "calculator data-provider")
    public static Object[][] calculatorDataProviderMethod(){
        return new Object[][] { { 0.5, 10 }, { 1,2 } ,{-2.5,100},{-100000,54000}};
    }

}
