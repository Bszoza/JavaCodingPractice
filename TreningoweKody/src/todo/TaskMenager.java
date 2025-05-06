package todo;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskMenager {

    Queue<Task> tasks = new PriorityQueue<Task>();

    public void addTask(Task task) {
        tasks.offer(task);
    }

    public Task getTask(){
        return tasks.poll();
    }

}
