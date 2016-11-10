package ru.bk.akadnikov.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class ComputersPage extends BasePage {

    @FindBy(xpath = ".//div[@class = 'catalog-menu__list']/a[text() = 'Ноутбуки']")
    private WebElement notebookLink;

    @FindBy(xpath = ".//div[@class = 'catalog-menu__list']/a[text() = 'Планшеты']")
    private WebElement tabletLink;

    public ComputersPage(WebDriver driver) {
        super(driver);
        new WebDriverWait(driver, WAIT_TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(notebookLink));
    }

    @Step("Выбрать раздел Ноутбуки")
    public NotebookPage chooseNotebooks() {
        notebookLink.click();
        return new NotebookPage(driver);
    }

    @Step("Выбрать раздел Планшеты")
    public TabletPage chooseTablets() {
        tabletLink.click();
        return new TabletPage(driver);
    }
}
