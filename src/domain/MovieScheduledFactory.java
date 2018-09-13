package domain;

import java.time.LocalDate;

public class MovieScheduledFactory {

    public static Hall createHall(int hallNo, String name, int totalSeat) {
        return new Hall(hallNo, name, totalSeat);
    }

    public static Movie createMovie(int id, String name, TypeMovie type, int time, String director, AgeRating rate, String description, String picture) {
        return new Movie(id, name, type, time, director, rate, description, picture);
    }

    public static Movie createMovie(int id, String name, TypeMovie type, int time, String director, AgeRating rate, String description) {
        return new Movie(id, name, type, time, director, rate, description);
    }

    public static Schedule createSchedule(LocalDate time, Movie movie, Hall hall) {
        return new Schedule(time, movie, hall);
    }
}
