package pages.homePage;

import info.InfoFromApi;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Model;

import java.util.HashMap;

public class FrameTopDiscountsTests {
    HomePage homePage;
    FrameTopDiscounts frame;
    HashMap<String, String> card1 = InfoFromApi.getValueFromCard1();

    @BeforeMethod
    public void init() {
        homePage = new HomePage();
        frame = new FrameTopDiscounts();
        Model model = new Model();
        model.clickCancelButton();
    }

    @Test
    public void isTitleVisible() {
        String title = card1.get("title");
        Assert.assertTrue(frame.isTitleDisplayed(title));
    }
}
