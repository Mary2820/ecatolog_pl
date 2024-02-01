package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import services.DriverService;

public class CatalogPage extends BasePage {
    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    WebElement searchIcon;

    public boolean isCatalogPageDisplayed () {
        DriverService.waitElement(searchIcon);
        return searchIcon.isDisplayed();
    }
}
