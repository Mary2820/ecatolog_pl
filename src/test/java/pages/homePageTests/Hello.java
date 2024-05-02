//package pages.homePageTests;
//
//import org.junit.Assert;
//import org.junit.Test;
//import pages.homepage.HomePage;
//import services.DriverService;
//import startUp.DriverInitializer;
//
//public class Hello {
//    @Test
//    public void whenHomePageIsOpened_shouldBeDisplayedCatalogItem1 () {
//        HomePage homePage = new HomePage(new DriverService(new DriverInitializer()));
//
//        homePage.openSite();
//        homePage.scrollDown("ZEGARKI, BIŻUTERIA I AKCESORIA");
//
//        Assert.assertTrue(homePage.isCatalogItemDisplayed("ZEGARKI, BIŻUTERIA I AKCESORIA"));
//    }
//}
