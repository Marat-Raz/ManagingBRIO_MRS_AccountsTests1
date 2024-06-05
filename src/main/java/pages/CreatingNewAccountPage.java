package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.Keys.ENTER;
import static pages.CommonLocatorsUrls.*;

import org.openqa.selenium.support.ui.WebDriverWait;
import usermodel.User;

import java.time.Duration;


public class CreatingNewAccountPage {
    private final WebDriver driver;

    public CreatingNewAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Открываем главную страницу")
    public void waitOpenPage() {
        (new WebDriverWait(driver, Duration.ofSeconds(3))).until(ExpectedConditions.urlToBe(CREATING_ACCOUNT_PAGE_URL));
    }
    public boolean pageIsOpen() {
        return driver.findElement(H1_CREATING_NEW_ACCOUNT).isDisplayed();
    }
    @Step("Ввод текста в поле ввода")
    public void inputText(By input, String variableText) {
        driver.findElement(input).clear();
        driver.findElement(input).sendKeys(variableText);
        //driver.findElement(input).sendKeys(ENTER);
    }
    @Step("Чтение текста из поля ввода")
    public String textFromInput(By input) {
/*        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement inputElementJS = driver.findElement(input);
        String valueUsingJS = (String) jsExecutor.executeScript("return arguments[0].value", inputElementJS);*/
        // String attribute = driver.findElement(input).getAttribute("value");
        return driver.findElement(input).getAttribute("value");
    }
    @Step("Выбор элемента выпадающего списка")
    public void selectText(String variableTextForSelect) {
        WebElement selectElement = driver.findElement(SELECT_MENU);
        Select select = new Select(selectElement);
        select.selectByVisibleText(variableTextForSelect);
    }
    @Step("Выбор элемента выпадающего списка и возврат статуса выбран элемент или нет")
    public String selectTextIsSelected(String variableTextForSelect) {
        WebElement selectElement = driver.findElement(SELECT_MENU);
        Select select = new Select(selectElement);
        select.selectByVisibleText(variableTextForSelect);
        select.getFirstSelectedOption();
        return select.getFirstSelectedOption().getText();
    }
    @Step("Параметры аутентификации видны или нет?")
    public boolean authenticationParametersIsDisplayed() {
        return driver.findElement(AUTHENTICATION_PARAMETERS).isDisplayed();
    }
    @Step("Поле ввода «user» под «Параметры аутентификации» видно?")
    public boolean inputGoogleUserIsDisplayed() {
        return driver.findElement(INPUT_GOOGLE_USER).isDisplayed();
    }
    @Step("Поле ввода «token» под «Параметры аутентификации» видно?")
    public boolean inputYandexTokenIsDisplayed() {
        return driver.findElement(INPUT_YANDEX_TOKEN).isDisplayed();
    }
    @Step("Поля ввода «Username» и «Password» под «Параметры аутентификации» видно?")
    public boolean inputBrioUsernameAndPasswordIsDisplayed() {
//      boolean c = driver.findElement(INPUT_BRIO_USERNAME).isDisplayed()&driver.findElement(INPUT_BRIO_USERNAME).isDisplayed();
        return driver.findElement(INPUT_BRIO_USERNAME).isDisplayed()&driver.findElement(INPUT_BRIO_USERNAME).isDisplayed();
    }
    @Step("Появилась ошибка с текстом «The ... field is required.»")
    public String alertIsDisplayed() {
        return driver.findElement(ALERT).getText();
    }
    @Step("Появилась кнопка закрыть «Х»")
    public boolean alertButtonCloseIsDisplayed() {
        return driver.findElement(BUTTON_CLOSE).isDisplayed();
    }
    @Step("Заполнение данных пользователя")
    public void InputAllText(User user) {
        selectText("Локальный");
        inputText(INPUT_NAME, user.getName());
        inputText(INPUT_LOGIN, user.getLogin());
        inputText(INPUT_PASSWORD, user.getPassword());
    }
    @Step("Нажать на кнопку «Создать»")
    public void clickButtonCreate() {
        driver.findElement(BUTTON_CREATE).click();
    }
    @Step("Нажать на кнопку «X»")
    public void clickButtonX() {
        driver.findElement(BUTTON_CANCEL).click();
    }
    @Step("Заполнение полей ввода на странице «Регистрация» и нажатие кнопки «Зарегистрироваться»")
    public void enterRegistrationDataAndClickCreateButton(User user) {
        InputAllText(user);
        clickButtonCreate();
    }
}
