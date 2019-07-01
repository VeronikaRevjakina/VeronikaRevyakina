package hw3.ex2;

import hw3.BaseTest;
import hw3.enums.DifferentElements.CheckboxForces;
import hw3.enums.DifferentElements.DropdownColors;
import hw3.enums.DifferentElements.RadioMetals;
import hw3.steps.DifferentElementsPageSteps;
import hw3.steps.HomePageSteps;
import hw3.utils.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Exercise2Test extends BaseTest {

    // TODO Java code style for the constants--Fixed
    static final String DIFFERENT_ELEMENTS = "Different Elements";
    static final int EXPECTED_AMOUNT_OF_DROPDOWNS = 1;
    static final int EXPECTED_AMOUNT_OF_BUTTONS = 2;
    static final String CONDITION_TRUE = "true";
    static final String CONDITION_FALSE = "true";
    static final String RADIO_OPTION = "metal";
    static final String DROPDOWN_OPTION = "Colors";

    HomePageSteps homePageSteps;
    DifferentElementsPageSteps diffElemPageSteps;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        homePageSteps = new HomePageSteps(driver);
        diffElemPageSteps = new DifferentElementsPageSteps(driver);
    }

    @Test
    public void exercise2Test() {
        // 1. Open test site by URL
        //made in setUp();
        //2. Assert Browser title
        homePageSteps.checkPageTitle(TITLE);
        //3. Perform login
        User user = readUserDataFromFile
                ("src/test/resources//properties/user.properties");
        homePageSteps.performLogin(user.getUserName(), user.getPassword());
        //4. Assert User name in the left-top side of screen that user is
        // loggined
        homePageSteps.checkLoginDisplayedAndCorrect(user.getExpectedUserName());
        //5. Click on "Service" subcategory in the header and check that
        // drop down contains options
        diffElemPageSteps.checkServiceHeaderSectionSubcategory();
        //6. Click on Service subcategory in the left section and check that
        // drop down contains options
        diffElemPageSteps.checkServiceLeftSectionSubcategory();
        //7. Open through the header menu Service -> Different Elements Page
        diffElemPageSteps.openDifferentElementsHeaderMenu(DIFFERENT_ELEMENTS);
        //8. Check interface on Different elements page, it contains
        // all needed elements
        diffElemPageSteps.
                checkAllElementsOnDifferentElementsPage
                        (EXPECTED_AMOUNT_OF_DROPDOWNS, EXPECTED_AMOUNT_OF_BUTTONS);
        //9. Assert that there is Right Section
        diffElemPageSteps.checkRightSectionExist();
        //10. Assert that there is Left Section
        diffElemPageSteps.checkLeftSectionExist();
        //11. Select checkboxes
        diffElemPageSteps.selectCheckbox(CheckboxForces.WATER);
        diffElemPageSteps.selectCheckbox(CheckboxForces.WIND);
        //12. Assert that for each checkbox there is an individual log
        // row and value is corresponded to the status of checkbox.
        diffElemPageSteps.checkLogRow
                (CheckboxForces.WATER.getForce(), CONDITION_TRUE);
        diffElemPageSteps.checkLogRow
                (CheckboxForces.WIND.getForce(), CONDITION_TRUE);
        //13. Select radio
        diffElemPageSteps.selectRadio(RadioMetals.SELEN);
        //14. Assert that for radiobutton there is a log row and value
        // is corresponded to the status of radiobutton.
        diffElemPageSteps.checkLogRow
                (RADIO_OPTION, RadioMetals.SELEN.getMetal());
        //15. Select in dropdown
        diffElemPageSteps.selectDropdown(DropdownColors.YELLOW);
        //16. Assert that for dropdown there is a log row and value
        // is corresponded to the selected value.
        diffElemPageSteps.checkLogRow
                (DROPDOWN_OPTION, DropdownColors.YELLOW.getColor());
        //17. Unselect and assert checkboxes
        diffElemPageSteps.unselectCheckbox(CheckboxForces.WATER);
        diffElemPageSteps.unselectCheckbox(CheckboxForces.WIND);
        //18. Assert that for each checkbox there is an individual
        // log row and value is corresponded to the status of checkbox.
        diffElemPageSteps.checkLogRow
                (CheckboxForces.WATER.getForce(), CONDITION_FALSE);
        diffElemPageSteps.checkLogRow
                (CheckboxForces.WIND.getForce(), CONDITION_FALSE);
    }

}
