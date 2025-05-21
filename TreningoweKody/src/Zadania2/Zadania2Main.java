package Zadania2;

import java.util.*;

public class Zadania2Main {
    private static List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        //Zadanie1
        List<Person> people = new ArrayList<Person>();
        people.add(new Person("Adam", "Kownarski"));
        people.add(new Person("David", "Kownacki"));
        people.add(new Person("David", "Kownacki"));
        people.add(new Person("John", "Wick"));
        people.add(new Person("John", "Wick"));
        people.add(new Person("John", "Wick"));
        people.add(new Person("Johnathan", "Wickowski"));
        people.add(new Person("Kamil", "Rejkowski"));
        people.add(new Person("Robert", "Kowalski"));
        Set<Person> set = new HashSet<Person>(people);

        people = new ArrayList<>(set);//mam unikaty


        Collections.sort(people);
        System.out.println(people);

        people.sort(new PersonNameComparator());
        System.out.println(people);

        Person person = people.stream().filter(p -> p.getLastName().equals("Kowalski")).findFirst().get();
        System.out.println(person);

        users.add(new User("Qber", "123"));
        users.add(new User("Qberrt", "12345"));
        users.add(new User("Qberssd", "1232131"));
        users.add(new User("Asdcrferf", "1233123123"));

        findUserByLogin("Qber").ifPresentOrElse(System.out::println, () -> {
            System.out.println("Nie znaleziono");
        });

        List<Book> books = new ArrayList<>();
        books.add(new Book("cthu", 1990, 345));
        books.add(new Book("cthun", 2004, 100));
        books.add(new Book("gharilla", 1998, 25));
        books.add(new Book("mex", 1990, 678));
        Collections.sort(books);
        System.out.println(books);
        books.sort(new SortByPagesComparator());
        System.out.println(books);

        List<Integer> numbers = List.of(10, 15, 8, 49, 25, 98, 98, 32, 15);
        numbers.stream().filter(x -> x % 2 == 0 && Collections.frequency(numbers, x) == 1)
                .sorted(Comparator.reverseOrder()).forEach(System.out::println);

    }

    public static Optional<User> findUserByLogin(String login) {
        return users.stream().filter(user -> user.getLogin().equals(login)).findFirst();
    }

    public static class PersonNameComparator implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            if (o1.getFirstName().length() == o2.getFirstName().length()) return 0;
            else if (o1.getFirstName().length() > o2.getFirstName().length()) return -1;
            else return 1;
        }
    }

    public static class SortByPagesComparator implements Comparator<Book> {
        @Override
        public int compare(Book o1, Book o2) {
            return -Integer.compare(o1.getPages(), o2.getPages());
        }
    }
}
