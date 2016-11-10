package ru.bk.akadnikov.steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckSteps {

    private WebDriver driver;

    public CheckSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Attachment
    public byte[] makeScreenShot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Step("Проверить, что элементов на странице {1}")
    public static void checkResultsCount(List<WebElement> results, int expectedSize){
        assertThat(results).hasSize(expectedSize);
    }

    @Step("Проверить, что наименование товара соответствует запомненному значению")
    public static void checkProductTitle(String productTitle, String expectedProductTitle){
        assertThat(productTitle).isEqualTo(expectedProductTitle);

    }

}
