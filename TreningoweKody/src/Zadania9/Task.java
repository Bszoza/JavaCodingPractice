package Zadania9;

import java.util.Comparator;

public class Task implements Comparable<Task> {
    private String name;
    private int priority;
    private String category;
    private int estimatedMinutes;

    public Task(String name, int priority, String category, int estimatedMinutes) {
        this.name = name;
        this.priority = priority;
        this.category = category;
        this.estimatedMinutes = estimatedMinutes;
    }

    @Override
    public int compareTo(Task o) {
        return Comparator.comparingInt(Task::getPriority)
                .thenComparing(Task::getName)
                .compare(this, o);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getEstimatedMinutes() {
        return estimatedMinutes;
    }

    public void setEstimatedMinutes(int estimatedMinutes) {
        this.estimatedMinutes = estimatedMinutes;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", priority=" + priority +
                ", category='" + category + '\'' +
                ", estimatedMinutes=" + estimatedMinutes +
                '}';
    }
}
