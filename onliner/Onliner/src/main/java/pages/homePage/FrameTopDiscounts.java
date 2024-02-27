package pages.homePage;

import enums.FindType;
import info.InfoFromApi;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import services.DriverService;

import java.util.HashMap;

public class FrameTopDiscounts extends BasePage {
    @FindBy(xpath = "//android.widget.TextView[contains(@text,\"Топ лучших скидок\")]")
    private WebElement title;

    public boolean isTitleDisplayed(String titleText) {
        DriverService.scrollDown1(titleText);
        DriverService.waitElementUseElement(title);
        return title.isDisplayed();
    }

    public boolean isPriceDisplayed(String priceText) {
        return getPrice(priceText).isDisplayed();
    }

    private WebElement getPrice(String priceText) {
        String priceXpath = "//android.widget.TextView[@resource-id=\"by.onliner.catalog:id/price\" and @text=\"" + priceText + "\"]";
        return DriverService.findElementBy(FindType.xpath, priceXpath);
    }


}
