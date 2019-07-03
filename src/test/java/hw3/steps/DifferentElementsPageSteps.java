package hw3.steps;

import hw3.enums.DifferentElements.CheckboxForces;
import hw3.enums.DifferentElements.DropdownColors;
import hw3.enums.DifferentElements.RadioMetals;
import hw3.enums.Menu;
import hw3.enums.ServiceDropdownOptions;
import hw3.voids.DifferentElementsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class DifferentElementsPageSteps extends BaseSteps {

    private DifferentElementsPage diffElPage;

    public DifferentElementsPageSteps(WebDriver driver) {
        super(driver);
        diffElPage = new DifferentElementsPage(driver);
    }

    @Step("Click on Service subcategory in the Left Section and check that" +
            "      drop down contains options")
    public void checkServiceLeftSectionSubcategory() {
        diffElPage.clickMenuHeaderSectionElement(Menu.SERVICE);
        List<WebElement> menuLeft = diffElPage.getDropDownLeftService();
        List<String> expectedServiceDropdown = getExpectedServiceDropdown();
        checkListWebElementsHaveProperText(menuLeft, expectedServiceDropdown);
    }

    @Step("Click on Service subcategory in the header and check that" +
            "      drop down contains options")
    public void checkServiceHeaderSectionSubcategory() {
        diffElPage.clickServiceHeader();
        List<WebElement> menuHeader = diffElPage.getDropDownHeaderService();
        List<String> expectedServiceDropdown = getExpectedServiceDropdown();
        checkListWebElementsHaveProperText(menuHeader, expectedServiceDropdown);
    }

    @Step("Open through the header menu Service -> Different Elements Page")
    public void openDifferentElementsHeaderMenu(String expectedTitle) {
        diffElPage.clickServiceHeader();
        diffElPage.clickServiceDropdownOption
                (ServiceDropdownOptions.DIFFERENT_ELEMENTS);
        assertEquals(diffElPage.getPageTitle(), expectedTitle);
    }

    @Step("Check interface on Different elements page, it contains" +
            "        all needed elements")
    public void checkAllElementsOnDifferentElementsPage
            (int expectedAmountOfDropdowns, int expectedAmountOfButtons) {
        checkListWebElementsSize
                (diffElPage.getCheckboxes(), CheckboxForces.values().length);
        checkListWebElementsSize
                (diffElPage.getRadios(), RadioMetals.values().length);
        checkListWebElementsSize
                (diffElPage.getDropdown(), expectedAmountOfDropdowns);
        checkListWebElementsSize
                (diffElPage.getButtons(), expectedAmountOfButtons);
    }

    @Step("Assert that there is Right Section")
    public void checkRightSectionExist() {
        checkWebElementIsDisplayed(diffElPage.getRightSection());
    }

    @Step("Assert that there is Left Section")
    public void checkLeftSectionExist() {
        checkWebElementIsDisplayed(diffElPage.getLeftSection());
    }

    @Step("Select checkboxes")
    public void selectCheckbox(CheckboxForces checkboxForce) {
        diffElPage.clickCheckboxByEnumValue(checkboxForce);
        checkWebElementIsSelected
                (diffElPage.getCheckboxByEnumValue(checkboxForce));
    }

    @Step("Unselect checkbox")
    public void unselectCheckbox(CheckboxForces checkboxForce) {
        diffElPage.clickCheckboxByEnumValue(checkboxForce);
        checkWebElementIsUnselected
                (diffElPage.getCheckboxByEnumValue(checkboxForce));
    }

    @Step("Select radio")
    public void selectRadio(RadioMetals radioMetal) {
        diffElPage.clickRadioByEnumValue(radioMetal);
        checkWebElementIsSelected
                (diffElPage.getRadioByEnumValue(radioMetal));
    }

    @Step("Select dropdown")
    public void selectDropdown(DropdownColors dropdownColor) {
        diffElPage.clickDropdownByEnumValue(dropdownColor);
        checkWebElementIsSelected
                (diffElPage.getDropdownByEnumValue(dropdownColor));
    }

    @Step("Check Log Row")
    public void checkLogRow(String selectedOption, String condition) {
        WebElement elementLogRow = diffElPage.
                findLogRow(selectedOption, condition);
        checkWebElementIsDisplayed(elementLogRow);
    }


}
