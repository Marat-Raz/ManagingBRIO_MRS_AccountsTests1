package pages;

import io.qameta.allure.Step;
import usermodel.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static pages.CommonLocatorsUrls.*;

public class AccountManagementPage {
    private final WebDriver driver;

    public AccountManagementPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Открываем главную страницу")
    public void waitOpenPage() {
        driver.get(MAIN_PAGE_URL);
        (new WebDriverWait(driver, Duration.ofSeconds(3))).until(ExpectedConditions.urlToBe(MAIN_PAGE_URL));
    }
    public boolean pageIsOpen() {
        return driver.findElement(H1_MAIN_PAGE).isDisplayed();
    }
    @Step("Нажимаем на кнопку «Подробности»")
    public void clickOnDetails() {
    driver.findElement(BUTTON_DETAILS).click();
    }
    public boolean buttonDetailsIsRevealed() {
        return driver.findElement(TEXT_UNDER_THE_DETAILS_BUTTON).isDisplayed();
    }
    @Step("Нажимаем на кнопку «Добавить пользователя»")
    public void clickAddUser() {
        driver.findElement(BUTTON_ADD_USER).click();
    }
    @Step("Нажимаем на кнопку «Изменить» в таблице пользователей по логину")
    public void clickChange() {
        driver.findElement(By.xpath("//tr[.//td='local']//a[.='Изменить']")).click();
    }
    @Step("Нажимаем на кнопку «Удалить» в таблице пользователей по логину")
    public void clickDelete(String login) {
        driver.findElement(By.xpath(String.format("//tr[.//td='%s']//a[.='Удалить']", login))).click(); //" + login + "
    }
//tbody//td[text()='sfgbfg541246@!$#%$^&**()__+=впаыиапиВРЖРАОJKFJJ\|/[]{},.*-+']
    @Step("Находим пользователя в таблице пользователей по логину")
    public boolean findLogin(String login) {
    return driver.findElement(By.xpath("//tbody//td[text()='" + login + "']")).isDisplayed();
    }

}
