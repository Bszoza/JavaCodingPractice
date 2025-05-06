package practice;

public class User {
    private String name;
    private Integer age;
    private Boolean isActive;

    public User(String name, Integer age, Boolean isActive) {
        this.name = name;
        this.age = age;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Boolean getActive() {
        return isActive;
    }
}
