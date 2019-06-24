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
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class BasicMethods {

    protected WebDriver driver;

    @BeforeSuite
    public void setUpDriverPath() {
        System.setProperty("webdriver.chrome.driver",
                this.getClass().getClassLoader().getResource("driver/chromedriver.exe").getPath());
        System.setProperty("webdriver.chrome.driver",
                Paths.get("src/test/resources/driver/chromedriver.exe")
                        .toAbsolutePath().toString());

    }


    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        // 1. Open test site by URL
        driver.get("https://epam.github.io/JDI");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
    }

    protected void performLogin() {
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys("epam");
        driver.findElement(By.cssSelector("#password")).sendKeys("1234");
        driver.findElement(By.xpath("//button[@id='login-button']")).click();
    }

    public void checkLoginDisplayedAndCorrect() {
        checkWebElementIsDisplayed(driver.findElement(By.id("user-name")));
        assertEquals(driver.findElement(By.id("user-name"))
                .getText(), "PITER CHAILOVSKII");
    }

    public void checkListWebElementsSize(List<WebElement> webElements, int size) {
        assertEquals(webElements.size(), size);
    }

    public void checkListWebElementsIsDisplayed(List<WebElement> webElements) {
        for (int i = 0; i < webElements.size(); i++) {
            checkWebElementIsDisplayed(webElements.get(i));
        }
    }

    public void checkListWebElementsHaveProperText(List<WebElement> inputElements, List<String> properText) {
        List<String> actualElements = new ArrayList<>();
        for (WebElement element : inputElements) {
            actualElements.add(element.getText());
        }
        assertEquals(actualElements, properText);
    }

    public void checkWebElementIsSelected(WebElement element){
        assertTrue(element.isSelected());
    }

    public void checkWebElementIsUnselected(WebElement element){
        assertFalse(element.isSelected());
    }

    public void checkWebElementIsDisplayed(WebElement element) {
        assertTrue(element.isDisplayed());
    }

    public void checkBrowserTitle(String title) {
        assertEquals(driver.getTitle(), title);
    }

    public WebElement findCheckbox(String name){
        return driver.findElement(By.xpath("//label[contains(string(), '" +name+"')]/input"));
    }

    public void selectCheckbox(String name){
        findCheckbox(name).click();
    }

    public WebElement findRadio(String name){
        return driver.findElement(By.xpath("//*[@class='label-radio' " +
                "and contains(.,'" +name+ "')]//input"));
    }

    public WebElement findLogRow(String selectedOption, String condition){
        return driver.findElement(By.xpath( "//ul[@class='panel-body-list logs']//li[contains(string(),'" + selectedOption + "') " +
                "and contains(text(), '" + condition + "')]"));
    }

    public WebElement findOption(String name){
        return driver.findElement(By.xpath("//option[contains(text(),'"+ name+"')]"));
    }

    public void checkLogRow(String selectedOption,String condition) {
        WebElement elementLogRow=findLogRow(selectedOption, condition);
        checkWebElementIsDisplayed(elementLogRow);
    }

    public void checkRadio(String name) {
        WebElement radio=findRadio(name);
        radio.click();
        checkWebElementIsSelected(radio);
    }
    public void checkOption(String name) {
        WebElement option= findOption(name);
       option.click();
        checkWebElementIsSelected(option);
    }

    public void checkCheckboxSelected(String name) {
        selectCheckbox(name);
        checkWebElementIsSelected(findCheckbox(name));
    }

    public void checkCheckboxUnselected(String name) {
        selectCheckbox(name);
        checkWebElementIsUnselected(findCheckbox(name));
    }

    //17. Close Browser
    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
