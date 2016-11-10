package ru.bk.akadnikov.tests;

import org.junit.Ignore;
import org.junit.experimental.categories.Category;
import ru.bk.akadnikov.pages.TabletExtendedSearchPage;
import ru.bk.akadnikov.steps.CheckSteps;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import ru.bk.akadnikov.pages.MainPage;
import ru.bk.akadnikov.pages.NotebookExtendedSearchPage;
import ru.yandex.qatools.allure.annotations.Title;

import java.util.List;

@Title("Яндекс маркет - Планшеты")
public class MarketTablet extends JUnitTestBase {

    @Title("Тест")
    @Test
    public void MarketTabletTest() {

        final String PRICE_FROM = "20000";
        final String PRICE_TO = "25000";
        final String MANUFACTURER_1 = "Acer";
        final String MANUFACTURER_2 = "DELL";
        final int DEFAULT_RESULTS_COUNT = 12;

        TabletExtendedSearchPage page = (TabletExtendedSearchPage) new MainPage(driver)
                .chooseMarket()
                .chooseComputers()
                .chooseTablets()
                .goToExtendedSearch()
                .setPriceFrom(PRICE_FROM)
                .setPriceTo(PRICE_TO)
                .clickOnMoreButton()
                .chooseManufacturer(MANUFACTURER_1)
                .chooseManufacturer(MANUFACTURER_2)
                .clickOnApplyButton();

        List<WebElement> results = page.getResults();

        CheckSteps.checkResultsCount(results, DEFAULT_RESULTS_COUNT);

        String firstResultTitle = page.getFirstResultTitle();
        String productTitle = page.search(firstResultTitle)
                .getProductTitle();

        CheckSteps.checkProductTitle(productTitle, firstResultTitle);
    }

}
