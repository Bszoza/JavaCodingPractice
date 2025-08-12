package Zadania12;

import java.util.Comparator;

public class MovieComparators {
    public static class MovieRatingComparator implements Comparator<Movie> {
        public int compare(Movie m1, Movie m2) {
            return Comparator.comparing(Movie::getRating).reversed().thenComparing(Movie::getTitle).compare(m1, m2);
        }
    }

    public static class MovieDurationComparator implements Comparator<Movie> {
        public int compare(Movie m1, Movie m2) {
            return Comparator.comparing(Movie::getDuration).compare(m1, m2);
        }
    }

    public static class MovieTimeComparator implements Comparator<Movie>{
        public int compare(Movie m1, Movie m2){
            return Comparator.comparing(Movie::getTitle).compare(m1, m2);
        }
    }
}
