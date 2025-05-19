package Zadania1;

import java.util.*;
import java.util.function.BooleanSupplier;
import java.util.stream.Collectors;

public class Zadania1Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student("Adam", "Kownacki"));
        students.add(new Student("Leon", "Tomaniuk"));
        students.add(new Student("Kaspian", "Klicki"));
        students.add(new Student("Anna", "Nowa"));
        students.add(new Student("Weronika", "Kownacka"));
        students.add(new Student("Krzysztof", "Parski"));
        students.add(new Student("Kaspian", "Klicki"));
        students.add(new Student("Krzysztof", "Parski"));

        Set<Student> studentsSet = new HashSet<Student>(students);
        System.out.println(studentsSet);
        System.out.println();
        Collections.sort(students);
        System.out.println(students);
        System.out.println();
        Map<String, List<Student>> studentsMap = new HashMap<>(students.size());
        List<Student> studentByChar = new ArrayList<>();
        String firstChar = String.valueOf(students.getFirst().getSurname().charAt(0));
        for (Student student : students) {
            if (student.getSurname().charAt(0) == firstChar.charAt(0)) {
                studentByChar.add(student);
            } else {
                studentsMap.put(firstChar, studentByChar);
                studentByChar = new ArrayList<>();
                firstChar = String.valueOf(student.getSurname().charAt(0));
                studentByChar.add(student);
            }
        }
        studentsMap.put(firstChar, studentByChar);
        System.out.println(studentsMap.keySet());
        System.out.println(studentsMap.values());
        System.out.println();
        Queue<String> queue = new LinkedList<>();
        for (Student s : students) {
            queue.add(s.getSurname());
        }
        for (int i = 0; i < students.size(); i++) {
            System.out.println(queue.poll());
        }

        System.out.println();
        //Zadanie 2
        List<User> users = new ArrayList<>();
        users.add(new User("Brzoza", "qweasdxcz"));
        users.add(new User("Bzibziol", "razdwatrzy"));
        users.add(new User("Daniel45", "xzcwdsasd"));

        findByLogin(users, "Brzoz").ifPresentOrElse(System.out::println, () -> {
            System.out.println("Brak takiego użytkownika");
        });
        //Zadanie 3
        List<Book> books = new ArrayList<>();
        books.add(new Book("Raz", 1990, 356));
        books.add(new Book("Dwa", 1967, 300));
        books.add(new Book("Trzy", 1992, 115));
        books.add(new Book("Cztery", 2004, 356));
        books.add(new Book("War", 1991, 45));
        Collections.sort(books);
        System.out.println(books);
        books.sort(new SortByPages());
        System.out.println(books);

        //Zadanie 4
        List<Integer> numbers = List.of(10, 15, 8, 49, 25, 98, 98, 32, 15);
        numbers.stream().filter(n -> n % 2 == 0 && Collections.frequency(numbers, n) == 1).
                sorted(Comparator.reverseOrder()).forEach(System.out::println);

        Double avg = (double) ((double) numbers.stream().mapToInt(Integer::intValue).sum() / numbers.size());
        System.out.println(avg);

        numbers.stream().max(Integer::compareTo).ifPresent(System.out::println);

        numbers.stream().filter(n -> n > 50).map(n -> n * 2).forEach(System.out::println);

    }


    private static Optional<User> findByLogin(List<User> users, String login) {
        if (users == null || login == null) return Optional.empty();
        return users.stream()
                .filter(u -> u.getLogin().equalsIgnoreCase(login))
                .findFirst();
    }

    private static class SortByPages implements Comparator<Book> {
        @Override
        public int compare(Book o1, Book o2) {
            return -o1.getPages().compareTo(o2.getPages());
        }
    }

}
