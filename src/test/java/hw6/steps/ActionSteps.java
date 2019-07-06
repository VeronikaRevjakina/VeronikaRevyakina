package hw6.steps;

import cucumber.api.java.en.When;
import hw3.enums.Menu;
import hw6.entities.User;
import hw6.hooks.TestContext;

import java.util.List;

public class ActionSteps extends BaseSteps {

    @When("I login as user with")
    public void iLoginAs(List<User> users ){
        User user=users.get(0);
        homePage.userIconClick();
        homePage.fillLoginTextField(user.getUserName());
        homePage.fillPasswordTextField(user.getPassword());
        homePage.loginButtonClick();
    }

    @When("I open test site by URL '([^\"]*)'")
    public void openSiteByLink(String link){
        TestContext.getDriver().get(link);
    }

    @When("I click on '(Home|Service)' button in Header")
    public void iClickOnHeaderMenuButtonByItem(Menu menuItem) {
        homePage.clickHeaderMenuButton(menuItem);
    }

    @When("I click '(Home|Service)' left side menu button")
    public void clickLeftSideMenuButtonByItem(Menu menuItem){
        homePage.clickLeftMenuSectionElement(menuItem);
    }

    @When("I click on '([^\"]*)' button in Service dropdown")
    public void iClickServiceHeaderOptionDropdown(String dropdownOption){
        diffElemPage.clickServiceDropdownOption(dropdownOption);
    }

    @When("I click '([^\"]*)' checkbox")
    public void selectCheckboxByText(String selectedCheckbox){
        diffElemPage.clickCheckboxByText(selectedCheckbox);
    }

    @When("I click '([^\"]*)' radio")
    public void selectRadioByText(String selectedRadio){
        diffElemPage.clickRadioByText(selectedRadio);
    }

    @When("I click '([^\"]*)' option in Colors dropdown")
    public void selectDropdownOptionByText(String selectedDropdownOption){
        diffElemPage.clickDropdownOptionByText(selectedDropdownOption);
    }

    @When("I select vip checkbox for '([^\"]*)'")
    public void selectVipCheckboxForUserByName(String userNameText){
        userTablePage.clickVipCheckboxForUserByName(userNameText);
    }

    @When("I click on dropdown in column Type for user '([^\"]*)'")
    public void selectDropdownInUserTableByUserName(String userNameText){
        userTablePage.clickDropdownInUserTableByUserName(userNameText);
    }

}
