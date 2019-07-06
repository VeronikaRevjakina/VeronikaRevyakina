package hw6.voids;

import hw3.enums.DifferentElements.CheckboxForces;
import hw3.enums.DifferentElements.DropdownColors;
import hw3.enums.DifferentElements.RadioMetals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DifferentElementsPage extends BasePage {

    private static DifferentElementsPage instance;

    @FindBy(xpath = "//input[@type='checkbox']")
    private List<WebElement> checkboxes;

    @FindBy(xpath = "//input[@type='radio']")
    private List<WebElement> radios;

    @FindBy(xpath = "//select")
    private List<WebElement> dropdown;

    @FindBy(xpath = "//*[@class='main-content-hg']//" +
            "*[contains(@value, 'Button')]")
    private List<WebElement> buttons;

    @FindBy(name = "log-sidebar")
    private WebElement rightSection;

    private DifferentElementsPage(WebDriver driver) {
        super(driver);
    }

    public void clickDropdownOptionByText (String dropdownColor) {
        getDropdownOptionByText(dropdownColor).click();
    }

    public void clickCheckboxByText (String checkboxForce) {
        getCheckboxByText(checkboxForce).click();
    }

    public void clickRadioByText (String radioMetal) {
        getRadioByText(radioMetal).click();
    }

    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }

    public List<WebElement> getRadios() {
        return radios;
    }

    public List<WebElement> getDropdown() {
        return dropdown;
    }

    public List<WebElement> getButtons() {
        return buttons;
    }

    public WebElement getRightSection() {
        return rightSection;
    }

    public WebElement getCheckboxByText(String checkboxForce) {
        return driver.findElement(By.xpath("//label[contains(string(), '"
                + checkboxForce + "')]/input"));
    }

    public WebElement getRadioByText(String radioMetal) {
        return driver.findElement(By.xpath("//label[contains(string(), '"
                + radioMetal + "')]/input"));
    }

    public WebElement findLogRow(String selectedOption, String condition) {
        return driver.findElement(By.xpath("//ul[@class='panel-body-list logs']" +
                "//li[contains(string(),'" + selectedOption + "') " +
                "and contains(text(), '" + condition + "')]"));
    }

   public WebElement getDropdownOptionByText(String dropdownColor) {
        return driver.findElement(By.xpath("//option[contains(text(),'"
                + dropdownColor + "')]"));
    }

    public static DifferentElementsPage getInstance(WebDriver driver) {
        if (instance == null) {
            instance = new DifferentElementsPage(driver);
        }
        return instance;
    }

}
