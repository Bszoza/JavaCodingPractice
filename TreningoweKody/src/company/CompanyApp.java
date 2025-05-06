package company;

import java.util.Scanner;

public class CompanyApp {
    Scanner sc = new Scanner(System.in);
    Company company = new Company();

    public void choices() {
        boolean stop = false;
        String choice = "";
        String fullName = "";
        String name;
        String surname;
        Double salary;
        while (!stop) {
            System.out.println("1. Dodaj pracownika");
            System.out.println("2. Znajdź pracownika");
            System.out.println("3. Wyjdź");
            choice = sc.nextLine();
            if (choice.equals("1")) {
                System.out.println("Podaj imie: ");
                name=sc.nextLine();
                System.out.println("Podaj nazwisko: ");
                surname=sc.nextLine();
                System.out.println("Podaj wypłate: ");
                salary= Double.valueOf(sc.nextLine());
                company.addEmployee(name, surname, salary);
            } else if (choice.equals("2")) {
                System.out.println("Podaj imie i nazwisko pracownika oddzielone spacją");
                fullName = sc.nextLine();
                company.getEmployee(fullName);
            } else if (choice.equals("3")) {
                stop = true;
            }
        }
    }
}
