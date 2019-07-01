package hw3;

import hw3.utils.FileUtils;
import hw3.utils.User;
import hw3.voids.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    // TODO Java code style for the constants--Fixed
    public static final String TITLE = "Home Page";

    protected WebDriver driver;
    protected HomePage hp;

    @BeforeSuite
    public void setUpDriverPath() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        // 1. Open test site by URL
        driver.get("https://epam.github.io/JDI");
        hp=PageFactory.initElements(driver,HomePage.class);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
    }

    public User readUserDataFromFile(String path) {
        return FileUtils.readUserFromFile(Paths.get(path)
                .toAbsolutePath().toString());

    }

    //17. Close Browser
    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
