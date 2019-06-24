package hw2.ex1;

import hw2.BasicMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class Exercise1Test extends BasicMethods {
    @Test
    public void exercise1Test() {
        // 1. Open test site by URL
        //made in setUp();
        //2. Assert Browser title
        checkBrowserTitle("Home Page");
        //3. Perform login
        performLogin();
        //4. Assert User name in the left-top side of screen that user is loggined
        checkLoginDisplayedAndCorrect();
        //5. Assert Browser title
        checkBrowserTitle("Home Page");
        //6. Assert that there are 4 items on the header section are displayed and they have proper texts
        checkHeaderSectionElements();
        //7. Assert that there are 4 images on the Index Page and they are displayed
        checkImageElementsOnIndexPage();
        //8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        checkTextOnIndexPageUnderIcons();
        //9. Assert a text of the main headers
        checkMainHeaders();
        //10. Assert that there is the iframe in the center of page
        checkWebElementIsDisplayed(driver.findElement(By.id("iframe")));
        //11. Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        checkEpamLogoOniframe();
        //12. Switch to original window back
        driver.switchTo().defaultContent();
        //13. Assert a text of the sub header
        checkSubHeader();
        //14. Assert that JDI GITHUB is a link and has a proper URL
        checkJDIGITHUBisLinkAndHaveProperUrl();
        //15. Assert that there is Left Section
        checkWebElementIsDisplayed(driver.findElement(By.name("navigation-sidebar")));
        //16. Assert that there is Footer
        checkWebElementIsDisplayed(driver.findElement(By.className("footer-bg")));
        //17. Close Browser
        //made in tearDown();
    }

    private void checkHeaderSectionElements() {
        List<String> headers = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        List<WebElement> headerElements = driver.findElements(By.cssSelector("[class='uui-navigation nav navbar-nav m-l8']>li"));

        checkListWebElementsSize(headerElements, 4);
        checkListWebElementsIsDisplayed(headerElements);
        checkListWebElementsHaveProperText(headerElements, headers);
    }

    private void checkImageElementsOnIndexPage() {
        List<WebElement> imageElements = driver.findElements(By.cssSelector("[class='row clerafix benefits'] [class='benefit-icon']"));
        checkListWebElementsSize(imageElements, 4);
        checkListWebElementsIsDisplayed(imageElements);
    }

    private void checkTextOnIndexPageUnderIcons() {
        List<String> benefitText = Arrays.asList("To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable", "To be multiplatform", "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");
        List<WebElement> textElements = driver.findElements(By.cssSelector("[class='row clerafix benefits'] .benefit-txt"));
        checkListWebElementsSize(textElements, 4);
        checkListWebElementsIsDisplayed(textElements);
        checkListWebElementsHaveProperText(textElements, benefitText);
    }

    private void checkMainHeaders() {
        List<String> textOnMainHeaders = Arrays.asList("EPAM FRAMEWORK WISHES…", "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");
        List<WebElement> headerElements = new ArrayList<>();
        headerElements.add(driver.findElement(By.name("main-title")));
        headerElements.add(driver.findElement(By.name("jdi-text")));
        checkListWebElementsIsDisplayed(headerElements);
        checkListWebElementsHaveProperText(headerElements, textOnMainHeaders);
    }

    private void checkEpamLogoOniframe() {
        driver.switchTo().frame("iframe");
        checkWebElementIsDisplayed(driver.findElement(By.id("epam_logo")));
    }

    private void checkSubHeader() {
        WebElement subHeader = driver.findElement(By.cssSelector("[class='text-center']"));
        checkWebElementIsDisplayed(subHeader);
        assertEquals(subHeader.getText(), "JDI GITHUB");
    }

    private void checkJDIGITHUBisLinkAndHaveProperUrl() {
        String jdiLink = driver.findElement(By.linkText("JDI GITHUB")).getAttribute("href");
        assertEquals(jdiLink, "https://github.com/epam/JDI");
    }
}
