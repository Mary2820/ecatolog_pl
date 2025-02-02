package pages.homepage;

import models.enums.FindType;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import services.DriverService;

import javax.inject.Inject;

public class CatalogItem extends BasePage {
    public WebElement element;
    public WebElement icon;
    public WebElement arrow;
    public WebElement text;

    public CatalogItem(DriverService driverService) {
        super(driverService);
    }

    public void setElement (String name) {
        String xpathElement = "//android.view.View[@content-desc=\"" + name + " \uE90C\"]";
        element = driverService.findElementBy(FindType.xpath, xpathElement);
        driverService.waitElement(element);

        String xpathIcon = "//android.view.View[@content-desc=\"" + name + " \uE90C\"]/android.widget.Image";
        icon = driverService.findElementBy(FindType.xpath, xpathIcon);
        driverService.waitElement(icon);

        String xpathArrow = "//android.view.View[@content-desc=\"" + name + " \uE90C\"]/android.widget.TextView[2]";
        arrow = driverService.findElementBy(FindType.xpath, xpathArrow);

        text = getElementText(name);
    }

    public WebElement getElementText (String name) {
        String xpathText = "//android.widget.TextView[@text = \"" + name + "\"]";
        text = driverService.findElementBy(FindType.xpath, xpathText);
        return text;
    }
}