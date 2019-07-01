package hw4.voids;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class TableWithPagesPage extends BasePage {
    @FindBy(name = "table-with-pages_length")
    private SelenideElement dropdownShowEntriesLength;

    @FindBy(css = "#table-with-pages tbody > tr")
    private ElementsCollection tableEntries;

    @FindBy(css = "input[type='search']")
    private SelenideElement search;

    @FindBy(name = "log-sidebar")
    private SelenideElement rightSectionLog;

    @FindBy(className = "panel-body-list logs")
    private ElementsCollection logs;

    public SelenideElement dropdownShowEntriesLength() {
        return dropdownShowEntriesLength;
    }

    public ElementsCollection tableEntries() {
        return tableEntries;
    }

    public SelenideElement findLogByValue(String value) {
        return logs.findBy(Condition.text("new value=" + value));
    }

    public SelenideElement search() {
        return search;
    }

    public SelenideElement rightSectionLog() {
        return rightSectionLog;
    }
}
