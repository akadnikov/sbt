package ru.bk.akadnikov.htmlelements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Name("Single search results")
@FindBy(xpath = ".//div[@class='n-product-summary__content']")
public class SingleSearchResult extends HtmlElement {

    @FindBy(xpath = "//div[@class='n-product-title']/h1")
    public WebElement productTitle;

    public String getProductTitle(){
        return productTitle.getText();
    }

}
