package pages.homepage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import services.DriverService;

public class HomePage extends BasePage {
    private Catalog catalog = null;
    private DriverService driverService;

    @FindBy(xpath = "//android.view.View/android.widget.EditText")
    public WebElement searchField;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[1]/android.view.View/android.view.View")
    public WebElement carouselView;

    public HomePage(DriverService driverService) {
        super(driverService);
    }

    public void navigateToSearchByClick() {
        driverService.waitElement(searchField);
        searchField.click();
    }

    public HomePage openSite() {
        driverService.openSite();
        return this;
    }

    public boolean isCatalogItemDisplayed (String expectedItemName) {
        catalog = new Catalog(driverService);
        CatalogItem item = catalog.findItemByName(expectedItemName);

        return item.arrow.isDisplayed() &&
                item.text.isDisplayed() &&
                item.element.isDisplayed() &&
                item.icon.isDisplayed();
    }

    public void scrollDown (String elementText) {
        driverService.waitElement(searchField);
        WebElement text = getElementText(elementText);
        while (text == null) {
            driverService.scrollDown();
            text = getElementText(elementText);
        }
    }

    public void swipeCarouselView () {
        driverService.waitElement(carouselView);
        driverService.swipeLeft(carouselView);
    }

    private WebElement getElementText (String text) {
        catalog = new Catalog(driverService);
        return catalog.getElementText(text);
    }
}
//    @FindBy(xpath = "//android.widget.Button[1]")
//    public WebElement carouselButton1;
//
//    @FindBy(xpath = "//android.widget.Button[2]")
//    public WebElement carouselButton2;
//
//    @FindBy(xpath = "//android.widget.Button[3]" )
//    public WebElement carouselButton3;
//
//    @FindBy(xpath = "//android.widget.Button[4]")
//    public WebElement carouselButton4;