package hw2.ex1;

import hw2.RelatedMethods;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Exercise1Test extends RelatedMethods {
    @Test
    public void exercise1Test() {
        // 1. Open test site by URL
        setUp();
        //2. Assert Browser title
        checkBrowserTitleIsHomePage();
        //3. Perform login
        performLogin();
        //4. Assert User name in the left-top side of screen that user is loggined
        checkLoginDisplayedAndCorrect();
        //5. Assert Browser title
        checkBrowserTitleIsHomePage();
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
        tearDown();

    }
}
