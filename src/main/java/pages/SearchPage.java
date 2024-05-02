package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import services.DriverService;

import javax.inject.Inject;

public class SearchPage extends BasePage {
    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"ek-search\"]")
    private WebElement entryField;
    public SearchPage(DriverService driverService) {
        super(driverService);
    }

    public void enterData(String searchData) {
        driverService.waitElement(entryField);
        entryField.click();
        driverService.waitElement(entryField);
        entryField.sendKeys(searchData);
        driverService.hideKeyboard();
    }
}