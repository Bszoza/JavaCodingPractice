package Zadania1;

public class Book implements Comparable<Book> {
    private String title;
    private Integer year;
    private Integer pages;

    public Book(String title, Integer year, Integer pages) {
        this.title = title;
        this.year = year;
        this.pages = pages;
    }

    @Override
    public int compareTo(Book o) {
        return this.year.compareTo(o.year);
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getPages() {
        return pages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", pages=" + pages +
                '}';
    }
}
