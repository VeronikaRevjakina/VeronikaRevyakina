package hw6.voids;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UserTablePage extends BasePage {

    private static UserTablePage instance;

    @FindBy(tagName = "select")
    private List<WebElement> numberTypeDropdowns;

    @FindBy(css = "#user-table> tbody> tr> td a")
    private List<WebElement> userNames;

    @FindBy(xpath = "//td/img")
    private List<WebElement> images;

    @FindBy(css = "[class='user-descr']> span")
    private List<WebElement> descriptionTextsUnderImages;

    @FindBy(css = "[type='checkbox']")
    private List<WebElement> checkboxes;

    @FindBy(id = "user-table")
    private WebElement userTable;

    @FindBy(xpath = "//*[@id='user-table']//tr")
    private List<WebElement> userTableRows;

    @FindBy(css = "[class='panel-body-list logs']> li")
    private List<WebElement> logRow;

    private UserTablePage(WebDriver driver) {
        super(driver);
    }

    public void clickVipCheckboxForUserByName(String userName) {
        WebElement userRow = getUserRowByUserName(userName);
        WebElement checkBox = userRow.findElement
                (By.cssSelector("[type='checkbox'"));
        checkBox.click();
    }

    public void clickDropdownInUserTableByUserName(String userName){
        WebElement userRow = getUserRowByUserName(userName);
        WebElement dropdown = userRow.findElement
                (By.tagName("select"));
        dropdown.click();
    }

    public WebElement findLogRowStringByNumber(int number){
        return logRow.get(number-1);
    }

    public WebElement getUserRowByUserName(String userName) {
        return userTable.findElement(By.xpath("//*[contains(text(), " +
                    "'" + userName + "')]//ancestor::tr"));
    }

    public List<WebElement> getNumberTypeDropdowns() {
        return numberTypeDropdowns;
    }

    public List<WebElement> getUserNames() {
        return userNames;
    }

    public List<WebElement> getImages() {
        return images;
    }

    public List<WebElement> getDescriptionTextsUnderImages() {
        return descriptionTextsUnderImages;
    }

    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }

    public WebElement getUserTable() {
        return userTable;
    }

    public List<WebElement> getDropdownValuesByUserName(String userName) {
        return driver.findElements(By.xpath("//tr[contains(., '" + userName +
                "')]//option"));
    }

    public List<WebElement> getUserTableRows() {
        return userTableRows;
    }

    public static UserTablePage getInstance(WebDriver driver) {
        if (instance == null) {
            instance = new UserTablePage(driver);
        }
        return instance;
    }
}
