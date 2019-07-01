package hw4;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import hw3.utils.FileUtils;
import hw3.utils.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.nio.file.Paths;

import static com.codeborne.selenide.Selenide.close;

public class BaseTest {

    public static final String title = "Home Page";
    public static final String mainJDILink = "https://epam.github.io/JDI";

    @BeforeMethod
    public void setUp() {
        Configuration.browser = Browsers.CHROME;
        Configuration.startMaximized = true;
        Configuration.pollingInterval = 500;
        Configuration.timeout = 5000;
        Configuration.reportsFolder = "target/selenide/reports/test";
    }

    @AfterMethod
    public void tearDown() {
        close();
    }

    public User readUserDataFromFile(String path) {
        return FileUtils.readUserFromFile(Paths.get(path)
                .toAbsolutePath().toString());

    }

}
