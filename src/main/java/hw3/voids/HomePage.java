package hw3.voids;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(css = "[class='row clerafix benefits'] [class='benefit-icon']")
    private List<WebElement> imageElements;

    @FindBy(css = "[class='row clerafix benefits'] .benefit-txt")
    List<WebElement> textElementsUnderIcons;

    @FindBy(name = "main-title")
    private WebElement mainTitle;

    @FindBy(name = "jdi-text")
    private WebElement jdiText;

    @FindBy(tagName = "iframe")
    private WebElement iframe;

    @FindBy(id = "epam_logo")
    private WebElement epamLogo;

    @FindBy(css = "[class='text-center']")
    private WebElement subHeader;

    @FindBy(linkText = "JDI GITHUB")
    private WebElement link;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getLink() {
        return link.getAttribute("href");
    }

    public WebElement getSubHeader() {
        return subHeader;
    }

    // TODO getIFrame
    public WebElement getIframe() {
        return iframe;
    }

    // TODO switchToIFrame
    public void switchToIframe() {
        driver.switchTo().frame(iframe);
    }

    public List<WebElement> getImageElements() {
        return imageElements;
    }

    public List<WebElement> getTextElementsUnderIcons() {
        return textElementsUnderIcons;
    }

    public WebElement getJdiText() {
        return jdiText;
    }

    public WebElement getMainTitle() {
        return mainTitle;
    }

    public WebElement getEpamLogo() {
        return epamLogo;
    }


}
