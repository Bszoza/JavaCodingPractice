package Zadania11;

import Zadania10.HomeTask;

import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Clean Code", "Robert C. Martin", 45.00, 464),
                new Book("Effective Java", "Joshua Bloch", 55.00, 416),
                new Book("Java. Podstawy", "Cay S. Horstmann", 29.99, 720),
                new Book("Mała Książka", "Jan Kowalski", 9.90, 120),
                new Book("Krótkie Opowieści", "Anna Nowak", 34.50, 320)
        );
        books.stream().filter(x -> x.getPrice() > 30).forEach(System.out::println);
        books.stream().filter(x -> x.getPages() > 300).forEach(System.out::println);
        System.out.println(books.stream().mapToDouble(Book::getPrice).average().orElseThrow());

        List<Car> cars = Arrays.asList(
                new Car("Toyota", "Corolla", 2018),
                new Car("Toyota", "Yaris", 2021),
                new Car("BMW", "320", 2017),
                new Car("BMW", "X5", 2020),
                new Car("Fiat", "500", 2019),
                new Car("Ford", "Focus", 2015),
                new Car("Toyota", "Auris", 2016)
        );
        Map<String, List<Car>> carsByBrand = cars.stream().collect(Collectors.groupingBy(Car::getBrand));
        Map<String, Integer> carsInBrand = new HashMap<>();
        for (Car car : cars) {
            carsInBrand.put(car.getBrand(), carsInBrand.getOrDefault(car.getBrand(), 0) + 1);
        }
        for (Map.Entry<String, Integer> car : carsInBrand.entrySet()) {
            System.out.println(car.getKey() + " " + car.getValue());
        }
        cars.stream().sorted(Comparator.comparing(Car::getYear).reversed()).forEach(System.out::println);

        List<String> words = Arrays.asList(
                "apple", "ant", "banana", "carrot", "ant", "apricot", "blueberry", "cherry", "banana"
        );
        Map<Character, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word.charAt(0), map.getOrDefault(word.charAt(0), 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        words.stream().max(Comparator.comparing(String::length)).ifPresentOrElse(System.out::println, () -> {
            System.out.println("Pusta lista");
        });
        words.stream().sorted().forEach(System.out::println);
        Map<String, List<Integer>> grades = new HashMap<>();
        grades.put("Anna", Arrays.asList(5, 4, 5, 5));
        grades.put("Adam", Arrays.asList(4, 4, 3, 5));
        grades.put("Kasia", Arrays.asList(5, 5, 5, 5));
        grades.put("Piotr", Arrays.asList(3, 4, 3));
        grades.put("Marek", Arrays.asList(4, 5, 4, 5));

        List<HomeTask> tasks = Arrays.asList(
                new HomeTask("Zmywanie", 1, false, 20),
                new HomeTask("Pranie", 2, true, 60),
                new HomeTask("Gotowanie", 1, true, 40),
                new HomeTask("Odkurzanie", 3, false, 30),
                new HomeTask("Zakupy", 2, false, 50)
        );
        Collections.sort(tasks);
        System.out.println(tasks);
        System.out.println(tasks.stream().filter(x -> !x.getDone()).mapToInt(HomeTask::getEstimatedTime).sum());

        List<Product> products = Arrays.asList(
                new Product("Mleko", 3.50, 20),
                new Product("Chleb", 4.00, 15),
                new Product("Masło", 8.20, 5),
                new Product("Ser", 8.20, 8),        // ta sama cena co Masło, inna ilość
                new Product("Jajka", 12.00, 30),
                new Product("Makaron", 4.00, 25),   // ta sama cena co Chleb, większa ilość
                new Product("Czekolada", 6.50, 12),
                new Product("Woda", 2.00, 50),
                new Product("Herbata", 15.00, 10),
                new Product("Kawa", 15.00, 5)       // ta sama cena co Herbata, mniejsza ilość
        );
        Collections.sort(products, new ProductComparators.PriceThenAlphabetComparator());

        if(mostExpensiveProduct(products).isPresent()){
            System.out.println(mostExpensiveProduct(products).get());
        }else System.out.println("Brak produktów");
    }

    public static Optional<Product> mostExpensiveProduct(List<Product> productList){
        return productList.stream().max(Comparator.comparing(Product::getPrice));
    }
}
