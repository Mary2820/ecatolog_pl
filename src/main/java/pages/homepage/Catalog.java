package pages.homepage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import services.DriverService;

import javax.inject.Inject;

public class Catalog extends BasePage {
    private CatalogItem item;
    @FindBy(xpath = "//android.widget.TextView[@text = \"Katalog produktów\"]")
    public static WebElement title;

    public Catalog(DriverService driverService) {
        super(driverService);
    }

    public CatalogItem findItemByName(String expectedItemName) {
        item = new CatalogItem(driverService);
        item.setElement(expectedItemName);
        return item;
    }

    public WebElement getElementText (String text) {
        item = new CatalogItem(driverService);
        return item.getElementText(text);
    }
}