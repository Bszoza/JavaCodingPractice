package Zadania3;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private String firstName;
    private String lastName;
    private int age;
    private double avarageGrade;

    public Student(String firstName, String lastName, int age, double avarageGrade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.avarageGrade = avarageGrade;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getAvarageGrade() {
        return avarageGrade;
    }

    @Override
    public int compareTo(Student o) {
        if (this.lastName.equals(o.lastName)) {
            return this.firstName.compareTo(o.firstName);
        } else return this.lastName.compareTo(o.lastName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", avarageGrade=" + avarageGrade +
                '}';
    }
}
