package pages;

import org.openqa.selenium.By;

public class CommonLocatorsUrls {
    //URLs
    public static final String MAIN_PAGE_URL = "http://localhost:5000/pages/Accounts/Index";
    public static final String CREATING_ACCOUNT_PAGE_URL = "http://localhost:5000/pages/Accounts/Create";
    public static final String CHANGING_ACCOUNT_PAGE_URL = "http://localhost:5000/pages/Accounts/Edit/101";
    public static final String DELETING_ACCOUNT_PAGE_URL = "http://localhost:5000/pages/Accounts/Delete/101";

    public static final By H1_CHANGING_ACCOUNT = By.xpath("//h1[contains(text(),'Изменение аккаунта')]");
    public static final By H1_DELETING_ACCOUNT = By.xpath("//h1[contains(text(),'Удаление аккаунта')]");
    //Страница Управления аккаунтами BRIO MRS
    public static final By H1_MAIN_PAGE = By.xpath("//h1[contains(text(),'Управление аккаунтами BRIO MRS')]");
    public static final By BUTTON_DETAILS = By.xpath("//button[contains(text(),'Подробности')]");
    public static final By TEXT_UNDER_THE_DETAILS_BUTTON = By.xpath("//div[@class='accordion-body']");
    public static final By BUTTON_ADD_USER = By.xpath("//a[contains(text(),'Добавить пользователя')]");
    public static final By LOGIN_COLUMN_OF_USER_TABLE = By.xpath("//table//td[2]");
    //Страница Создание нового аккаунта
    public static final By H1_CREATING_NEW_ACCOUNT = By.xpath("//h1[contains(text(),'Создание нового аккаунта')]");
    public static final By ALERT = By.xpath("//div[@role='alert']");
    public static final By BUTTON_CLOSE = By.xpath("//button[@aria-label='Close']");
    public static final By SELECT_MENU = By.xpath("//select[@name='Account.ConnectionTypeId']");
    public static final By ELEMENT_LOCAL = By.xpath("//select[@class='form-select']/option[@value='']");
    public static final By ELEMENT_GOOGLE_DRIVE = By.xpath("//select[@class='form-select']/option[@value=15]");
    public static final By ELEMENT_YANDEX_DISK = By.xpath("//select[@class='form-select']/option[@value=17]");
    public static final By ELEMENT_BRIO_CLOUD = By.xpath("//select[@class='form-select']/option[@value=20]");
    public static String TEXT_TO_ENTER_INPUT = "sfgbfg541246@#!$%$^&**()__+=впаыиапиВРЖРАОJKFJJ\\|/[]{},.*-+ 123456789";
    public static String EXP_TEXT = TEXT_TO_ENTER_INPUT.substring(0,60);
    public static final By INPUT_NAME = By.xpath("//input[@name='Account.Name']");
    public static final By INPUT_LOGIN = By.id("inputLogin");
    public static final By INPUT_PASSWORD = By.xpath("//input[@name='Account.Password']");
    public static final By INPUT_GOOGLE_USER = By.xpath("//input[@name='Account.AuthFieldValues[user]']");
    public static final By INPUT_YANDEX_TOKEN = By.xpath("//input[@name='Account.AuthFieldValues[token]']");
    public static final By INPUT_BRIO_USERNAME = By.xpath("//input[@name='Account.AuthFieldValues[Username]']");
    public static final By INPUT_BRIO_PASSWORD = By.xpath("//input[@name='Account.AuthFieldValues[Password]']");
    public static final By BUTTON_CREATE = By.xpath("//button[contains(text(),'Создать')]");
    public static final By BUTTON_CANCEL = By.xpath("//a[contains(text(),'Отмена')]");
    public static final By AUTHENTICATION_PARAMETERS = By.xpath("//h3[contains(text(),'Параметры аутентификации')]");









}