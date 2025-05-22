package Zadania3;

import java.util.*;
import java.util.stream.Collectors;

public class Zadania3Main {
    private static List<Account> accounts = new ArrayList<>();

    public static void main(String[] args) {
        //Zad1
        List<Student> students = new ArrayList<Student>();
        students.add(new Student("Kacper", "Kownacki", 25, 4.55));
        students.add(new Student("Kacper", "Kownacki", 25, 4.55));
        students.add(new Student("Adam", "Kownacki", 26, 4.75));
        students.add(new Student("Anna", "Zawadzka", 23, 4.79));
        students.add(new Student("Klaudiusz", "Rambojlo", 21, 3.00));
        students.add(new Student("Janina", "Mileczek", 22, 4.23));
        Set<Student> studentSet = new HashSet<Student>(students);
        List<Student> filteredStudentsList = new ArrayList<>(studentSet);
        System.out.println(filteredStudentsList);
        filteredStudentsList.sort(new StudentAvgComparator());
        System.out.println(filteredStudentsList);
        filteredStudentsList.sort(new StudentAgeComparator());
        System.out.println(filteredStudentsList);

        Optional<Student> topStudent = filteredStudentsList.stream().min(new StudentAvgComparator());
        if (topStudent.isPresent()) {
            System.out.println(topStudent.get());
        } else {
            System.out.println("Brak studenta");
        }

        Optional<Student> youngestStudent = filteredStudentsList.stream().max(new StudentAvgComparator());
        if (youngestStudent.isPresent()) {
            System.out.println(youngestStudent.get());
        } else {
            System.out.println("Brak studenta");
        }
        filteredStudentsList.stream().filter(x -> x.getAvarageGrade() > 4.0).forEach(System.out::println);

        //Zad2

        accounts.add(new Account("Brzoz", "qweasdzxc123", true));
        accounts.add(new Account("Brzozar", "qwe123dzxc123", true));
        accounts.add(new Account("Brzozex", "qwe123dzxc123", false));
        accounts.add(new Account("Brzozr", "qweaasdsadc123", false));
        accounts.add(new Account("Arbsg", "qweadasdzxc123", true));

        findActiveAccountByLogin("Brzoz").ifPresentOrElse(System.out::println, () -> {
            System.out.println("Brak aktywnego konta o takim loginie");
        });
        System.out.println();

        //Zad3
        List<String> words = List.of("Apple", "banana", "carrot", "avocado", "Blueberry", "almond", "apple");
        words.stream().filter(x -> x.startsWith("A") || x.startsWith("a")).forEach(System.out::println);
        System.out.println();
        words.stream().distinct().sorted(String::compareToIgnoreCase).forEach(System.out::println);
        System.out.println();
        words.stream().max(new wordLengthComparator()).ifPresent(System.out::println);
        System.out.println();
        words.stream().filter(x -> x.length()>5).forEach(System.out::println);
        Map <Integer, List<String>> wordMap = words.stream().collect(Collectors.groupingBy(String::length));
    }

    public static Optional<Account> findActiveAccountByLogin(String login) {
        return accounts.stream().filter(x -> x.getLogin().equals(login) && x.isActive()).findFirst();
    }

    public static class wordLengthComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return Integer.compare(o1.length(), o2.length());
        }
    }

    public static class StudentAvgComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return -Double.compare(o1.getAvarageGrade(), o2.getAvarageGrade());
        }
    }

    public static class StudentAgeComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return Integer.compare(o1.getAge(), o2.getAge());
        }
    }
}
