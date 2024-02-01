package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import services.DriverService;

public class HomePage extends BasePage {
    @FindBy(xpath = "//androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ImageView")
    WebElement title;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    WebElement burgerMenu;

    @FindBy(id = "by.onliner.catalog:id/searchPlate")
    WebElement searchElement;

    @FindBy(xpath = "//androidx.drawerlayout.widget.DrawerLayout//android.widget.LinearLayout/android.widget.ImageView")
    WebElement searchIcon;

    @FindBy(xpath = "//android.widget.TextView[@text = \"Поиск в каталоге\"]")
    WebElement searchText;

    public boolean isSearchElementsDispayed () {
        DriverService.waitElement(searchElement);
        return searchElement.isDisplayed() && searchIcon.isDisplayed() && searchText.isDisplayed();
    }

    public void clickSearchField () {
        DriverService.waitElement(searchElement);
        searchElement.click();
    }
}
