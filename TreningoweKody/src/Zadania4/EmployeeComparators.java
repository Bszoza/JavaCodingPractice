package Zadania4;

import java.util.Comparator;

public class EmployeeComparators {
    public static final Comparator<Employee> employeeAgeComparator = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return Integer.compare(o1.getAge(), o2.getAge());
        }
    };

    public static final Comparator <Employee> employeeSalaryComparator = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return -Double.compare(o1.getSalary(), o2.getSalary());
        }
    };
}
