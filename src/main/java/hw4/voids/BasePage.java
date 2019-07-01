package hw4.voids;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import hw3.enums.Menu;
import hw3.enums.ServiceDropdownOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class BasePage {
    @FindBy(id = "user-icon")
    private SelenideElement userIcon;

    @FindBy(id = "name")
    private SelenideElement userName;

    @FindBy(xpath = "//button[@id='login-button']")
    private SelenideElement loginButton;

    @FindBy(id = "user-name")
    private SelenideElement userNameText;

    @FindBy(css = "[class='uui-navigation nav navbar-nav m-l8']>li")
    private ElementsCollection menuHeaderSectionElements;

    @FindBy(name = "navigation-sidebar")
    private SelenideElement leftSection;

    @FindBy(xpath = "//li[@class='menu-title' and contains(.//span,'Service')]" +
            "//li//span")
    private ElementsCollection dropDownLeftService;

    @FindBy(xpath = "//li[@class='dropdown']//a[contains(text(), " +
            "'Service')]")
    private SelenideElement serviceHeader;

    @FindBy(xpath = "//*[@class='dropdown open'" +
            "]//ul[@class='dropdown-menu']//li")
    private ElementsCollection dropDownHeaderService;


    public BasePage() {
        page(this);
    }

    public void performLogin(String name, String password) {
        userIcon.click();
        userName.sendKeys(name);
        $(By.id("password")).sendKeys(password);
        loginButton.click();
    }

    public SelenideElement userNameText() {
        return userNameText;
    }

    public void clickMenuHeaderSectionElement(Menu menuItem) {
        $(By.linkText(menuItem.getName())).click();
    }

    public void clickServiceHeader() {
        serviceHeader.click();
    }

    public void clickServiceDropdownOption
            (ServiceDropdownOptions serviceDropdownElement) {
        $(By.linkText
                (serviceDropdownElement.getServiceDropdownElement())).click();
    }

    public ElementsCollection dropDownHeaderService() {
        return dropDownHeaderService;
    }

    public ElementsCollection dropDownLeftService() {
        return dropDownLeftService;
    }

    public ElementsCollection menuHeaderSectionElements() {
        return menuHeaderSectionElements;
    }

    public SelenideElement leftSection() {
        return leftSection;
    }

}
