package todo;

import java.util.Objects;

public class Task implements Comparable<Task> {
    private String name;
    private String description;
    private Prio priority;

    public Task(String name, String description, Prio priority) {
        this.name = name;
        this.description = description;
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(name, task.name) && Objects.equals(description, task.description) && priority == task.priority;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(other.priority.ordinal(), this.priority.ordinal());
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Prio getPriority() {
        return priority;
    }

    public void setPriority(Prio priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                '}';
    }
}
