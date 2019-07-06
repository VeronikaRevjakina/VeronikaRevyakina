package hw6.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class AssertionSteps extends BaseSteps {

    @Then("User name should be '([^\"]*)'")
    public void userNameShouldBe(String expectedUsername) {
        checkWebElementIsDisplayed(homePage.getUserNameWebElement());
        assertEquals(homePage.getUserNameWebElement().getText(),
                expectedUsername);
    }

    @Then("'([^\"]*)' page is opened")
    public void titleShouldBe(String expectedTitle) {
        assertEquals(homePage.getPageTitle(),
                expectedTitle);
    }

    @Then("(\\d+) images are displayed on Home page")
    public void homePageShouldHaveImages(int expectedAmountOfImages) {
        checkListWebElementsIsDisplayed(homePage.getImageElements());
        checkListWebElementsSize(homePage.getImageElements(),
                expectedAmountOfImages);
    }

    @Then("(\\d+) texts under icons are displayed on Home page")
    public void homePageShouldHaveTextUnderIcons(int expectedAmountOfTexts) {
        checkListWebElementsIsDisplayed(homePage.getTextElementsUnderIcons());
        checkListWebElementsSize(homePage.getTextElementsUnderIcons(),
                expectedAmountOfTexts);
    }

    @Then("(\\d+) main headers are displayed on Home page")
    public void homePageShouldHaveMainHeaders(int expectedAmountOfMainHeaders) {
        List<WebElement> headerElements = new ArrayList<>();
        headerElements.add(homePage.getMainTitle());
        headerElements.add(homePage.getJdiText());
        checkListWebElementsIsDisplayed(headerElements);
        checkListWebElementsSize(headerElements,expectedAmountOfMainHeaders);
    }

    @Then("Dropdown header Service list should be displayed")
    public void sericeHeaderDropdownListIsDisplayed(){
        checkListWebElementsIsDisplayed(homePage.getDropDownHeaderService());
    }

    @Then("Service header menu should have items")
    public void serviceHeaderMenuHaveItems(List<String> items){
        checkListWebElementsHaveProperText
                (homePage.getDropDownHeaderService(),items);
    }

    @Then("Dropdown left side menu Service list should be displayed")
    public void sericeLeftSideMenuDropdownListIsDisplayed(){
        checkListWebElementsIsDisplayed(homePage.getDropDownLeftService());
    }

    @Then("Service left side menu should have items")
    public void serviceLeftSideMenuHaveItems(List<String> items){
        checkListWebElementsHaveProperText
                (homePage.getDropDownLeftService(),items);
    }

    @Then("(\\d+) checkboxes are displayed on Different Elements Page")
    public void diffElemPageShouldHaveExpectedAmountCheckboxes
            (int expectedAmountOfCheckboxes) {
        checkListWebElementsIsDisplayed(diffElemPage.getCheckboxes());
        checkListWebElementsSize(diffElemPage.getCheckboxes(),
                expectedAmountOfCheckboxes);
    }

    @Then("(\\d+) radios are displayed on Different Elements Page")
    public void diffElemPageShouldHaveExpectedAmountRadios
            (int expectedAmountOfRadios) {
        checkListWebElementsIsDisplayed(diffElemPage.getRadios());
        checkListWebElementsSize(diffElemPage.getRadios(),
                expectedAmountOfRadios);
    }

    @Then("(\\d+) dropdown are displayed on Different Elements Page")
    public void diffElemPageShouldHaveExpectedAmountDropdown
            (int expectedAmountOfDropdown) {
        checkListWebElementsIsDisplayed(diffElemPage.getDropdown());
        checkListWebElementsSize(diffElemPage.getDropdown(),
                expectedAmountOfDropdown);
    }

    @Then("(\\d+) buttons are displayed on Different Elements Page")
    public void diffElemPageShouldHaveExpectedAmountButtons
            (int expectedAmountOfButtons) {
        checkListWebElementsIsDisplayed(diffElemPage.getButtons());
        checkListWebElementsSize(diffElemPage.getButtons(),
                expectedAmountOfButtons);
    }

    @Then("Right Section is displayed on Different Elements Page")
    public void checkThereIsRightSection(){
        checkWebElementIsDisplayed(diffElemPage.getRightSection());
    }

    @Then("Left Section is displayed on Different Elements Page")
    public void checkThereIsLeftSection(){
        checkWebElementIsDisplayed(diffElemPage.getLeftSection());
    }

    @Then("Checkbox '([^\"]*)' is selected")
    public void checkCheckboxByTextIsSelected(String text){
        checkWebElementIsSelected(diffElemPage.getCheckboxByText(text));
    }

    @Then("Checkbox '([^\"]*)' is unselected")
    public void checkCheckboxByTextIsUnselected(String text){
        checkWebElementIsUnselected(diffElemPage.getCheckboxByText(text));
    }

    @Then("Radio '([^\"]*)' is selected")
    public void checkRadioByTextIsSelected(String text){
        checkWebElementIsSelected(diffElemPage.getRadioByText(text));
    }

    @Then("Dropdown '([^\"]*)' color is selected")
    public void checkDropdownColorByTextIsSelected(String text){
        checkWebElementIsSelected(diffElemPage.getDropdownOptionByText(text));
    }

    @Then("Log row should be displayed with value '([^\"]*)' and condition '([^\"]*)'")
    public void checkLogRow(String selectedOption, String condition) {
        WebElement elementLogRow = diffElemPage.
                findLogRow(selectedOption, condition);
        checkWebElementIsDisplayed(elementLogRow);
    }

    @Then("(\\d+) NumberType Dropdowns are displayed on Users Table on User Table Page")
    public void userTablePageShouldHaveExpectedAmountNumberTypeDropdowns
            (int expectedAmountOfNumberDropdowns) {
        checkListWebElementsIsDisplayed(userTablePage.getNumberTypeDropdowns());
        checkListWebElementsSize(userTablePage.getNumberTypeDropdowns(),
                expectedAmountOfNumberDropdowns);
    }

    @Then("(\\d+) User names are displayed on Users Table on User Table Page")
    public void userTablePageShouldHaveExpectedAmountUserNames
            (int expectedAmountOfUserNames) {
        checkListWebElementsIsDisplayed(userTablePage.getUserNames());
        checkListWebElementsSize(userTablePage.getUserNames(),
               expectedAmountOfUserNames);
    }

    @Then("(\\d+) Description images are displayed on Users Table on User Table Page")
    public void userTablePageShouldHaveExpectedAmountDescriptionImages
            (int expectedAmountOfDescriptionImages) {
        checkListWebElementsIsDisplayed(userTablePage.getImages());
        checkListWebElementsSize(userTablePage.getImages(),
                expectedAmountOfDescriptionImages);
    }

    @Then("(\\d+) Description texts under images are displayed on Users Table on User Table Page")
    public void userTablePageShouldHaveExpectedAmountDescriptionTextsUnderImages
            (int expectedAmountOfDescriptionTextsUnderImages) {
        checkListWebElementsIsDisplayed(userTablePage.getDescriptionTextsUnderImages());
        checkListWebElementsSize(userTablePage.getDescriptionTextsUnderImages(),
                expectedAmountOfDescriptionTextsUnderImages);
    }

    @Then("(\\d+) checkboxes are displayed on Users Table on User Table Page")
    public void userTablePageShouldHaveExpectedAmountCheckboxes
            (int expectedAmountOfCheckboxes) {
        checkListWebElementsIsDisplayed(userTablePage.getCheckboxes());
        checkListWebElementsSize(userTablePage.getCheckboxes(),
               expectedAmountOfCheckboxes);
    }

    @Then("User table contains following values:")
    public void userTableShouldContainFollowingValues(DataTable dt){
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        List<String> expected=new ArrayList<>();
        List<String> actual=new ArrayList<>();
        for(int i=0; i<list.size(); i++) {
          expected.add(String.format("%s %s %s",list.get(i).get("Number"),
                  list.get(i).get("User"),list.get(i).get("Description")));
        }
        for(int i=0; i<userTablePage.getDescriptionTextsUnderImages().size(); i++) {
           actual.add(String.format("%d %s %s",(i+1),
                   userTablePage.getUserNames().get(i).getText(),
                   userTablePage.getDescriptionTextsUnderImages().get(i)
                           .getText().replaceAll("\n", " ")));

        }
        assertEquals(actual,expected);
    }

    @Then("(\\d+) log row has '([^\"]*)' text in log section")
    public void checkLogRowValueByNumber(int number,String expectedValue){
        WebElement row=userTablePage.findLogRowStringByNumber(number);
        assertTrue(row.getText().contains(expectedValue));
    }

    @Then("Dropdown list for user '([^\"]*)' contains values")
    public void dropdownByUserNameShouldContainValues
            (String userName, List<String> values) {
        checkListWebElementsHaveProperText(
                userTablePage.getDropdownValuesByUserName(userName),values);
    }
    private void checkWebElementIsDisplayed(WebElement element) {
        assertTrue(element.isDisplayed());
    }

    private void checkListWebElementsIsDisplayed(List<WebElement> webElements) {
        for (WebElement element : webElements) {
            checkWebElementIsDisplayed(element);
        }
    }

    private void checkListWebElementsSize
            (List<WebElement> webElements, int size) {
        assertEquals(webElements.size(), size);
    }

    private void checkListWebElementsHaveProperText
            (List<WebElement> inputElements, List<String> properText) {
        List<String> actualElements = new ArrayList<>();
        for (WebElement element : inputElements) {
            actualElements.add(element.getText());
        }
        assertEquals(actualElements, properText);
    }

    private void checkWebElementIsSelected(WebElement element) {
        assertTrue(element.isSelected());
    }

    private void checkWebElementIsUnselected(WebElement element) {
        assertFalse(element.isSelected());
    }

}
