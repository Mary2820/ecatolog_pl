package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import services.DriverService;

import javax.inject.Inject;

public class SearchResultsPage extends BasePage {
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"search_title\"]")
    public WebElement resultsTitle;

    public SearchResultsPage(DriverService driverService) {
        super(driverService);
    }

    public String getSearchResult() {
        driverService.waitElement(resultsTitle);
        return resultsTitle.getText();
    }
}