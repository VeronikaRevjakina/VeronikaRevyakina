package hw4.voids;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import hw3.enums.DifferentElements.CheckboxForces;
import hw3.enums.DifferentElements.DropdownColors;
import hw3.enums.DifferentElements.RadioMetals;
import hw3.enums.DifferentElements.Vegetables;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class MetalsAndColorsPage extends BasePage {

    //Collections
    @FindBy(css = "#elements-block label")
    private ElementsCollection elements;

    @FindBy(css = "#summary-block label")
    private ElementsCollection summary;

    @FindBy(css = "#colors li > a")
    private ElementsCollection colors;

    @FindBy(css = "#metals li > a")
    private ElementsCollection metals;

    @FindBy(css = "#salad-dropdown label")
    private ElementsCollection vegetables;

    //Buttons
    @FindBy(css = "#colors button")
    private SelenideElement colorsButton;

    @FindBy(id = "calculate-button")
    private SelenideElement calculateButton;

    @FindBy(css = "#metals span.caret")
    private SelenideElement metalsButton;

    @FindBy(css = "#salad-dropdown button")
    private SelenideElement vegetablesButton;

    @FindBy(id = "submit-button")
    private SelenideElement submit;

    @FindBy(css = "ul[class='panel-body-list results'] ")
    private SelenideElement resultBlock;

    public void clickElementByEnumValue(CheckboxForces checkboxForce) {
        elementByEnumValue(checkboxForce).click();
    }

    public void clickSummaryByValue(String value) {
        summaryByValue(value).click();
    }

    public void clickColorByEnumValue(DropdownColors color) {
        colorByEnumValue(color).click();
    }

    public void clickMetalByEnumValue(RadioMetals metal) {
        metalByEnumValue(metal).click();
    }

    public void clickVegetableByEnumValue(Vegetables vegetable) {
        vegetableByEnumValue(vegetable).click();
    }

    public void clickColorsButton() {
        colorsButton.click();
    }

    public void clickCalculateButton() {
        calculateButton.click();
    }

    public void clickMetalsButton() {
        metalsButton.click();
    }

    public void clickVegetablesButton() {
        vegetablesButton.click();
    }

    public SelenideElement elementByEnumValue(CheckboxForces checkboxForce) {
        return elements.findBy(Condition.text(checkboxForce.getForce()));
    }

    public SelenideElement summaryByValue(String value) {
        return summary.findBy(Condition.text(value));
    }

    public SelenideElement colorByEnumValue(DropdownColors color) {
        return colors.findBy(Condition.text(color.getColor()));
    }

    public SelenideElement metalByEnumValue(RadioMetals metal) {
        return metals.findBy(Condition.text(metal.getMetal()));
    }

    public SelenideElement vegetableByEnumValue(Vegetables vegetable) {
        return vegetables.findBy(Condition.text(vegetable.getVegetable()));
    }

    public void submitClick() {
        submit.click();
    }

    public SelenideElement findResultBlockByOption(String option) {
        return resultBlock.find
                (By.xpath(".//li[contains(string(),'" + option + "')]"));
    }
}
