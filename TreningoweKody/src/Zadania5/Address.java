package Zadania5;

import java.util.Optional;

public class Address {
    private String city;
    private Optional <String> zipCode;

    public Address(String city, Optional<String> zipCode) {
        this.city = city;
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public Optional<String> getZipCode() {
        return zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}
