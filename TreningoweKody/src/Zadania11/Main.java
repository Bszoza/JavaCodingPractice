package Zadania11;

import Zadania12.Movie;
import Zadania12.MovieComparators;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
                new Movie("Inception", 8.8, 148),
                new Movie("Avatar", 7.8, 162),
                new Movie("Titanic", 7.9, 195),
                new Movie("Joker", 8.5, 122),
                new Movie("Interstellar", 8.6, 169),
                new Movie("Gladiator", 8.5, 155)
        );

        movies.stream().sorted(new MovieComparators.MovieDurationComparator()).forEach(System.out::println);
        movies.stream().max(new MovieComparators.MovieDurationComparator()).ifPresentOrElse(System.out::println, () -> {
            throw new RuntimeException("Brak filmów");
        });
        System.out.println(findMovieByTitle("Joker", movies).orElseThrow(() -> new RuntimeException("Brak filmu")));

        System.out.println(movies.stream().mapToDouble(Movie::getRating).average().orElseThrow(() -> new RuntimeException("Brak ocen filmów")));

    }

    public static Optional<Movie> findMovieByTitle(String title, List<Movie> movies) {
        return movies.stream().filter(m -> m.getTitle().equals(title)).findFirst();
    }
}
