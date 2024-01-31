package pages.homepage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class Catalog extends BasePage {
    @FindBy(xpath = "//android.widget.TextView[@text = \"Katalog produktów\"]")
    public static WebElement title;

    public CatalogItem findItemByName(String expectedItemName) {
        CatalogItem item = new CatalogItem();
        item.setElement(expectedItemName);
        return item;
    }

    public WebElement getElementText (String text) {
        CatalogItem item = new CatalogItem();
        return item.getElementText(text);
    }
}