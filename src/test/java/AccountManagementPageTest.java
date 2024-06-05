import io.qameta.allure.Link;
import io.qameta.allure.Step;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AccountManagementPage;
import pages.ChangingAccount;
import pages.CreatingNewAccountPage;
import pages.DeletingAccountPage;
import usermodel.UserCredentials;

import java.util.function.BooleanSupplier;

import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountManagementPageTest extends StartTest {
    private AccountManagementPage accountManagementPage;
    ValidatableResponse response;
    private int statusCodeOfCreateUser, statusCodeOfDeleteUser;

    private int id;

    @BeforeEach
    @Step("Открытие страницы «Управление аккаунтами BRIO MRS»")
    public void setUpPage() {
        accountManagementPage = new AccountManagementPage(driver);
        accountManagementPage.waitOpenPage();
    }

    @Test
    @DisplayName("Нажать на кнопку «Подробности»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-698")
    public void clickOnDetailsButtonTest() throws InterruptedException {
        accountManagementPage.clickOnDetails();
        Thread.sleep(300);
            assertTrue(accountManagementPage.buttonDetailsIsRevealed(), "Ошибка!");
    }
    @Test
    @DisplayName("Нажать на кнопку «Добавить пользователя»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-698")
    public void clickAddUserButtonTest() {
        accountManagementPage.clickAddUser();
        CreatingNewAccountPage creatingNewAccountPage = new CreatingNewAccountPage(driver);
            assertTrue(creatingNewAccountPage.pageIsOpen(), "Ошибка!");
    }
    @Test
    @DisplayName("Нажать на кнопку «Изменить» пользователя с логином «local»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-698")
    public void clickChangeButtonTest() {
        accountManagementPage.clickChange();
        ChangingAccount changingAccount = new ChangingAccount(driver);
            assertTrue(changingAccount.pageIsOpen(), "Ошибка!");
    }
    @Test
    @DisplayName("Нажать на кнопку «Удалить» пользователя с логином «local»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-698")
    public void clickDeleteButtonTest() {
        accountManagementPage.clickDelete("local");
        DeletingAccountPage deletingAccountPage = new DeletingAccountPage(driver);
            assertTrue(deletingAccountPage.pageIsOpen(), "Ошибка!");
    }
    @Test
    @DisplayName("«» ")
    public void authorizationByLoginButtonTest() throws InterruptedException {

        response = userClient.createUser(user);
        id = response.extract().path("id");
        statusCodeOfCreateUser = response.extract().statusCode();
        driver.navigate().refresh();
        Thread.sleep(3000);
        ValidatableResponse deleteResponse = userClient.deleteUser(id);
        statusCodeOfDeleteUser = deleteResponse.extract().statusCode();
        boolean isSuccess = Boolean.parseBoolean(deleteResponse.extract().asString());
        driver.navigate().refresh();
        Thread.sleep(3000);


        //System.out.println(isSuccess);

        assertEquals(SC_CREATED, statusCodeOfCreateUser);
        assertEquals(SC_OK, statusCodeOfDeleteUser);
        assertTrue(isSuccess);
    }
}
