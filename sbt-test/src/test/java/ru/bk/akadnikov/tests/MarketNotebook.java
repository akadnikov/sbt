package ru.bk.akadnikov.tests;

import org.junit.experimental.categories.Category;
import ru.bk.akadnikov.steps.CheckSteps;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import ru.bk.akadnikov.pages.MainPage;
import ru.bk.akadnikov.pages.NotebookExtendedSearchPage;
import ru.yandex.qatools.allure.annotations.Title;

import java.util.List;

@Title("Яндекс маркет - Ноутбуки")
public class MarketNotebook extends JUnitTestBase {

    @Title("Тест")
    @Test
    public void yandexMarketNotebooksTest() {

        final String PRICE_TO = "30000";
        final String MANUFACTURER_1 = "Acer";
        final String MANUFACTURER_2 = "Lenovo";
        final int DEFAULT_RESULTS_COUNT = 12;

        NotebookExtendedSearchPage page = (NotebookExtendedSearchPage) new MainPage(driver)
                .chooseMarket()
                .chooseComputers()
                .chooseNotebooks()
                .goToExtendedSearch()
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
