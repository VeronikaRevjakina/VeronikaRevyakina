package hw3.voids;

import hw3.enums.DifferentElements.CheckboxForces;
import hw3.enums.DifferentElements.DropdownColors;
import hw3.enums.DifferentElements.RadioMetals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DifferentElementsPage extends BasePage {

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

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
    }

    public void clickDropdownByEnumValue (DropdownColors dropdownColor) {
        getDropdownByEnumValue(dropdownColor).click();
    }

    public void clickCheckboxByEnumValue (CheckboxForces checkboxForce) {
        getCheckboxByEnumValue(checkboxForce).click();
    }

    public void clickRadioByEnumValue (RadioMetals radioMetal) {
        getRadioByEnumValue(radioMetal).click();
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

    public WebElement getCheckboxByEnumValue(CheckboxForces checkboxForce) {
        return driver.findElement(By.xpath("//label[contains(string(), '"
                + checkboxForce.getForce() + "')]/input"));
    }

    public WebElement getRadioByEnumValue(RadioMetals radioMetal) {
        return driver.findElement(By.xpath("//label[contains(string(), '"
                + radioMetal.getMetal() + "')]/input"));
    }

    public WebElement findLogRow(String selectedOption, String condition) {
        return driver.findElement(By.xpath("//ul[@class='panel-body-list logs']" +
                "//li[contains(string(),'" + selectedOption + "') " +
                "and contains(text(), '" + condition + "')]"));
    }

   public WebElement getDropdownByEnumValue(DropdownColors dropdownColor) {
        return driver.findElement(By.xpath("//option[contains(text(),'"
                + dropdownColor.getColor() + "')]"));
    }

}
