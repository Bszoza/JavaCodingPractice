package Zadania3;

public class Account {
    private String login;
    private String password;
    private boolean active;

    public Account(String login, String password, boolean active) {
        this.login = login;
        this.password = password;
        this.active = active;
    }


    public void setActive(boolean active) {
        this.active = active;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public String toString() {
        return "Account{" +
                "login='" + login + '\'' +
                ", active=" + active +
                '}';
    }
}
