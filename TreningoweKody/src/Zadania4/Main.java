package Zadania4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("ASDASD", 1.99, true));
        products.add(new Product("ASDAsadSD", 13.99, false));
        products.add(new Product("ASDASsadasdD", 12.21, false));
        products.add(new Product("ASDASdsadaD", 10.99, true));
        products.add(new Product("ASDASdsadasD", 9.99, true));

        List<Product> productsAvailable = new ArrayList<>(products = products.stream().filter(Product::getAvailable).toList());
        System.out.println(products);

        productsAvailable.sort(new ProductPriceComparator());
        System.out.println(productsAvailable);

        List<String> productNames = products.stream().map(Product::getName).toList();
        System.out.println(productNames);
        //Zadanie 2

        List<User> users = new ArrayList<>();
        users.add(new User("Adam", Optional.of("123123123")));
        users.add(new User("Adam", Optional.empty()));
        users.add(new User("Adam", Optional.of("123123123")));
        users.add(new User("Adam", Optional.empty()));
        users.add(new User("Adam", Optional.of("123123123")));

        for (User user : users) {
            user.getPhoneNumber().ifPresentOrElse(System.out::println, () -> System.out.println("Nie ma telefonu dla: " + user.getName()));
        }

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Adam",21,7800.00));
        employees.add(new Employee("Ewa",20,2800.00));
        employees.add(new Employee("Piotr",18,8800.00));
        employees.add(new Employee("Marian",26,11800.00));

        employees.sort(Employee::compareTo);
        employees.forEach(System.out::println);
        employees.sort(EmployeeComparators.employeeAgeComparator);
        employees.forEach(System.out::println);
        employees.sort(EmployeeComparators.employeeSalaryComparator);
        employees.forEach(System.out::println);
    }

    public static class ProductPriceComparator implements Comparator<Product> {
        @Override
        public int compare(Product o1, Product o2) {
            return Double.compare(o1.getPrice(), o2.getPrice());
        }
    }
}
