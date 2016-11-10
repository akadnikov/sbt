package ru.bk.akadnikov.htmlelements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

@Name("Search form")
@FindBy(xpath = "//form")
public class SearchArrow extends HtmlElement {

    @Name("Search request input")
    @FindBy(id = "header-search")
    public TextInput requestInput;

    @Name("Search button")
    @FindBy(xpath = "//button/span[text()='Найти']/..")
    public Button searchButton;

    public void search(String request) {
        requestInput.sendKeys(request);
        searchButton.click();
    }
}