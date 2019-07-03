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

    public void checkPageTitle(String title) {
        assertEquals(homePage.getPageTitle(), title);
    }

    public void performLogin(String userName, String password) {
        homePage.performLogin(userName, password);
    }

    @Step("Check user name {0}")
    public void checkLoginDisplayedAndCorrect(String expectedName) {
        assertEquals(homePage.getUserNameText().toLowerCase(),
                expectedName.toLowerCase());

    }

    public void checkMenuHeaderSectionElements() {
        List<WebElement> headersMenu = homePage.getMenuHeaderSectionElements();
        List<String> expectedHeaderMenuValues = Menu.getListStringMenuHeaders();
        int size = expectedHeaderMenuValues.size();
        checkListWebElementsSize(headersMenu, size);
        checkListWebElementsIsDisplayed(headersMenu);
        checkListWebElementsHaveProperText
                (headersMenu, expectedHeaderMenuValues);
    }

    public void checkImageElementsOnIndexPage(int expectedAmountOfImages) {
        List<WebElement> imageElements = homePage.getImageElements();
        checkListWebElementsSize(imageElements, expectedAmountOfImages);
        checkListWebElementsIsDisplayed(imageElements);
    }

    public void checkTextOnIndexPageUnderIcons(List<String> benefitText) {
        List<WebElement> textElements = homePage.getTextElementsUnderIcons();
        checkListWebElementsSize(textElements, benefitText.size());
        checkListWebElementsIsDisplayed(textElements);
        checkListWebElementsHaveProperText(textElements, benefitText);
    }

    public void checkMainHeaders(List<String> textOnMainHeaders) {
        List<WebElement> headerElements = new ArrayList<>();
        headerElements.add(homePage.getMainTitle());
        headerElements.add(homePage.getJdiText());
        checkListWebElementsIsDisplayed(headerElements);
        checkListWebElementsHaveProperText(headerElements, textOnMainHeaders);
    }

    public void checkIFrame() {
        checkWebElementIsDisplayed(homePage.getIFrame());
    }

    @Step("Natigate to Home Page")
    public void switchToDefaultContent() {
        homePage.switchToDefaultContent();
    }

    // TODO checkEpamLogoOnIFrame--Fixed
    public void checkEpamLogoOnIFrame() {
        homePage.switchToIFrame();
        checkWebElementIsDisplayed(homePage.getEpamLogo());
    }

    public void checkSubHeader(String expectedHeader) {
        WebElement subHeader = homePage.getSubHeader();
        checkWebElementIsDisplayed(subHeader);
        assertEquals(subHeader.getText(), expectedHeader);
    }

    public void checkJDIGITHUBisLinkAndHaveProperUrl(String expectedLink) {
        String jdiLink = homePage.getLink();
        assertEquals(jdiLink, expectedLink);
    }

    public void checkLeftSectionExist() {
        checkWebElementIsDisplayed(homePage.getLeftSection());
    }

    public void checkFooterExist() {
        checkWebElementIsDisplayed(homePage.getFooter());
    }

}
