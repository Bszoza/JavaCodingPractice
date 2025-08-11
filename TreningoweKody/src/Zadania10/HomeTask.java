package Zadania10;

import java.util.Comparator;

public class HomeTask implements Comparable<HomeTask> {
    private String title;
    private Integer priority;
    private Boolean done;
    private Integer estimatedTime;
    public HomeTask(String title, Integer priority, Boolean done, Integer estimatedTime) {
        this.title = title;
        this.priority = priority;
        this.done = done;
        this.estimatedTime = estimatedTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public Integer getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(Integer estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public int compareTo(HomeTask o) {
        return Comparator
                .comparing(HomeTask::getPriority)
                .thenComparing(HomeTask::getDone)
                .thenComparing(HomeTask::getTitle)
                .compare(this, o);
    }

    @Override
    public String toString() {
        return "HomeTask{" +
                "title='" + title + '\'' +
                ", priority=" + priority +
                ", done=" + done +
                ", estimatedTime=" + estimatedTime +
                '}';
    }
}
