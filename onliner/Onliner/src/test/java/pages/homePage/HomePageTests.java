package pages.homePage;

import base.BaseTest;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CatalogPage;
import pages.Model;
import pages.SideBar;

public class HomePageTests extends BaseTest {
    HomePage homePage;

    @BeforeTest
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

    @Test
    public void whenOpeningPageCardsCarouselIsVisiable () {
        Assert.assertTrue(homePage.isCardsCarouselDisplayed());
    }

    @Test
    public void whenOpeningPageDiscountGridIsVisible () {
        DiscountGrid discountGrid = new DiscountGrid();

        Assert.assertTrue(discountGrid.isDiscountGridDisplayed());
    }

    @DataProvider(name = "gridElements")
    public Object[][] gridElements() {
        return new Object[][] {
                {"Все скидки Каталога!"},
                {"Игровые приставки"},
                {"Смартфоны"},
                {"Ноутбуки"},
                {"Наушники"},
                {"Телевизоры"},
                {"Стиральные машины"},
                {"Холодильники"},
                {"Роботы-пылесосы"},
                {"Пылесосы"},
                {"Моторные масла"},
                {"Видеокарты"}
        };
    }

    @Test(dataProvider = "gridElements")
    public void whenOpeningPageGridsElementIsVisible (String element) {
        DiscountGrid discountGrid = new DiscountGrid();

        Assert.assertTrue(discountGrid.isGridElementDisplayed(element));
    }
}
