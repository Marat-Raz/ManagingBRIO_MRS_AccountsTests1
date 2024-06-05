import client.UserClient;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import usermodel.UserGenerator;
import usermodel.User;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static pages.CommonLocatorsUrls.MAIN_PAGE_URL;

public class StartTest {
    User user;
    UserClient userClient;
    WebDriver driver;
    static Process brioDocs = null;

    @BeforeAll
    public static void globalSetUp() {
        RestAssured.filters(
                new RequestLoggingFilter(), new ResponseLoggingFilter(),
                new AllureRestAssured());
        ProcessBuilder pb = new ProcessBuilder("C:\\Program Files\\BRIO MRS\\BRIO MRS 2.x\\DocumentManagement\\Brio.Docs.Api.exe");
        pb.directory(new File("C:\\Program Files\\BRIO MRS\\BRIO MRS 2.x\\DocumentManagement"));
        try {
            brioDocs = pb.start();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @BeforeEach
    @Step("Запуск браузера и создание профиля пользователя")
    public void setUp() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get(MAIN_PAGE_URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        user = UserGenerator.getUser();
        userClient = new UserClient();    }

    @AfterAll
    @Step
    public static void closeBrioDocs() {
        brioDocs.destroy();
    }

    @AfterEach
    @Step("Закрытие браузера")
    public void tearDown() {
        driver.quit();
    }




}

