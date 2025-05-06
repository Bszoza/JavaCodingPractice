package company;

import java.util.HashMap;
import java.util.Map;

public class Company {
    Map <String, Employee> employees = new HashMap<String, Employee>();

    public Company() {}

    public void addEmployee(String name, String surname, Double salary) {
        Employee employee = new Employee(name, surname, salary);
        employees.put(employee.getFullName(), employee);
    }

    public void getEmployee(String fullName) {
        System.out.println(employees.get(fullName));
    }


}
