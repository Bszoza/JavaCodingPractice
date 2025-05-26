package Zadania4;

public class Employee implements Comparable<Employee>{
    private String name;
    private int age;
    private Double salary;

    public Employee(String name, int age, Double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Double getSalary() {
        return salary;
    }

    @Override
    public int compareTo(Employee o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
