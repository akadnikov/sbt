package ru.bk.akadnikov.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class MarketPage extends BasePage {

    @FindBy(xpath = ".//ul[@class = 'topmenu__list']//a[text() = 'Компьютеры']")
    private WebElement computersLink;

    public MarketPage(WebDriver driver) {
        super(driver);
        new WebDriverWait(driver, WAIT_TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(computersLink));
    }

    @Step("Выбрать раздел Компьютеры")
    public ComputersPage chooseComputers() {
        computersLink.click();
        return new ComputersPage(driver);
    }

}
