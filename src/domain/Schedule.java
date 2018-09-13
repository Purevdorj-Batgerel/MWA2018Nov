package domain;

import java.time.LocalDate;

public class Schedule {
    private Movie movie;
    private Hall hall;
    private LocalDate time;

    Schedule(LocalDate time, int movieId, String name, TypeMovie type, int dtime, String director, AgeRating rate, String description,
             int hallNo, int totalSeat) {
        this.time = time;
        movie = new Movie(movieId, name, type, dtime, director, rate, description);
        hall = new Hall(hallNo, totalSeat);
    }

    Schedule(LocalDate time, Movie movie, Hall hall) {
        this.time = time;
        this.movie = movie;
        this.hall = hall;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return String.format("Show time %s\n%s\n%s", time, movie, hall);
    }
}
