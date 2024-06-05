package usermodel;

public class User {
    private String name, login, password;

    public User(String name, String login, String password) {
        this.name = name;
        this.login = login.toLowerCase();
        this.password = password;
    }

    public String getLogin() {
        return login.toLowerCase();
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
