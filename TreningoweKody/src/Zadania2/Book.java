package Zadania2;

import java.util.Objects;

public class Book implements Comparable<Book> {
    private String title;
    private Integer year;
    private Integer pages;

    public Book(String title, Integer year, Integer pages) {
        this.title = title;
        this.year = year;
        this.pages = pages;
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
    public int compareTo(Book o) {
        return Integer.compare(this.year, o.year);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(year, book.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, year);
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
