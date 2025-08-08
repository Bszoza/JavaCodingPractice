package Zadania7;

import Zadania9.Task;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Queue <Task> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Task("Programowanie",1,"Work",120));
        priorityQueue.add(new Task("Testowanie",2,"Work",60));
        priorityQueue.add(new Task("Gotowanie",3,"Home",60));
        priorityQueue.add(new Task("Trening",2,"Gym",90));

        Map<String,Long> tasksInCategory = new HashMap<>();
        tasksInCategory = priorityQueue.stream().collect(Collectors.groupingBy(Task::getCategory, Collectors.counting()));
        List<Task> taskList = priorityQueue.stream().sorted(Comparator.comparingInt(Task::getEstimatedMinutes)).toList();
        System.out.println(taskList);
        taskList.stream().filter(task -> task.getPriority()<=2 && task.getEstimatedMinutes()<=60).forEach(System.out::println);

        while(!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());
        }


    }
}
