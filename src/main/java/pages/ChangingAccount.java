package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static pages.CommonLocatorsUrls.*;

public class ChangingAccount {
    private final WebDriver driver;

    public ChangingAccount(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Открываем главную страницу")
    public void waitOpenPage() {
        (new WebDriverWait(driver, Duration.ofSeconds(3))).until(ExpectedConditions.urlToBe(CHANGING_ACCOUNT_PAGE_URL));
    }
    public boolean pageIsOpen() {
        return driver.findElement(H1_CHANGING_ACCOUNT).isDisplayed();
    }
}
