package Zadania5;

import java.util.Optional;

public class Profile {
    private String username;
    private Optional<String> email;
    private Optional<Address> address;

    public Profile(String username, Optional<String> email, Optional<Address> address) {
        this.username = username;
        this.email = email;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Optional<String> getEmail() {
        return email;
    }

    public void setEmail(Optional<String> email) {
        this.email = email;
    }

    public Optional<Address> getAddress() {
        return address;
    }

    public void setAddress(Optional<Address> address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "username='" + username + '\'' +
                ", email=" + email +
                ", address=" + address +
                '}';
    }
}
