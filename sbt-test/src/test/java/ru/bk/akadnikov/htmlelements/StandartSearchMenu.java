package ru.bk.akadnikov.htmlelements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Name("Standart search menu")
@FindBy(xpath = ".//form[@name='hand-select']")
public class StandartSearchMenu extends HtmlElement {

    @FindBy(xpath = "//a[contains(text(), 'Расширенный поиск')]")
    public WebElement extendedSearch;

    public void goToExtendedSearch() {
        extendedSearch.click();
    }
}
