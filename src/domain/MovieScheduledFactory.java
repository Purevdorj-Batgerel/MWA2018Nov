package domain;

import java.time.LocalDate;

public class MovieScheduledFactory {
	
	public static Hall createHall(int hallNo, int totalSeat) {
		return new Hall(hallNo, totalSeat);
	}

	public static Movie createMovie(String name, int rate, LocalDate releasedDate, String type, int duringTime) {
		return new Movie(name, rate, releasedDate, type, duringTime);
	}

	public static Schedule createSchedule(LocalDate time, Movie movie, Hall hall) {
		return new Schedule(time, movie, hall);
	}
}
