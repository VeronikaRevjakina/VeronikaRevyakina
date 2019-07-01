package hw4.ex2;

import hw3.enums.DifferentElements.CheckboxForces;
import hw3.enums.DifferentElements.DropdownColors;
import hw3.enums.DifferentElements.RadioMetals;
import hw3.enums.DifferentElements.Vegetables;
import hw3.enums.Menu;
import hw3.enums.ResultOptions;
import hw3.utils.User;
import hw4.BaseTest;
import hw4.data.MetalsAndColorsData;
import hw4.voids.BasePage;
import hw4.voids.MetalsAndColorsPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static org.testng.Assert.assertEquals;

public class Exercise2Test extends BaseTest {

    static final String titleMetalsAndColorsPage = "Metal and Colors";

    @DataProvider(name = "test data builder")
    public static Object[][] testDataBuilderProvider() {
        return new Object[][]{
                {MetalsAndColorsData.builder()
                        .elements(Arrays.asList(CheckboxForces.EARTH))
                        .colors(Arrays.asList(DropdownColors.YELLOW))
                        .metals(Arrays.asList(RadioMetals.GOLD))
                        .build()},
                {MetalsAndColorsData.builder()
                        .summary(Arrays.asList("3", "8"))
                        .vegetables(Arrays.asList(Vegetables.CUCUMBER,
                                Vegetables.TOMATO))
                        .build()},
                {MetalsAndColorsData.builder()
                        .summary(Arrays.asList("3", "2"))
                        .elements(Arrays.asList(CheckboxForces.WIND,
                                CheckboxForces.FIRE, CheckboxForces.WATER))
                        .metals(Arrays.asList(RadioMetals.BRONZE))
                        .vegetables(Arrays.asList(Vegetables.ONION))
                        .build()},
                {MetalsAndColorsData.builder()
                        .summary(Arrays.asList("6", "5"))
                        .elements(Arrays.asList(CheckboxForces.WATER))
                        .colors(Arrays.asList(DropdownColors.GREEN))
                        .metals(Arrays.asList(RadioMetals.SELEN))
                        .vegetables(Arrays.asList(Vegetables.CUCUMBER,
                                Vegetables.ONION, Vegetables.TOMATO,
                                Vegetables.VEGETABLES))
                        .build()},
                {MetalsAndColorsData.builder()
                        .elements(Arrays.asList(CheckboxForces.FIRE))
                        .colors(Arrays.asList(DropdownColors.BLUE))
                        .vegetables(Arrays.asList(Vegetables.CUCUMBER,
                                Vegetables.TOMATO, Vegetables.VEGETABLES))
                        .build()}};
    }

    @Test(dataProvider = "test data builder")
    public void exercise2Test(MetalsAndColorsData testDataObject) {
        // 1. Open test site by URL
        BasePage basePage = open(mainJDILink, BasePage.class);
        //2. Assert Browser title
        assertEquals(title(), title);
        //3. Perform login
        User user = readUserDataFromFile
                ("src/test/resources//properties/user.properties");
        basePage.performLogin(user.getUserName(), user.getPassword());
        //4.Click on the link on the Header section
        basePage.clickMenuHeaderSectionElement(Menu.METALS_AND_COLORS);
        MetalsAndColorsPage metalsAndColorsPage = new MetalsAndColorsPage();
        assertEquals(title(), titleMetalsAndColorsPage);
        //5. Fill form on the page
        if (testDataObject.getSummary() != null) {
            for (String summaryData : testDataObject.getSummary()) {
                metalsAndColorsPage.clickSummaryByValue(summaryData);
            }
            metalsAndColorsPage.clickCalculateButton();
        }

        if (testDataObject.getElements() != null) {
            for (CheckboxForces elementsData : testDataObject.getElements()) {
                metalsAndColorsPage.clickElementByEnumValue(elementsData);
            }
        }

        if (testDataObject.getColors() != null) {
            metalsAndColorsPage.clickColorsButton();
            for (DropdownColors colorsData : testDataObject.getColors()) {
                metalsAndColorsPage.clickColorByEnumValue(colorsData);
            }
        }

        if (testDataObject.getMetals() != null) {
            metalsAndColorsPage.clickMetalsButton();
            for (RadioMetals metalsData : testDataObject.getMetals()) {
                metalsAndColorsPage.clickMetalByEnumValue(metalsData);
            }
        }

        if (testDataObject.getVegetables() != null) {
            metalsAndColorsPage.clickVegetablesButton();
            for (Vegetables vegetableData : testDataObject.getVegetables()) {
                metalsAndColorsPage.clickVegetableByEnumValue(vegetableData);
            }
        }
        //6. Click “Submit” button
        metalsAndColorsPage.submitClick();
        //7. Check Results block output on the right-side
        if (testDataObject.getSummary() != null) {
            int result = 0;
            for (String summaryData : testDataObject.getSummary()) {
                result = result + Integer.valueOf(summaryData);

            }
            metalsAndColorsPage.findResultBlockByOption
                    (ResultOptions.SUMMARY.getOption())
                    .shouldHave(text(String.valueOf(result)));
        }

        if (testDataObject.getElements() != null) {
            for (CheckboxForces elementsData : testDataObject.getElements()) {
                metalsAndColorsPage.findResultBlockByOption
                        (ResultOptions.ELEMENTS.getOption())
                        .shouldHave(text(elementsData.getForce()));

            }
        }

        if (testDataObject.getColors() != null) {
            for (DropdownColors colorsData : testDataObject.getColors()) {
                metalsAndColorsPage.findResultBlockByOption
                        (ResultOptions.COLOR.getOption())
                        .shouldHave(text(colorsData.getColor()));
            }
        }

        if (testDataObject.getMetals() != null) {
            for (RadioMetals metalsData : testDataObject.getMetals()) {
                metalsAndColorsPage.findResultBlockByOption
                        (ResultOptions.METAL.getOption())
                        .shouldHave(text(metalsData.getMetal()));
            }
        }

        if (testDataObject.getVegetables() != null) {
            for (Vegetables vegetableData : testDataObject.getVegetables()) {
                metalsAndColorsPage.findResultBlockByOption
                        (ResultOptions.VEGETABLES.getOption())
                        .shouldHave(text(vegetableData.getVegetable()));

            }
        }
    }
}
