package pages.searchPageTests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.homepage.HomePage;
import pages.SearchPage;
import pages.SearchResultsPage;

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
        HomePage homePage = new HomePage();
        SearchPage searchPage = new SearchPage();
        SearchResultsPage listingPage = new SearchResultsPage();

        homePage.openSite()
                .navigateToSearchByClick();
        searchPage.enterData(searchDate);

        Assert.assertTrue(listingPage.getSearchResult().contains(expectedResult));
    }
}