package ru.bk.akadnikov.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class NotebookExtendedSearchPage extends BaseExtendedSearchPage {

    @FindBy(xpath = ".//h1[@class = " +
            "'title title_size_32 i-bem title_changeable_yes title_js_inited' " +
            "and contains(text(),'Ноутбуки')]")
    private WebElement title;

    public NotebookExtendedSearchPage(WebDriver driver) {
        super(driver);
        new WebDriverWait(driver, WAIT_TIMEOUT)
                .until(ExpectedConditions
                        .visibilityOf(title));
    }

}
