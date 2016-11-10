package ru.bk.akadnikov.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class MainPage extends BasePage {

    @FindBy(xpath = ".//a[@data-id = 'market']")
    private WebElement marketLink;

    public MainPage(WebDriver driver) {
        super(driver);
        driver.get("http://yandex.ru/");
        new WebDriverWait(driver, WAIT_TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(marketLink));

    }

    @Step("Перейти в яндекс маркет")
    public MarketPage chooseMarket() {
        marketLink.click();
        return new MarketPage(driver);
    }
}
