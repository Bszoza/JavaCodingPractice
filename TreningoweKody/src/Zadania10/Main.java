package Zadania10;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<Product>();

        List<String> words = Arrays.asList("Anna", "Adam", "Kasia", "Kuba", "Karol");
        Map<Character, Integer> firstLetterOccurance = countFirstLetterOccurance(words);
        System.out.println(firstLetterOccurance);

        List<Person> people = Arrays.asList(new Person("Anna", 21), new Person("Adam", 22), new Person("Kasia", 17));
        System.out.println(oldestPerson(people));
        people = people.stream().sorted(Comparator.comparing(Person::getAge).reversed().thenComparing(Person::getName)).toList();
        System.out.println(people);

        Map<String, Integer> productsInCategory = new HashMap<>();
        for (Product p : products) {
            productsInCategory.put(p.getCategory(), productsInCategory.getOrDefault(p.getCategory(), 0) + 1);
        }

        List<Integer> numbers = Arrays.asList(1, 2, 3, 3, 4, 5, 5, 6, 7, 7, 8, 9);
        Map<Integer, Integer> numOfNumbers = new HashMap<>();
        for (Integer x : numbers) {
            numOfNumbers.put(x, numOfNumbers.getOrDefault(x, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> x : numOfNumbers.entrySet()) {
            if (x.getValue() > 1) {
                System.out.println(x.getKey());
            }
        }
        Map <String, Integer> cityPopulation = new HashMap<>();
        cityPopulation.put("Warszawa", 1793579);
        cityPopulation.put("Kraków",779115);
        cityPopulation.put("Łódź", 672185);
        cityPopulation.put("Wrocław", 641928);
        cityPopulation.put("Poznań", 534813);
        cityPopulation.put("Gdańsk", 470907);
        cityPopulation.put("Szczecin", 402465);
        cityPopulation.put("Bydgoszcz", 350178);
        cityPopulation.put("Lublin", 339850);
        cityPopulation.put("Białystok", 297459);

        

    }

    private static void foodsProducts(List<Product> products) {
        products.stream()
                .filter(p -> p.getCategory()
                        .equals("Food") && p.getPrice() < 10.00)
                .forEach(System.out::println);
    }

    private static Double sumOfPricesAbove20(List<Product> products) {
        return products.stream()
                .filter(p -> p.getPrice() > 20.00)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    private static Map<Character, Integer> countFirstLetterOccurance(List<String> words) {
        HashMap<Character, Integer> firstLetterOccurance = new HashMap<>();
        for (String word : words) {
            firstLetterOccurance.put(word.charAt(0), firstLetterOccurance.getOrDefault(word.charAt(0), 0) + 1);
        }
        return firstLetterOccurance;
    }

    private static Person oldestPerson(List<Person> persons) {
        return persons.stream().max(Comparator.comparing(Person::getAge)).orElseThrow(() -> new NoSuchElementException("Empty list"));
    }

    private static Integer calculateTimeNeededToCompleteTasks(List<HomeTask> homeTasks) {
        return homeTasks.stream()
                .filter(x -> !x.getDone())
                .mapToInt(HomeTask::getEstimatedTime)
                .sum();
    }

    private static Double avgEstimatedTimeOfCompletedTasks(List<HomeTask> homeTasks) {
        return homeTasks.stream()
                .filter(x -> x.getDone())
                .mapToDouble(HomeTask::getEstimatedTime)
                .average()
                .orElseThrow(NoSuchElementException::new);
    }


}
