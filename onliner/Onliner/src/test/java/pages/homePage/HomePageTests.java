package pages.homePage;

import org.junit.Assert;
import org.junit.Test;
import pages.CatalogPage;
import pages.HomePage;
import pages.Model;

public class HomePageTests {

    @Test
    public void test () {
        Model model = new Model();
        model.clickCancelButton();
        HomePage homePage = new HomePage();
        CatalogPage catalogPage = new CatalogPage();

        homePage.isSearchElementsDispayed();
        homePage.clickSearchField();

        Assert.assertTrue(catalogPage.isCatalogPageDisplayed());
    }
}
