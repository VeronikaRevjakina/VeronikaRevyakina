package hw4.ex1;

import hw3.enums.Menu;
import hw3.enums.ServiceDropdownOptions;
import hw3.enums.TableWithPages.ShowEntries;
import hw3.utils.User;
import hw4.BaseTest;
import hw4.voids.BasePage;
import hw4.voids.TableWithPagesPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static org.testng.Assert.assertEquals;

public class Exercise1Test extends BaseTest {

    static final String TABLE_WITH_PAGES = "Table with pages";
    static final String SEARCH_OPTION = "Custom";

    @Test
    public void exercise1Test() {
        // 1. Open test site by URL
        BasePage basePage = open
                (MAIN_JDI_LINK, BasePage.class);
        //2. Assert Browser title
        assertEquals(title(), TITLE);
        //3. Perform login
        User user = readUserDataFromFile
                ("src/test/resources//properties/user.properties");
        basePage.performLogin(user.getUserName(), user.getPassword());
        //4. Assert User name in the left-top side of screen that user is
        // loggined
        basePage.userNameText().shouldHave(text(user.getExpectedUserName()));
        //5. Click on "Service" subcategory in the header and
        //  check that drop down contains options
        basePage.clickServiceHeader();
        basePage.dropDownHeaderService().shouldHave
                (texts(ServiceDropdownOptions.getListStringServiceDropdown()));
        //6. Click on Service subcategory in the left section and check
        // that drop down contains options
        basePage.clickMenuHeaderSectionElement(Menu.SERVICE);
        basePage.dropDownLeftService().
                shouldHave(textsInAnyOrder
                        (ServiceDropdownOptions.getListStringServiceDropdown()));
        //7. Open through the header menu Service -> Table with pages
        basePage.clickServiceHeader();
        basePage.clickServiceDropdownOption
                (ServiceDropdownOptions.TABLE_WITH_PAGES);
        TableWithPagesPage tableWithPagesPage = new TableWithPagesPage();
        assertEquals(title(), TABLE_WITH_PAGES);
        //8. Check that default value for “Show entries” dropdown is 5
        tableWithPagesPage.dropdownShowEntriesLength().
                shouldHave(text(ShowEntries.FIVE.getEntry()));
        //9. Assert that there is Right Section
        tableWithPagesPage.rightSectionLog().isDisplayed();
        //10. Assert that there is Left Section
        tableWithPagesPage.leftSection().isDisplayed();
        //11. Select new value for the entries in the dropdown list
        tableWithPagesPage.dropdownShowEntriesLength().
                selectOptionContainingText(ShowEntries.TEN.getEntry());
        tableWithPagesPage.dropdownShowEntriesLength().
                shouldHave(text(ShowEntries.TEN.getEntry()));
        //12. Assert that for the dropdown there is an individual log row and
        //value is corresponded to the value of dropdown
        String selectedDropdownValue = tableWithPagesPage.
                dropdownShowEntriesLength().getSelectedText();
        tableWithPagesPage.findLogByValue(selectedDropdownValue).isDisplayed();
        //13. Assert that in the table displayed corrected amount of entries
        tableWithPagesPage.tableEntries().
                shouldHaveSize(Integer.valueOf(selectedDropdownValue));
        //14. Type in “Search” text field
        tableWithPagesPage.search().setValue(SEARCH_OPTION).pressEnter();
        //15. Assert the table contains only records with Search field value
        tableWithPagesPage.tableEntries().
                forEach(elem -> elem.shouldHave(text(SEARCH_OPTION)));
    }
}
