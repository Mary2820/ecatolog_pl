package pages.homePageTests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.homepage.Catalog;
import pages.homepage.HomePage;
import services.DriverService;
import startUp.DriverInitializer;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RunWith(Parameterized.class)
public class CatalogTests {
    private final String catalogElement;
    private static String[] catalogElements = {"TELEFONY I GADŻETY", "KOMPUTERY", "FOTO & WIDEO", "TELEWIZJA I PROJEKTORY",
            "AUDIO", "SPRZĘT AGD", "KLIMATYZACJA, OGRZEWANIE I ZAOPATRZENIE W WODĘ", "DOM I REMONT", "DLA DZIECI", "MOTORYZACJA",
            "SPRZĘT OGRODNICZY", "TURYSTYKA I WĘDKARSTWO", "SPORT I REKREACJA", "ZEGARKI, BIŻUTERIA I AKCESORIA"} ;

    public CatalogTests(String catalogElement) {
        this.catalogElement = catalogElement;
    }

    @Parameterized.Parameters
    public static String[] data() {
        return catalogElements;
    }



//    @Test
//    public void whenHomePageIsOpened_shouldBeDisplayedCatalogTitle () {
//        HomePage homePage = new HomePage();
//
//        homePage.openSite();
//
//        homePage.scrollDown(String.valueOf(Catalog.title));
//        Assert.assertTrue(Catalog.title.isDisplayed());
//    }

    @Test
    public void whenHomePageIsOpened_shouldBeDisplayedCatalogItem1 () {
        HomePage homePage = new HomePage(new DriverService(new DriverInitializer()));

        homePage.openSite();
        homePage.scrollDown(catalogElement);

        Assert.assertTrue(homePage.isCatalogItemDisplayed(catalogElement));
    }
}