package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import services.DriverService;

public class SearchPage extends BasePage {
    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"ek-search\"]")
    private WebElement entryField;

    public void enterData(String searchData) {
        DriverService.waitElement(entryField);
        entryField.click();
        DriverService.waitElement(entryField);
        entryField.sendKeys(searchData);
        DriverService.hideKeyboard();
    }
}