package pages.homepage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import services.DriverService;

public class HomePage extends BasePage {
    private Catalog catalog = null;

    @FindBy(xpath = "//android.view.View/android.widget.EditText")
    public WebElement searchField;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[1]/android.view.View/android.view.View")
    public WebElement carouselView;

    public void navigateToSearchByClick() {
        DriverService.waitElement(searchField);
        searchField.click();
    }

    public HomePage openSite() {
        DriverService.openSite();
        return this;
    }

    public boolean isCatalogItemDisplayed (String expectedItemName) {
        catalog = new Catalog();
        CatalogItem item = catalog.findItemByName(expectedItemName);

        return item.arrow.isDisplayed() &&
                item.text.isDisplayed() &&
                item.element.isDisplayed() &&
                item.icon.isDisplayed();
    }

    public void scrollDown (String elementText) {
        DriverService.waitElement(searchField);
        WebElement text = getElementText(elementText);
        while (text == null) {
            DriverService.scrollDown();
            text = getElementText(elementText);
        }
    }

    public void swipeCarouselView () {
        DriverService.waitElement(carouselView);
        DriverService.swipeLeft(carouselView);
    }

    private WebElement getElementText (String text) {
        catalog = new Catalog();
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