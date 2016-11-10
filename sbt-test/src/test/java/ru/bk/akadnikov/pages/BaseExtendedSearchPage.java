package ru.bk.akadnikov.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.bk.akadnikov.htmlelements.ExtendedSearchMenu;
import ru.bk.akadnikov.htmlelements.MultipleSearchResults;
import ru.bk.akadnikov.htmlelements.SearchArrow;
import ru.bk.akadnikov.htmlelements.SingleSearchResult;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class BaseExtendedSearchPage extends BasePage{

    private SearchArrow searchArrow;

    private ExtendedSearchMenu extendedSearchMenu;

    private MultipleSearchResults multipleSearchResults;

    private SingleSearchResult singleSearchResult;

    public BaseExtendedSearchPage(WebDriver driver) {
        super(driver);
    }

    @Step("Задать параметр поиска - Цена от {0}")
    public BaseExtendedSearchPage setPriceFrom(String price) {
        extendedSearchMenu.setPriceFrom(price);
        return this;
    }

    @Step("Задать параметр поиска - Цена до {0}")
    public BaseExtendedSearchPage setPriceTo(String price) {
        extendedSearchMenu.setPriceTo(price);
        return this;
    }

    public BaseExtendedSearchPage clickOnMoreButton() {
        extendedSearchMenu.clickOnMoreButton();
        return this;
    }

    @Step("Выбрать производителя {0}")
    public BaseExtendedSearchPage chooseManufacturer(String manufacturer) {
        extendedSearchMenu.chooseManufacturer(driver, manufacturer);
        return this;
    }

    @Step("Нажать кнопку Применить")
    public BaseExtendedSearchPage clickOnApplyButton() {
        extendedSearchMenu.clickOnApplyButton();
        driver.navigate().refresh();
        return this;
    }

    @Step("Ввести в поисковую строку значение и начать поиск.")
    public BaseExtendedSearchPage search(String searchRequest) {
        searchArrow.search(searchRequest);
        new WebDriverWait(driver, WAIT_TIMEOUT)
                .until(ExpectedConditions
                        .visibilityOf(singleSearchResult.productTitle));
        return this;
    }

    @Step("Запомнить первый элемент в списке")
    public String getFirstResultTitle() {
        return multipleSearchResults.getFirstResultTitle();
    }

    public String getProductTitle() {
        return singleSearchResult.getProductTitle();
    }

    public List<WebElement> getResults() {
        return driver.findElements(By.xpath("//h3/a[contains(@href, '/product/')]"));
    }
}
