package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeTest;
import services.DriverService;

public class Model extends BasePage {
    @FindBy(xpath = "//android.widget.TextView[@text = \"Не сейчас\"]")
    private WebElement cancelButton;

    public void clickCancelButton () {
        DriverService.waitElement(cancelButton);
        cancelButton.isDisplayed();
        cancelButton.click();
    }
}
