package Zadania7;

import java.time.LocalDateTime;

public interface Printer {
    void print(String message);
    default void printWithTimestamp(String message){
        print(message + LocalDateTime.now());
    }
}
