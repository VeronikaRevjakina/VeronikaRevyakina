package hw3.voids;

import hw3.enums.Menu;
import hw3.enums.ServiceDropdownOptions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

    protected WebDriver driver;

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement userName;

    private WebElement password;

    @FindBy(xpath = "//button[@id='login-button']")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    private WebElement userNameText;

    @FindBy(css = "[class='uui-navigation nav navbar-nav m-l8']>li")
    private List<WebElement> menuHeaderSectionElements;

    @FindBy(name = "navigation-sidebar")
    private WebElement leftSection;

    @FindBy(className = "footer-bg")
    private WebElement footer;

    @FindBy(xpath = "//li[@class='menu-title' and contains(.//span,'Service')]" +
            "//li//span")
    private List<WebElement> dropDownLeftService;

    @FindBy(xpath = "//li[@class='dropdown']//a[contains(text(), " +
            "'Service')]")
    private WebElement serviceHeader;

    @FindBy(xpath = "//*[@class='dropdown open'" +
            "]//ul[@class='dropdown-menu']//li")
    private List<WebElement> dropDownHeaderService;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Login as user")
    public void performLogin(String name, String password) {
        userIcon.click();
        userName.sendKeys(name);
        this.password.sendKeys(password);
        loginButton.click();
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void clickMenuHeaderSectionElement(Menu menuItem) {
        driver.findElement(By.linkText(menuItem.getName())).click();
    }

    public void clickServiceHeader() {
        serviceHeader.click();
    }

    public void clickServiceDropdownOption
            (ServiceDropdownOptions serviceDropdownElement) {
        driver.findElement(By.linkText
                (serviceDropdownElement.getServiceDropdownElement())).click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getUserNameText() {
        return userNameText.getText();
    }


    public List<WebElement> getDropDownHeaderService() {
        return dropDownHeaderService;
    }

    public List<WebElement> getDropDownLeftService() {
        return dropDownLeftService;
    }

    public List<WebElement> getMenuHeaderSectionElements() {
        return menuHeaderSectionElements;
    }

    public WebElement getLeftSection() {
        return leftSection;
    }

    public WebElement getFooter() {
        return footer;
    }


}
