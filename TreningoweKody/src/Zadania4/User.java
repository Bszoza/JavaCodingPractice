package Zadania4;

import java.util.Optional;

public class User {
    private String name;
    private Optional<String> phoneNumber;

    public User(String name, Optional<String> phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public Optional<String> getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
