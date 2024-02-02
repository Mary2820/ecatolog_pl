package pages.searchPageTests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.homepage.HomePage;
import pages.SearchPage;
import pages.SearchResultsPage;
import services.DriverService;
import startUp.DriverInitializer;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SearchPageTests {
    private final String expectedResult;
    private final String searchDate;

    public SearchPageTests(String expectedResult, String searchDate) {
        this.expectedResult = expectedResult;
        this.searchDate = searchDate;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Wyniki wyszukiwania dla Zegarki", "Zegarki"},
                {"Wyniki wyszukiwania dla Zegarki2", "Zegarki2"}
        });
    }

    @Test
    public void whenSearchFilled_shouldBeNavigatedToListingPageWithExpectedResult ()  {
        DriverInitializer driverInitializer = new DriverInitializer();
        DriverService driverService = new DriverService(driverInitializer);

        HomePage homePage = new HomePage(driverService);
        SearchPage searchPage = new SearchPage(driverService);
        SearchResultsPage listingPage = new SearchResultsPage(driverService);

        homePage.openSite()
                .navigateToSearchByClick();
        searchPage.enterData(searchDate);

        Assert.assertTrue(listingPage.getSearchResult().contains(expectedResult));
    }
}