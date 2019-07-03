package hw3.steps;

import hw3.enums.Menu;
import hw3.voids.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class HomePageSteps extends BaseSteps {


    private HomePage homePage;

    public HomePageSteps(WebDriver driver) {
        super(driver);
        homePage = new HomePage(driver);
    }

    @Step("Assert Browser title")
    public void checkPageTitle(String title) {
        assertEquals(homePage.getPageTitle(), title);
    }

    @Step("Perform login")
    public void performLogin(String userName, String password) {
        homePage.performLogin(userName, password);
    }

    @Step("Check user name {0}")
    public void checkLoginDisplayedAndCorrect(String expectedName) {
        assertEquals(homePage.getUserNameText().toLowerCase(),
                expectedName.toLowerCase());

    }

    @Step("Assert that there are 4 items on the header section are" +
            "        displayed and they have proper texts")
    public void checkMenuHeaderSectionElements() {
        List<WebElement> headersMenu = homePage.getMenuHeaderSectionElements();
        List<String> expectedHeaderMenuValues = Menu.getListStringMenuHeaders();
        int size = expectedHeaderMenuValues.size();
        checkListWebElementsSize(headersMenu, size);
        checkListWebElementsIsDisplayed(headersMenu);
        checkListWebElementsHaveProperText
                (headersMenu, expectedHeaderMenuValues);
    }

    @Step("Assert that there are 4 images on the Index Page " +
            "and they are displayed")
    public void checkImageElementsOnIndexPage(int expectedAmountOfImages) {
        List<WebElement> imageElements = homePage.getImageElements();
        checkListWebElementsSize(imageElements, expectedAmountOfImages);
        checkListWebElementsIsDisplayed(imageElements);
    }

    @Step("Assert that there are 4 texts on the Index Page" +
            "        under icons and they have proper text")
    public void checkTextOnIndexPageUnderIcons(List<String> benefitText) {
        List<WebElement> textElements = homePage.getTextElementsUnderIcons();
        checkListWebElementsSize(textElements, benefitText.size());
        checkListWebElementsIsDisplayed(textElements);
        checkListWebElementsHaveProperText(textElements, benefitText);
    }

    @Step("Assert a text of the main headers")
    public void checkMainHeaders(List<String> textOnMainHeaders) {
        List<WebElement> headerElements = new ArrayList<>();
        headerElements.add(homePage.getMainTitle());
        headerElements.add(homePage.getJdiText());
        checkListWebElementsIsDisplayed(headerElements);
        checkListWebElementsHaveProperText(headerElements, textOnMainHeaders);
    }

    @Step("Assert that there is the iframe in the center of page")
    public void checkIFrame() {
        checkWebElementIsDisplayed(homePage.getIFrame());
    }

    @Step("Natigate to Home Page")
    public void switchToDefaultContent() {
        homePage.switchToDefaultContent();
    }

    // TODO checkEpamLogoOnIFrame--Fixed
    @Step("Check Epam logo in the left top conner of iframe")
    public void checkEpamLogoOnIFrame() {
        homePage.switchToIFrame();
        checkWebElementIsDisplayed(homePage.getEpamLogo());
    }

    @Step("Assert a text of the sub header")
    public void checkSubHeader(String expectedHeader) {
        WebElement subHeader = homePage.getSubHeader();
        checkWebElementIsDisplayed(subHeader);
        assertEquals(subHeader.getText(), expectedHeader);
    }

    @Step("Assert that JDI GITHUB is a link and has a proper URL")
    public void checkJDIGITHUBisLinkAndHaveProperUrl(String expectedLink) {
        String jdiLink = homePage.getLink();
        assertEquals(jdiLink, expectedLink);
    }

    @Step("Assert that there is Left Section")
    public void checkLeftSectionExist() {
        checkWebElementIsDisplayed(homePage.getLeftSection());
    }

    @Step("Assert that there is Footer")
    public void checkFooterExist() {
        checkWebElementIsDisplayed(homePage.getFooter());
    }

}
