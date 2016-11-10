package ru.bk.akadnikov.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TabletExtendedSearchPage extends BaseExtendedSearchPage{

    @FindBy(xpath = ".//h1[@class = " +
            "'title title_size_32 i-bem title_changeable_yes title_js_inited' " +
            "and contains(text(),'Планшеты')]")
    private WebElement title;

    public TabletExtendedSearchPage(WebDriver driver) {
        super(driver);
        new WebDriverWait(driver, WAIT_TIMEOUT)
                .until(ExpectedConditions
                        .visibilityOf(title));
    }

}
