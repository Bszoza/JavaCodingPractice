import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(4, 2, 7, 2, 8, 4, 6, 3, 7);
        List<Integer> sorted = numbers.stream().distinct().sorted().filter(n -> n % 2 == 0).toList();
        sorted.forEach(System.out::println);
        Integer sum = sorted.stream().mapToInt(n -> n).sum();
        System.out.println(sum);
    }
}