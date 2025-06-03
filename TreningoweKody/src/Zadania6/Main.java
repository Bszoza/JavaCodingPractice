package Zadania6;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alek", 20, List.of(3, 4, 5, 5)));
        students.add(new Student("Damian", 22, List.of(3, 3, 3, 5)));
        students.add(new Student("Oskar", 23, List.of(5, 5, 5, 5)));
        students.add(new Student("Aleksander", 19, List.of(3, 4, 5, 5)));
        students.add(new Student("Alek", 20, List.of(3, 4, 5, 5)));

        students.stream().forEach(student -> {
            System.out.println(student.avgGrade());
        });

        Set<Student> studentSet = new HashSet<>(students);
        System.out.println(studentSet);
        Queue<Student> studentQueue = new ArrayDeque<>(students);
        while (!studentQueue.isEmpty()) {
            Student student = studentQueue.poll();
            System.out.println(student);
        }
        Map<String, List<Integer>> studentsList = new HashMap<>();
        for (Student student : students) {
            studentsList.put(student.getName(), student.getGrades());
        }
        System.out.println(studentsList);

        Set<String> studentNames = studentsList.keySet();
        for (String studentName : studentNames) {
            List<Integer> grades = studentsList.get(studentName);
            Double avg=0.0;
            for(Integer grade : grades) {
                avg+=grade;
            }avg=avg/grades.size();
            System.out.println(studentName + " " + studentsList.get(studentName) + "średnia " + avg);
        }

        //Zadanie 2
        List <Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("Adam",56.23,"Ogród"));
        transactions.add(new Transaction("Adamer",1000.12,"Dom"));
        transactions.add(new Transaction("Adama",17.00,"Sport"));
        transactions.add(new Transaction("Adamasdasd",5600.23,"Samochód"));
        transactions.add(new Transaction("Adamnn",56.23,"Ogród"));
        transactions.add(new Transaction("Adam",56.23,"Food"));
        transactions.add(new Transaction("Adamcy",89.23,"Food"));

        transactions.stream().filter(x -> x.getPayment()>1000.00).forEach(System.out::println);
        System.out.println();
        transactions.stream().filter(x -> x.getCategory().equals("Food")).min(Comparator.reverseOrder()).ifPresent(System.out::println);
        System.out.println();
        transactions.stream().sorted().forEach(System.out::println);
        System.out.println();
        transactions.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        System.out.println();
        transactions.stream().sorted(new TransactionComparators.nameComparator()).forEach(System.out::println);

    }
}
