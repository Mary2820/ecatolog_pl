package pages.homepage;

import models.enums.FindType;
import org.openqa.selenium.WebElement;
import services.DriverService;

public class CatalogItem {
    public WebElement element;
    public WebElement icon;
    public WebElement arrow;
    public WebElement text;

    public void setElement (String name) {
        String xpathElement = "//android.view.View[@content-desc=\"" + name + " \uE90C\"]";
        element = DriverService.findElementBy(FindType.xpath, xpathElement);
        DriverService.waitElement(element);

        String xpathIcon = "//android.view.View[@content-desc=\"" + name + " \uE90C\"]/android.widget.Image";
        icon = DriverService.findElementBy(FindType.xpath, xpathIcon);
        DriverService.waitElement(icon);

        String xpathArrow = "//android.view.View[@content-desc=\"" + name + " \uE90C\"]/android.widget.TextView[2]";
        arrow = DriverService.findElementBy(FindType.xpath, xpathArrow);

        text = getElementText(name);
    }

    public WebElement getElementText (String name) {
        String xpathText = "//android.widget.TextView[@text = \"" + name + "\"]";
        text = DriverService.findElementBy(FindType.xpath, xpathText);
        return text;
    }
}