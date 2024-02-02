package pages.homepage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import services.DriverService;

public class Catalog extends BasePage {
    @FindBy(xpath = "//android.widget.TextView[@text = \"Katalog produktów\"]")
    public static WebElement title;

    private DriverService driverService;

    public Catalog(DriverService driverService) {
        super(driverService);
    }

    public CatalogItem findItemByName(String expectedItemName) {
        CatalogItem item = new CatalogItem(driverService);
        item.setElement(expectedItemName);
        return item;
    }

    public WebElement getElementText (String text) {
        CatalogItem item = new CatalogItem(driverService);
        return item.getElementText(text);
    }
}