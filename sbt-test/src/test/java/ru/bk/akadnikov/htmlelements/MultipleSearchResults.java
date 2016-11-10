package ru.bk.akadnikov.htmlelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

@Name("Multiple search results")
@FindBy(xpath = ".//div[@class='filter-applied-results i-bem filter-applied-results_js_inited']")
public class MultipleSearchResults extends HtmlElement {

    @FindAll(@FindBy(xpath = "//h3/a[contains(@href,'/product/')]/span"))
    public List<WebElement> productTitles;

    public String getFirstResultTitle(){
        return productTitles.get(0).getText();
    }

    public int getResultsSize(){
        return productTitles.size();
    }

}
