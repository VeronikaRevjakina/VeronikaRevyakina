package hw6.steps;

import hw3.utils.FileUtils;
import hw3.utils.User;
import hw6.hooks.TestContext;
import hw6.voids.DifferentElementsPage;
import hw6.voids.HomePage;
import hw6.voids.UserTablePage;

import java.nio.file.Paths;

public abstract class BaseSteps {

    protected HomePage homePage;
    protected DifferentElementsPage diffElemPage;
    protected UserTablePage userTablePage;

    public BaseSteps() {
        homePage = HomePage.getInstance(TestContext.getDriver());
        diffElemPage=DifferentElementsPage.getInstance(TestContext.getDriver());
        userTablePage=UserTablePage.getInstance(TestContext.getDriver());
    }

    public User readUserDataFromFile(String path) {
        return FileUtils.readUserFromFile(Paths.get(path)
                .toAbsolutePath().toString());

    }
}
