package ru.bk.akadnikov.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.bk.akadnikov.htmlelements.StandartSearchMenu;
import ru.yandex.qatools.allure.annotations.Step;

public class TabletPage extends BasePage{

    StandartSearchMenu standartSearchMenu;

    @FindBy(xpath = ".//h1[@class = 'b-page-title__title' and text()='Планшеты']")
    private WebElement title;

    public TabletPage(WebDriver driver) {
        super(driver);
        new WebDriverWait(driver, WAIT_TIMEOUT)
                .until(ExpectedConditions.visibilityOf(title));
    }

    @Step("Зайти в расширенный поиск")
    public TabletExtendedSearchPage goToExtendedSearch() {
        standartSearchMenu.goToExtendedSearch();
        return new TabletExtendedSearchPage(driver);
    }

}
