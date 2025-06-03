package Zadania6;

import java.util.List;
import java.util.Objects;

public class Student {
    private String name;
    private Integer age;
    private List<Integer> grades;

    public Student(String name, Integer age, List<Integer> grades) {
        this.name = name;
        this.age = age;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public Double avgGrade() {
        Double avgGrade = 0.0;
        for(Integer grade : grades){
            avgGrade += grade;
        }
        return avgGrade/grades.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(age, student.age) && Objects.equals(grades, student.grades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, grades);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grades=" + grades +
                '}';
    }
}
