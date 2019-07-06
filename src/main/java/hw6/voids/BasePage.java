package hw6.voids;

import hw3.enums.Menu;
import hw3.enums.ServiceDropdownOptions;
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
    private WebElement loginNameTextField;

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

    public void userIconClick() {
        userIcon.click();
    }

    public void fillLoginTextField(String username) {
        loginNameTextField.sendKeys(username);
    }

    public void fillPasswordTextField(String password) {
        this.password.sendKeys(password);
    }

    public void loginButtonClick() {
        loginButton.click();
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void clickLeftMenuSectionElement(Menu menuItem) {
        driver.findElement(By.linkText(menuItem.getName())).click();
    }

    public void clickHeaderMenuButton(Menu menuItem) {
        driver.findElement(By
                .xpath("//ul[contains(@class, 'nav')]//a[contains(.,'"
                        + menuItem.getName() + "')]")).click();
    }

    public void clickServiceDropdownOption
            (String serviceDropdownElement) {
        driver.findElement(By.linkText
                (serviceDropdownElement)).click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public WebElement getUserNameWebElement() {
        return userNameText;
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
