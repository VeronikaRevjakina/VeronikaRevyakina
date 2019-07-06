package hw6.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import hw3.enums.Menu;
import hw3.utils.User;
import hw6.hooks.TestContext;

public class GivenSteps extends BaseSteps {

    @Given("I am on Home Page")
    public void openPageByStringTitle() {
            TestContext.getDriver().get("https://epam.github.io/JDI/index.html");
    }

    @Given("Login as Piter Chailovski")
    public void loginAsStandardUser() {
        User user = readUserDataFromFile
                ("src/test/resources//properties/user.properties");
        homePage.userIconClick();
        homePage.fillLoginTextField(user.getUserName());
        homePage.fillPasswordTextField(user.getPassword());
        homePage.loginButtonClick();
    }

    @When("I click header menu '(Home|Service)' button")
    public void clickHeaderMenuButtonByItem(Menu menuItem) {
        homePage.clickHeaderMenuButton(menuItem);
    }

}
