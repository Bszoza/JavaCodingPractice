package Zadania5;

import java.util.Comparator;

public class BookComparators {
    public static class BookTitleComparator implements Comparator<Book> {
        @Override
        public int compare(Book o1, Book o2) {
            return String.CASE_INSENSITIVE_ORDER.compare(o1.getTitle(), o2.getTitle());
        }
    }
        public static class BookRatingComparator implements Comparator<Book> {
            @Override
            public int compare(Book o1, Book o2) {
                return -Double.compare(o1.getRating(), o2.getRating());
            }
        }

        public static class BookAuthorThenTitleComparator implements Comparator<Book> {
            @Override
            public int compare(Book o1, Book o2) {
                if (String.CASE_INSENSITIVE_ORDER.compare(o1.getAuthor(), o2.getAuthor()) == 0) {
                    return String.CASE_INSENSITIVE_ORDER.compare(o1.getTitle(), o2.getTitle());
                } else return String.CASE_INSENSITIVE_ORDER.compare(o1.getAuthor(), o2.getAuthor());
            }
        }

}
