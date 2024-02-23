package pages.homePage;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.CatalogPage;
import pages.Model;
import pages.SideBar;

public class HomePageTests extends BaseTest {
    HomePage homePage;

    @Before
    public void init () {
        homePage = new HomePage();
        Model model = new Model();
        model.clickCancelButton();
    }

    @Test
    public void whenOpeningPageLogoIsVisible () {
        Assert.assertTrue(homePage.isLogoVisible());
    }

    @Test
    public void whenClickBurgerMenuOpenSideBar () {
        SideBar sideBar = new SideBar();
        homePage.isBurgerMenuVisible();

        homePage.clickBurgerMenu();

        Assert.assertTrue(sideBar.isSideBarVisible());
    }

    @Test
    public void whenClickSearchFieldNavigateToCatalogPage () {
        CatalogPage catalogPage = new CatalogPage();

        homePage.isSearchElementsDispayed();
        homePage.clickSearchField();

        Assert.assertTrue(catalogPage.isCatalogPageDisplayed());
    }

    @Test
    public void whenOpeningPageStoryBarIsVisible () {
        Assert.assertTrue(homePage.isStoryBarDisplayed());
    }


//    @Test
//    public void swipeStory () throws InterruptedException {
//        StoryBar bar = new StoryBar();
//
//        bar.swipeElement();
//        Thread.sleep(3000);
//        System.out.println("Good work!");
//    }
}
