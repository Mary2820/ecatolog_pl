package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import services.DriverService;

public class SearchResultsPage extends BasePage {
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"search_title\"]")
    public WebElement resultsTitle;

    public String getSearchResult() {
        DriverService.waitElement(resultsTitle);
        return resultsTitle.getText();
    }
}