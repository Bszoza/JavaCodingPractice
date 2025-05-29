package Zadania5;

public class Book implements Comparable<Book>{
    private String title;
    private String author;
    private int yearPublished;
    private Double rating;

    public Book(String title, String author, int yearPublished, Double rating) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.rating = rating;
    }

    @Override
    public int compareTo(Book o) {
        return -Integer.compare(this.yearPublished, o.yearPublished);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", yearPublished=" + yearPublished +
                ", rating=" + rating +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public Double getRating() {
        return rating;
    }
}
