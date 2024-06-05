package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static pages.CommonLocatorsUrls.*;

public class DeletingAccountPage {
    private final WebDriver driver;

    public DeletingAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Открываем главную страницу")
    public void waitOpenPage() {
        (new WebDriverWait(driver, Duration.ofSeconds(3))).until(ExpectedConditions.urlToBe(DELETING_ACCOUNT_PAGE_URL));
    }
    public boolean pageIsOpen() {
        return driver.findElement(H1_DELETING_ACCOUNT).isDisplayed();
    }
}
