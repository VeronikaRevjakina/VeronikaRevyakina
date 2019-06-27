package hw3.steps;

import hw3.enums.ServiceDropdownOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class BaseSteps {

    protected WebDriver driver;

    public BaseSteps(WebDriver driver) {
        this.driver = driver;
    }

    protected void checkListWebElementsSize
            (List<WebElement> webElements, int size) {
        assertEquals(webElements.size(), size);
    }

    protected void checkWebElementIsDisplayed(WebElement element) {
        assertTrue(element.isDisplayed());
    }


    protected void checkListWebElementsIsDisplayed(List<WebElement> webElements) {
        for (WebElement element : webElements) {
            checkWebElementIsDisplayed(element);
        }
    }

    public List<String> getExpectedServiceDropdown(){
        return ServiceDropdownOptions.getListStringServiceDropdown();
    }

    protected void checkWebElementIsSelected(WebElement element) {
        assertTrue(element.isSelected());
    }

    protected void checkWebElementIsUnselected(WebElement element) {
        assertFalse(element.isSelected());
    }

    protected void checkListWebElementsHaveProperText
            (List<WebElement> inputElements, List<String> properText) {
        List<String> actualElements = new ArrayList<>();
        List<String> expectedText = new ArrayList<>();
        for (WebElement element : inputElements) {
            actualElements.add(element.getText().toLowerCase());
        }
        for(String value:properText){
            expectedText.add(value.toLowerCase());
        }
        assertTrue(actualElements.containsAll(expectedText));
        //assertEquals(actualElements, expectedText);
    }



}
