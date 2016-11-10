package ru.bk.akadnikov.htmlelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

@FindBy(xpath = "//div[@class = 'layout__col layout__col_search-filters_visible i-bem']")
public class ExtendedSearchMenu extends HtmlElement {

    @FindBy(id = "glf-pricefrom-var")
    public TextInput priceFrom;

    @FindBy(id = "glf-priceto-var")
    public TextInput priceTo;

    @Name("More manufacturers")
    @FindBy(xpath = "//button/span[@class='button__text' and text()='Ещё']/..")
    public Button moreManufacturers;

    @Name("Apply")
    @FindBy(xpath = "//div[@class='layout__col layout__col_search-filters_visible i-bem']" +
            "//span[@class='button__text' and text()='Применить']/..")
    private Button applyButton;

    public void setPriceFrom(String price) {priceFrom.sendKeys(price); }

    public void setPriceTo(String price) {
        priceTo.sendKeys(price);
    }

    public void clickOnMoreButton() {
        moreManufacturers.click();
    }

    public void clickOnApplyButton() {
        applyButton.click();
    }

    public void chooseManufacturer(WebDriver driver, String manufacturer) {

        String elementXpath = "//label[@class='checkbox__label' " +
                "and text()='" + manufacturer + "']/" +
                "..//input[@class='checkbox__control' " +
                "and @type='checkbox']";
/*        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath)));*/
        driver.findElement(By.xpath(elementXpath)).click();
    }
}
