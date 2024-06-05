package usermodel;

import org.apache.commons.lang3.RandomStringUtils;

public class UserGenerator {
    public static String name = RandomStringUtils.randomAlphabetic(8);
    public static String login = RandomStringUtils.randomAlphabetic(8);
    public static String password = RandomStringUtils.randomAlphabetic(8);

    public static User getUser() {
        return new User(name, login, password);
    }

    public static User getUserWithIncorrectPassFive() {
        return new User("string" + "@yandex.ru", RandomStringUtils.randomAlphabetic(5), "name");
    }

}
