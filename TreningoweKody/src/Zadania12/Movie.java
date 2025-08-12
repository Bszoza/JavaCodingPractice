package Zadania12;

public class Movie {
    private String title;
    private Double Rating;
    private Integer duration;

    public Movie(String title, Double rating, Integer duration) {
        this.title = title;
        Rating = rating;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getRating() {
        return Rating;
    }

    public void setRating(Double rating) {
        Rating = rating;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", Rating=" + Rating +
                ", duration=" + duration +
                '}';
    }
}
