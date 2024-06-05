import io.qameta.allure.Link;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AccountManagementPage;
import pages.CreatingNewAccountPage;
import usermodel.User;

import java.util.Optional;

import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.jupiter.api.Assertions.*;
import static pages.CommonLocatorsUrls.*;

public class CreatingNewAccountPageTest extends StartTest {
    private AccountManagementPage accountManagementPage;
    private CreatingNewAccountPage creatingNewAccountPage;

    @BeforeEach
    @Step("Открытие страницы «Управление аккаунтами BRIO MRS»")
    public void setUpCreatingNewAccountPage() {
        accountManagementPage = new AccountManagementPage(driver);
        accountManagementPage.waitOpenPage();
        accountManagementPage.clickAddUser();
        creatingNewAccountPage = new CreatingNewAccountPage(driver);
    }

    @Test
    @DisplayName("Выбрать тип аккаунта «Локальный»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-697")
    public void selectAccountTypeLocalTest() {
        String actText = creatingNewAccountPage.selectTextIsSelected("Локальный");
        //Thread.sleep(1000);
            assertEquals("Локальный", actText, "Ошибка! Выбранный текст не соответствует ожидаемому");
    }
    @Test
    @DisplayName("Выбрать тип аккаунта «Google Drive»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-697")
    public void selectAccountTypeGoogleTest() throws InterruptedException {
        String actText = creatingNewAccountPage.selectTextIsSelected("Google Drive");
        Thread.sleep(300);
            assertEquals("Google Drive", actText, "Ошибка! Выбранный текст не соответствует ожидаемому");
            assertTrue(creatingNewAccountPage.authenticationParametersIsDisplayed(),
                    "Ошибка! «Параметры аутентификации» не видно");
            assertTrue(creatingNewAccountPage.inputGoogleUserIsDisplayed(), "Ошибка! Поле ввода «user» не видно");
    }
    @Test
    @DisplayName("Выбрать тип аккаунта «Yandex Disk»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-697")
    public void selectAccountTypeYandexTest() throws InterruptedException {
        String actText = creatingNewAccountPage.selectTextIsSelected("Yandex Disk");
        Thread.sleep(300);
            assertEquals("Yandex Disk", actText, "Ошибка! Выбранный текст не соответствует ожидаемому");
            assertTrue(creatingNewAccountPage.authenticationParametersIsDisplayed(),
                    "Ошибка! «Параметры аутентификации» не видно");
            assertTrue(creatingNewAccountPage.inputYandexTokenIsDisplayed(), "Ошибка! Поле ввода «token» не видно");
    }
    @Test
    @DisplayName("Выбрать тип аккаунта «Brio-Cloud»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-697")
    public void selectAccountTypeBrioCloudTest() {
        String actText = creatingNewAccountPage.selectTextIsSelected("Brio-Cloud");
            assertEquals("Brio-Cloud", actText, "Ошибка! Выбранный текст не соответствует ожидаемому");
            //Thread.sleep(1000);
            assertTrue(creatingNewAccountPage.authenticationParametersIsDisplayed(),
                    "Ошибка! «Параметры аутентификации» не видно");
            assertTrue(creatingNewAccountPage.inputBrioUsernameAndPasswordIsDisplayed(),
                    "Ошибка! Поле ввода «Username» и «Password» не видно");
    }
    @Test
    @DisplayName("Ввести текст в поле «Имя пользователя»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-699")
    public void enterTextInUsernameFieldTest() {
        creatingNewAccountPage.inputText(INPUT_NAME, TEXT_TO_ENTER_INPUT);
        String actText = creatingNewAccountPage.textFromInput(INPUT_NAME);
            assertEquals(TEXT_TO_ENTER_INPUT, actText, "Ошибка! Отображаемый текст не соответствует введенному");
    }
    @Test
    @DisplayName("Ввести текст в поле «Логин»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-699")
    public void enterTextInLoginFieldTest() {
        creatingNewAccountPage.inputText(INPUT_LOGIN, TEXT_TO_ENTER_INPUT);
        String actText = creatingNewAccountPage.textFromInput(INPUT_LOGIN);
            assertEquals(EXP_TEXT, actText, "Ошибка! Отображаемый текст не соответствует ожидаемому");
    }
    @Test
    @DisplayName("Ввести текст в поле «Пароль»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-699")
    public void enterTextInPasswordFieldTest() {
        creatingNewAccountPage.inputText(INPUT_PASSWORD, TEXT_TO_ENTER_INPUT);
        String actText = creatingNewAccountPage.textFromInput(INPUT_PASSWORD);
            assertNotEquals(TEXT_TO_ENTER_INPUT, actText, "Что-то не то");
            assertEquals(EXP_TEXT, actText, "Ошибка! Отображаемый текст не соответствует ожидаемому");
    }

    @Test
     @DisplayName("Ввод пробела в поле ввода «Имя пользователя»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-705")
    public void enterWhitespaceInUsernameFieldAndClickCreateTest() {
        creatingNewAccountPage.selectText("Локальный");
        creatingNewAccountPage.inputText(INPUT_NAME, " ");
        creatingNewAccountPage.inputText(INPUT_LOGIN, TEXT_TO_ENTER_INPUT);
        creatingNewAccountPage.inputText(INPUT_PASSWORD, TEXT_TO_ENTER_INPUT);
        creatingNewAccountPage.clickButtonCreate();
        String actText = creatingNewAccountPage.alertIsDisplayed();
            assertEquals("The Name field is required.", actText,
                    "Ошибка! Отображаемый текст не соответствует ожидаемому");
            assertTrue(creatingNewAccountPage.alertButtonCloseIsDisplayed(), "Ошибка! Кнопка отсутствует");
    }
    @Test
    @DisplayName("Ввод пробела в поле «Логин»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-704")
    public void enterWhitespaceInLoginFieldAndClickCreateTest() {
        creatingNewAccountPage.selectText("Локальный");
        creatingNewAccountPage.inputText(INPUT_NAME, TEXT_TO_ENTER_INPUT);
        creatingNewAccountPage.inputText(INPUT_LOGIN, " ");
        creatingNewAccountPage.inputText(INPUT_PASSWORD, TEXT_TO_ENTER_INPUT);
        creatingNewAccountPage.clickButtonCreate();
        String actText = creatingNewAccountPage.alertIsDisplayed();
            assertEquals("The Login field is required.", actText,
                    "Ошибка! Отображаемый текст не соответствует ожидаемому");
            assertTrue(creatingNewAccountPage.alertButtonCloseIsDisplayed(), "Ошибка! Кнопка отсутствует");
    }
    @Test
    @DisplayName("Ввод пробела в поле «Пароль»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-703")
    public void enterWhitespaceInPasswordFieldAndClickCreateTest() {
        creatingNewAccountPage.selectText("Локальный");
        creatingNewAccountPage.inputText(INPUT_NAME, TEXT_TO_ENTER_INPUT);
        creatingNewAccountPage.inputText(INPUT_LOGIN, TEXT_TO_ENTER_INPUT);
        creatingNewAccountPage.inputText(INPUT_PASSWORD, " ");
        creatingNewAccountPage.clickButtonCreate();
        String actText = creatingNewAccountPage.alertIsDisplayed();
            assertEquals("The Password field is required.", actText,
                    "Ошибка! Отображаемый текст не соответствует ожидаемому");
            assertTrue(creatingNewAccountPage.alertButtonCloseIsDisplayed(), "Ошибка! Кнопка отсутствует");
    }
    @Test
    @DisplayName("Создание нового аккаунта")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-714")
    public void creatingNewAccountTest() {
        creatingNewAccountPage.enterRegistrationDataAndClickCreateButton(user);
        accountManagementPage = new AccountManagementPage(driver);
        accountManagementPage.waitOpenPage();
            assertTrue(accountManagementPage.pageIsOpen());
            assertTrue(accountManagementPage.findLogin(user.getLogin()));

        ValidatableResponse getResponse = userClient.getUserByLogin(user.getLogin());
        int id = getResponse.extract().path("id.id");
        userClient.deleteUser(id);
    }

}
