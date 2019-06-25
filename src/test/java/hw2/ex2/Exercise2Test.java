package hw2.ex2;

import hw2.BasicMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class Exercise2Test extends BasicMethods {
    @Test
    public void exercise2Test() {
        // 1. Open test site by URL
        //made in setUp();
        //2. Assert Browser title
        checkBrowserTitle("Home Page");
        //3. Perform login
        performLogin();
        //4. Assert User name in the left-top side of screen that user is
        // loggined
        checkLoginDisplayedAndCorrect();
        //5. Click on "Service" subcategory in the header and check that
        // drop down contains options
        checkServiceHeaderSubcategory();
        //6. Click on Service subcategory in the left section and check that
        // drop down contains options
        checkServiceLeftSectionSubcategory();
        //7. Open through the header menu Service -> Different Elements PageOpen
        // through the header menu Service -> Different Elements Page
        driver.findElement
                (By.xpath("//li[@class='dropdown']//a[contains(text(), " +
                        "'Service')]"))
                .click();
        checkDropdownDifferentElements();
        //8. Check interface on Different elements page, it contains
        // all needed elements
        checkAllElementsOnDifferentElementsPage();
        //9. Assert that there is Right Section
        checkWebElementIsDisplayed(driver.findElement(By.name("log-sidebar")));
        //10. Assert that there is Left Section
        checkWebElementIsDisplayed(driver.findElement(By.id("mCSB_1")));
        //11. Select checkboxes
        checkCheckboxSelected("Water");
        checkCheckboxSelected("Wind");
        //12. Assert that for each checkbox there is an individual log
        // row and value is corresponded to the status of checkbox.
        checkLogRow("Water", "true");
        checkLogRow("Wind", "true");
        //13. Select radio
        checkRadio("Selen");
        //14. Assert that for radiobutton there is a log row and value
        // is corresponded to the status of radiobutton.
        checkLogRow("metal", "Selen");
        //15. Select in dropdown
        checkOption("Yellow");
        //16. Assert that for dropdown there is a log row and value
        // is corresponded to the selected value.
        checkLogRow("Colors", "Yellow");
        //17. Unselect and assert checkboxes
        checkCheckboxUnselected("Water");
        checkCheckboxUnselected("Wind");
        //18. Assert that for each checkbox there is an individual
        // log row and value is corresponded to the status of checkbox.
        checkLogRow("Water", "false");
        checkLogRow("Wind", "false");
    }

    // TODO What is the difference between current method and checkServiceLeftSectionSubcategory?--Skype
    private void checkServiceHeaderSubcategory() {
        driver.findElement(By.xpath
                ("//li[@class='dropdown']//a[contains(text(), " +
                        "'Service')]")).click();
        List<WebElement> serviceDropdownElements = driver.findElements(By.xpath
                ("//*[@class='dropdown open'" +
                        "]//ul[@class='dropdown-menu']//li"));
        List<String> subcategoryText = Arrays.asList("SUPPORT", "DATES", "SEARCH",
                "COMPLEX TABLE", "SIMPLE TABLE", "USER TABLE",
                "TABLE WITH PAGES", "DIFFERENT ELEMENTS", "PERFORMANCE");
        checkListWebElementsHaveProperText
                (serviceDropdownElements, subcategoryText);
    }

    // TODO What is the difference between current method and checkServiceHeaderSubcategory?--Skype
    private void checkServiceLeftSectionSubcategory() {
        driver.findElement(By.xpath
                ("//ul[@class = 'sidebar-menu']//*[text() = 'Service']")).click();
        List<WebElement> serviceDropdownElements = driver.findElements(By.xpath
                ("//li[@class='menu-title' and contains(.//span,'Service')]" +
                        "//li//span"));
        List<String> subcategoryText = Arrays.asList("Support", "Dates",
                "Complex Table", "Simple Table", "Search", "User Table",
                "Table with pages", "Different elements", "Performance");
        checkListWebElementsHaveProperText
                (serviceDropdownElements, subcategoryText);
    }

    private void checkDropdownDifferentElements() {
        driver.findElement(By.xpath
                ("//ul[@class='dropdown-menu']//li//a[contains(text(), " +
                        "'Different elements')]")).click();
        assertEquals(driver.getCurrentUrl(),
                "https://epam.github.io/JDI/different-elements.html");
    }

    private void checkAllElementsOnDifferentElementsPage() {
        List<WebElement> checkboxes = driver.findElements
                (By.xpath("//input[@type='checkbox']"));
        checkListWebElementsSize(checkboxes, 4);
        List<WebElement> radios = driver.findElements
                (By.xpath("//input[@type='radio']"));
        checkListWebElementsSize(radios, 4);
        List<WebElement> dropdown = driver.findElements
                (By.xpath("//*[@class='colors']//select"));
        checkListWebElementsSize(dropdown, 1);
        List<WebElement> buttons = driver.findElements
                (By.xpath("//*[@class='main-content-hg']//" +
                        "*[contains(@value, 'Button')]"));
        checkListWebElementsSize(buttons, 2);
    }


}
