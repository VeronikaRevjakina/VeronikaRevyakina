package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class RelatedMethods extends BasicMethods {


    public void checkLoginDisplayedAndCorrect() {
        checkWebElementIsDisplayed(driver.findElement(By.id("user-name")));
        assertEquals(driver.findElement(By.id("user-name"))
                .getText(), "PITER CHAILOVSKII");
    }


    public void checkHeaderSectionElements() {
        List<String> headers = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        List<WebElement> headerElements = driver.findElements(By.cssSelector("[class='uui-navigation nav navbar-nav m-l8']>li"));

        checkListWebElementsSize(headerElements,4);
        checkListWebElementsIsDisplayed(headerElements);
        checkListWebElementsHaveProperText(headerElements, headers);
    }

    public void checkImageElementsOnIndexPage() {
        List<WebElement> imageElements = driver.findElements(By.cssSelector("[class='row clerafix benefits'] [class='benefit-icon']"));
        checkListWebElementsSize(imageElements,4);
        checkListWebElementsIsDisplayed(imageElements);
    }

    public void checkTextOnIndexPageUnderIcons() {
        List<String> benefitText = Arrays.asList("To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable", "To be multiplatform", "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");
        List<WebElement> textElements = driver.findElements(By.cssSelector("[class='row clerafix benefits'] .benefit-txt"));
        checkListWebElementsSize(textElements,4);
        checkListWebElementsIsDisplayed(textElements);
        checkListWebElementsHaveProperText(textElements, benefitText);
    }

    public void checkMainHeaders() {
        List<String> textOnMainHeaders = Arrays.asList("EPAM FRAMEWORK WISHES…", "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");
        List<WebElement> headerElements = new ArrayList<>();
        headerElements.add(driver.findElement(By.name("main-title")));
        headerElements.add(driver.findElement(By.name("jdi-text")));
        checkListWebElementsIsDisplayed(headerElements);
        checkListWebElementsHaveProperText(headerElements, textOnMainHeaders);
    }

    public void checkEpamLogoOniframe() {
        driver.switchTo().frame("iframe");
        checkWebElementIsDisplayed(driver.findElement(By.id("epam_logo")));
    }

    public void checkSubHeader() {
        WebElement subHeader = driver.findElement(By.cssSelector("[class='text-center']"));
        checkWebElementIsDisplayed(subHeader);
        assertEquals(subHeader.getText(), "JDI GITHUB");
    }

    public void checkJDIGITHUBisLinkAndHaveProperUrl() {
        String jdiLink = driver.findElement(By.linkText("JDI GITHUB")).getAttribute("href");
        assertEquals(jdiLink, "https://github.com/epam/JDI");
    }


}

