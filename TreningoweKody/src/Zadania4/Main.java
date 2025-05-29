package Zadania4;

import Zadania5.*;
import Zadania5.User;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Zadanie 2
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Raz", "Adam", 2004, 7.35));
        books.add(new Book("Raz", "Bart", 2004, 7.40));
        books.add(new Book("Dwa", "Girt", 2000, 5.55));
        books.add(new Book("Trzy", "Dsas", 1990, 3.34));
        books.add(new Book("Baks", "Rast", 2015, 8.35));
        books.add(new Book("Fers", "Tys", 2001, 3.35));

        Collections.sort(books);
        System.out.println(books);

        books.sort(new BookComparators.BookTitleComparator());
        System.out.println(books);

        books.sort(new BookComparators.BookRatingComparator());
        System.out.println(books);

        books.sort(new BookComparators.BookAuthorThenTitleComparator());
        System.out.println(books);

        //Zadanie 1
        Map<String, List<Integer>> studentsGrades = new HashMap<>();
        List<Student> students = new ArrayList<>();
        students.add(new Student("Adam", 20, new ArrayList<>(List.of(3, 4, 5))));
        students.add(new Student("Adam", 20, new ArrayList<>(List.of(3, 4, 5))));
        students.add(new Student("Ada", 19, new ArrayList<>(List.of(4, 4, 5))));
        students.add(new Student("Kaja", 21, new ArrayList<>(List.of(5, 5, 5))));
        students.add(new Student("Dawid", 22, new ArrayList<>(List.of(3, 3, 3))));

        students.forEach(student -> {
            studentsGrades.put(student.getName(), student.getGrades());
        });
        students.forEach(student -> {
            int sum = 0;
            for (int i = 0; i < student.getGrades().size(); i++) {
                sum += student.getGrades().get(i);
            }
            System.out.println(student.getName() + " średnia: " + (double) sum / student.getGrades().size());
        });

        Set<Student> studentSet = new HashSet<>(students);
        System.out.println(studentSet);

        Queue<Student> studentQueue = new LinkedList<>();
        studentQueue.add(students.get(0));
        studentQueue.add(students.get(1));
        studentQueue.add(students.get(2));
        studentQueue.add(students.get(3));
        studentQueue.add(students.get(4));


        System.out.println(studentQueue);
        System.out.println(studentQueue.poll());
        System.out.println(studentQueue.poll());
        System.out.println(studentQueue.poll());
        System.out.println(studentQueue.poll());
        System.out.println(studentQueue);

        List<User> users = new ArrayList<>();
        List<Transaction> transactions = new ArrayList<Transaction>();
        users.add(new User("Adam"));
        users.add(new User("Krzysztof"));
        users.add(new User("Ada"));
        users.add(new User("Julia"));

        transactions.add(new Transaction(users.get(0).getName(), 100.54, "Garden"));
        transactions.add(new Transaction(users.get(1).getName(), 2000.54, "Food"));
        transactions.add(new Transaction(users.get(2).getName(), 1001.44, "Garden"));
        transactions.add(new Transaction(users.get(3).getName(), 50.74, "Car"));

        transactions.stream().filter(u -> u.getAmount() > 1000).forEach(System.out::println);
        transactions.stream().filter(u -> u.getCategory().equalsIgnoreCase("food")).
                max(new TransactionComparators()).ifPresent(System.out::println);
        transactions.stream().sorted(new TransactionComparators()).forEach(System.out::println);
        transactions.stream().sorted(new TransactionComparators().reversed()).forEach(System.out::println);

        List<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile("Afgan", Optional.of("afghan.gmail"), Optional.of(new Address("Gdynia", Optional.of("123-34")))));
        profiles.add(new Profile("Adgsdan", Optional.of("afgsdashan.gmail"), Optional.of(new Address("Gdansk", Optional.of("1323-36")))));
        profiles.add(new Profile("Afgan", Optional.of("afghan.gmail"), Optional.empty()));
        profiles.add(new Profile("Afgan", Optional.empty(), Optional.of(new Address("Gdynia", Optional.of("123-34")))));

        profiles.stream().forEach(x -> {
            x.getAddress().ifPresentOrElse(System.out::println, () -> {
                System.out.println("Brak adresu");
            });
            x.getEmail().ifPresentOrElse(System.out::println, () -> {
                System.out.println("Brak maila");
            });
        });

    }

    public static class TransactionComparators implements Comparator<Transaction> {
        @Override
        public int compare(Transaction o1, Transaction o2) {
            return Double.compare(o1.getAmount(), o2.getAmount());
        }
    }

    public static class TransactionComparatorsUser implements Comparator<Transaction> {
        @Override
        public int compare(Transaction o1, Transaction o2) {
            return String.CASE_INSENSITIVE_ORDER.compare(o1.getUser(), o2.getUser());
        }
    }
}
