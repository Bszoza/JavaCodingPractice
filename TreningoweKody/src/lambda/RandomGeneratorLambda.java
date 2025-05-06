package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.Predicate;

public class RandomGeneratorLambda {
    List <Integer> numbers = new ArrayList<>();
    Random rand = new Random();

    Consumer<Integer> print = s -> System.out.print(s + " ");

    Supplier<Integer> supplier = () -> rand.nextInt(100);

    Predicate <Integer> reduce = number -> number % 2 == 0;

    public void populateList(){
        for(int i=0;i<10;i++){
            numbers.add(supplier.get());
            print.accept(numbers.get(i));
        }
        System.out.println();
    }

    public void reduceList(){
        for(Integer num : numbers){
            if(reduce.test(num)){
                print.accept(num);
            }
        }
    }


    public void showList(){

    }
}
