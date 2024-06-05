package client;

import client.base.Client;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import usermodel.User;
import usermodel.UserCredentials;

import static io.restassured.RestAssured.given;

public class UserClient extends Client {
    private static final String USER = "/Users/";
    @Step("Создание пользователя")
    public ValidatableResponse createUser(User user) {
        return given()
                .spec(getBaseSpec())
                .body(user)
                .when()
                .post(USER)
                .then();
    }

/*    @Step("Логин пользователя")
    public ValidatableResponse loginUser(UserCredentials userCredentials) {
        return given()
                .spec(getBaseSpec())
                .body(userCredentials)
                .when()
                .post(USER + "login/")
                .then();
    }*/
    // https://stellarburgers.nomoreparties.site/api/auth/

/*    @Step("Обновление данных пользователя")
    public ValidatableResponse updateUser(User user, String accessToken) {
        return given()
                .spec(getBaseSpec())
                .header("authorization", accessToken)
                .body(user)
                .when()
                .patch(USER + "user/")
                .then();
    }*/

    @Step("Удаление пользователя")
    public ValidatableResponse deleteUser(int userID) {
        return given()
                .spec(getBaseSpec())
                .when()
                .delete(USER + userID)
                .then();
    }
    @Step("Получить пользователя по его логину")
    public ValidatableResponse getUserByLogin(String login) {
        return given()
                .spec(getBaseSpec())
                .when()
                .get(USER + "find?login=" + login)
                .then();
    }
}
