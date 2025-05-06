package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaPractice {
    private List<User> userList = new ArrayList<>();

    public void Run() {
        List<User> users = userSupplier.get();

        //users.stream().filter(isAdultAndActive).map(userToString).forEach(printUser);

    }

    private Function<User, String> userToString = user -> "Imie: " + user.getName() + " wiek: " + user.getAge() + " is active: " + user.getActive();
    private Predicate<User> isAdultAndActive = user -> user.getAge() > 18 && user.getActive();
    private Consumer<User> printUser = user -> System.out.println(userToString.apply(user));
    private Supplier<List<User>> userSupplier = () -> List.of(
            new User("Adam", 6, true),
            new User("Kacper", 24, true),
            new User("Tomasz", 17, false)
    );
}
