package hw3.ex1;

import hw3.BaseTest;
import hw3.steps.HomePageSteps;
import hw3.utils.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class Exercise1Test extends BaseTest {

    // TODO Java code style for the constants
    static final int expectedAmountOfImages = 4;
    static final List<String> benefitText = Arrays.asList
            ("To include good practices\nand ideas from successful" +
                            "\nEPAM project",
                    "To be flexible and\ncustomizable", "To be multiplatform",
                    "Already have good base\n(about 20 internal and\n" +
                            "some external projects),\nwish to get more…");
    static final List<String> textOnMainHeaders = Arrays.asList
            ("EPAM FRAMEWORK WISHES…",
                    "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT,"+
                    " SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE " +
                    "MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD " +
                    "EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA " +
                    "COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT" +
                    " IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT " +
                      "NULLA PARIATUR.");
    static final String subHeader = "JDI GITHUB";
    static final String jdiLink = "https://github.com/epam/JDI";

    HomePageSteps homePageSteps;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        homePageSteps = new HomePageSteps(driver);
    }

    @Test
    public void exercise1Test() {
        // 1. Open test site by URL
        //made in setUp();
        //2. Assert Browser title
        homePageSteps.checkPageTitle(title);
        //3. Perform login
        User user = readUserDataFromFile
                ("src/test/resources//properties/user.properties");
        homePageSteps.performLogin(user.getUserName(), user.getPassword());
        //4. Assert User name in the left-top side of screen that user is
        // loggined
        homePageSteps.checkLoginDisplayedAndCorrect
                (user.getExpectedUserName());
        //5. Assert Browser title
        homePageSteps.checkPageTitle(title);
        //6. Assert that there are 4 items on the header section are
        // displayed and they have proper texts
        homePageSteps.checkMenuHeaderSectionElements();
        //7. Assert that there are 4 images on the Index Page and
        // they are displayed
        homePageSteps.checkImageElementsOnIndexPage(expectedAmountOfImages);
        //8. Assert that there are 4 texts on the Index Page
        // under icons and they have proper text
        homePageSteps.checkTextOnIndexPageUnderIcons(benefitText);
        //9. Assert a text of the main headers
        homePageSteps.checkMainHeaders(textOnMainHeaders);
        //10. Assert that there is the iframe in the center of page
        homePageSteps.checkIFrame();
        //11. Switch to the iframe and check that there is Epam logo
        // in the left top conner of iframe
        homePageSteps.checkEpamLogoOniframe();
        //12. Switch to original window back
        homePageSteps.switchToDefaultContent();
        //13. Assert a text of the sub header
        homePageSteps.checkSubHeader(subHeader);
        //14. Assert that JDI GITHUB is a link and has a proper URL
        homePageSteps.checkJDIGITHUBisLinkAndHaveProperUrl(jdiLink);
        //15. Assert that there is Left Section
        homePageSteps.checkLeftSectionExist();
        //16. Assert that there is Footer
        homePageSteps.checkFooterExist();
        //17. Close Browser
        //made in tearDown();

    }


}
