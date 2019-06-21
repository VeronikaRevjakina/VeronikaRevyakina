package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class RelatedMethods extends BasicMethods {

    protected WebDriver driver;

    @BeforeSuite
    public void setUpDriverPath() {
        System.setProperty("webdriver.chrome.driver",
                this.getClass().getClassLoader().getResource("driver/chromedriver.exe").getPath());
        System.setProperty("webdriver.chrome.driver",
                Paths.get("src/test/resources/driver/chromedriver.exe")
                        .toAbsolutePath().toString());

        //WebDriverManager.chromedriver().setup();
    }

    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://epam.github.io/JDI");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        //TO DO : Rest of waits here pageload and so
    }

    public void performLogin() {
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys("epam");
        driver.findElement(By.cssSelector("#password")).sendKeys("1234");
        driver.findElement(By.xpath("//button[@id='login-button']")).click();
    }

    public List<WebElement> findHeaderSectionElements() {
        List<WebElement> headerElements = driver.findElements(By.cssSelector("[class='uui-navigation nav navbar-nav m-l8']>li"));
        return headerElements;
    }

    public List<WebElement> findImagesOnIndexPage() {
        List<WebElement> imageElements = driver.findElements(By.cssSelector("[class='row clerafix benefits'] [class='benefit-icon']"));
        return imageElements;
    }

    public List<WebElement> findTextOnIndexPageUnderIcons() {
        List<WebElement> textElements = driver.findElements(By.cssSelector("[class='row clerafix benefits'] .benefit-txt"));
        return textElements;
    }

    public List<WebElement> findTextOnMainHeaders() {
        List<WebElement> headerElements = new ArrayList<>();
        headerElements.add(driver.findElement(By.name("main-title")));
        headerElements.add(driver.findElement(By.name("jdi-text")));
        return headerElements;
    }


    public void checkLoginDisplayedAndCorrect() {
        checkWebElementIsDisplayed(driver.findElement(By.id("user-name")));
        assertEquals(driver.findElement(By.id("user-name"))
                .getText(), "PITER CHAILOVSKII");
    }

    public void checkBrowserTitleIsHomePage() {
        assertEquals(driver.getTitle(), "Home Page");
    }

    public void checkHeaderSectionElements() {
        String[] headers = new String[]{"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};
        List<WebElement> headerElements = findHeaderSectionElements();
        checkListWebElementsSizeIs4(headerElements);
        checkListWebElementsIsDisplayed(headerElements);
        checkListWebElementsProperText(headerElements, headers);
    }

    public void checkImageElementsOnIndexPage() {
        List<WebElement> imageElements = findImagesOnIndexPage();
        checkListWebElementsSizeIs4(imageElements);
        checkListWebElementsIsDisplayed(imageElements);
    }

    public void checkTextOnIndexPageUnderIcons() {
        String[] benefitText = new String[]{"To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable", "To be multiplatform", "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"};
        List<WebElement> textElements = findTextOnIndexPageUnderIcons();
        checkListWebElementsSizeIs4(textElements);
        checkListWebElementsIsDisplayed(textElements);
        checkListWebElementsProperText(textElements, benefitText);
    }

    public void checkMainHeaders() {
        String[] textOnMainHeaders = new String[]{"EPAM FRAMEWORK WISHES…", "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR."};
        List<WebElement> mainHeaders = findTextOnMainHeaders();
        checkListWebElementsIsDisplayed(mainHeaders);
        checkListWebElementsProperText(mainHeaders, textOnMainHeaders);
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


    public void tearDown() {
        driver.close();
    }
}

