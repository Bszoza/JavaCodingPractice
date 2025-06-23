package Zadania7;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Anna", "Kamil", "Agnieszka", "Paweł", "Katarzyna", "Karol");
        System.out.println(task1(names));
        List<Integer> grades = Arrays.asList(5, 4, 3, 5, 2, 4);
        System.out.println(task2(grades));

        List<Person> people = Arrays.asList(
                new Person("Anna", 7, 1), new Person("Anna", 19, 2), new Person("Kamil", 56, 3),
                new Person("Paweł", 30, 4));
        people.sort(Comparator.comparing(Person::getAge));
        System.out.println(people);
        System.out.println(findUserById(1, people));

        Map<Integer, List<Person>> groupByAge = people.stream().collect(Collectors.groupingBy(Person::getAge));

        List<String> transformed = transformList(names, s -> s.toUpperCase());
        System.out.println(transformed);

        List<String> data = Arrays.asList("10", "20", "abc", "30");
        List<Integer> parsed = new ArrayList<>();
        for (String s : data) {
            try {
                parsed.add(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                System.out.println("Takiego Stringa nie da się przekonwertować, program przejdzie do kolejengo wyrazu.");
            }
        }
        System.out.println(parsed);

        people.sort(Comparator.comparing(Person::getName).thenComparing(Person::getAge));
        System.out.println(people);
        System.out.println(people.stream().allMatch(p -> p.getAge() > 18));
        System.out.println(people.stream().anyMatch(p -> p.getAge() > 50));
        System.out.println(people.stream().noneMatch(p -> p.getName().equals("Krzysztof")));
    }

    static List<String> task1(List<String> list) {
        return list.stream().filter(x -> x.startsWith("K") && x.length() > 5).collect(Collectors.toList());
    }

    static OptionalDouble task2(List<Integer> grades) {
        return grades.stream()
                .mapToInt(Integer::intValue)
                .average();
    }

    public static String findUserById(int id, List<Person> people) {
        return people.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .map(Person::getName)
                .orElse("Brak użytkownika");
    }

    public static List<String> transformList(List<String> names, IString iString) {
        List<String> result = new ArrayList<>();
        for (String name : names) {
            result.add(iString.changeString(name));
        }
        return result;
    }


}
