package pages.homePageTests;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.homepage.HomePage;
import services.DaggerDriverComponents;
import services.DriverComponents;
import services.DriverService;

@RunWith(Parameterized.class)
public class CatalogTests {
    private static HomePage homePage;
    private final String catalogElement;
    private static final String[] catalogElements = {"TELEFONY I GADŻETY", "KOMPUTERY", "FOTO & WIDEO", "TELEWIZJA I PROJEKTORY",
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

    @BeforeClass
    public static void initTests(){
        DriverComponents driverComponents = DaggerDriverComponents.builder().build();
        homePage = driverComponents.getHomePage();
    }

    @Test
    public void whenHomePageIsOpened_shouldBeDisplayedCatalogItem1 () {
        homePage.openSite();
        homePage.scrollDown(catalogElement);

        Assert.assertTrue(homePage.isCatalogItemDisplayed(catalogElement));
    }
}