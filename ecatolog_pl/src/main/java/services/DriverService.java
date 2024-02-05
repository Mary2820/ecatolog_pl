package services;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.proxy.NotImplementedException;
import models.enums.FindType;
import models.enums.PlatformName;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import startUp.DriverInitializer;
import utils.constants.Configuration;
import utils.constants.Urls;

import javax.inject.Inject;
import java.time.Duration;
import java.util.Collections;

public class DriverService {
    private final AppiumDriver driver;
    private final int deviceWidth;
    private final int deviceHeight;


    @Inject
    public DriverService(DriverInitializer driverInitializer) {
        driver = driverInitializer.getDriver();

        deviceWidth = getDeviceWidth();
        deviceHeight = getDeviceHeight();
    }

    public void initPageElements(Object page) {
        PageFactory.initElements(driver, page);
    }

    public void hideKeyboard() {
        if (PlatformName.Android == Configuration.PLATFORM) {
            ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.ENTER));
        } else if (PlatformName.iOS == Configuration.PLATFORM) {
            throw new NotImplementedException();
        }
    }

    public void waitElement(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfAllElements(webElement));
    }

    public void openSite() {
        driver.get(Urls.URL_SITE);
    }

    public WebElement findElementBy(FindType findType, String path) {
        By by = null;
        if (findType == FindType.xpath) {
            by = AppiumBy.xpath(path);
        } else if (findType == FindType.id) {
            by = AppiumBy.id(path);
        }
        WebElement element = null;
        try {
            element = driver.findElement(by);
        } catch (Exception e) {
            System.out.println("element doesn't found");
            System.out.println(e.getMessage());
        }
        return element;
    }

    public void scrollDown() {
        int heightOneEight = deviceHeight / 8;
        int heightQuarter = deviceHeight / 4;
        int widthHalf = deviceWidth / 2;

        Point point1 = new Point(widthHalf, heightQuarter);
        Point point2 = new Point(widthHalf, heightQuarter-heightOneEight);

        moveFingerByCoordinates(point1, point2);
    }

    public void swipeLeft(WebElement element) {
        int widthQuarter = deviceWidth / 4;
        int widthHalf = deviceWidth / 2;
        Point elementLocation = element.getLocation();

        Point point1 = new Point(widthHalf, elementLocation.y);
        Point point2 = new Point(widthHalf - widthQuarter, elementLocation.y);

        moveFingerByCoordinates(point1, point2);
    }

    private Dimension getWindowsSize () {
        return driver.manage().window().getSize();
    }

    private int getDeviceHeight() {
        return getWindowsSize().getHeight();
    }

    private int getDeviceWidth() {
        return getWindowsSize().getWidth();
    }

    private void moveFingerByCoordinates(Point point1, Point point2) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scroll = new Sequence(finger, 1);
        scroll.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), point1.x, point1.y));
        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        scroll.addAction(finger.createPointerMove(Duration.ofMillis(250), PointerInput.Origin.viewport(), point2.x, point2.y));

        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(scroll));
    }
}