package hw2;

import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BasicMethods {
    public void checkListWebElementsSizeIs4(List<WebElement> webElements){
        assertEquals(webElements.size(),4);
    }

    public void checkListWebElementsIsDisplayed(List<WebElement> webElements ){
        for(int i=0;i<webElements.size();i++){
            checkWebElementIsDisplayed(webElements.get(i));
        }
    }

    public void checkListWebElementsProperText(List<WebElement> webElements, String[] properText){
        for(int i=0;i<webElements.size();i++){
            assertEquals(webElements.get(i).getText(),properText[i]);
        }
    }

    public void checkWebElementIsDisplayed(WebElement element) {
        assertTrue(element.isDisplayed());
    }
}
