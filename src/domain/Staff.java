package domain;

import java.time.LocalDate;


public class Staff extends Person {
	private int staffID;

	public Staff(int staffID, String firstName, String lastName, LocalDate dob) {
		super(firstName, lastName, dob);
		this.staffID = staffID;
	}

	public int getStaffID() {
		return staffID;
	}

	public boolean addMovie(String name, TypeMovie type, int time, String director, AgeRating rate, String description) {
		MovieScheduledFactory.createMovie(name, type, time, director, rate, description);
		return true;
	}
	public void deleteMovie(String name, int rate, LocalDate releasedDate, String type, int duringTime) throws Exception{
		//Search a movie from data base then if not found a movie throws Exception;
	}
	public boolean editMovie(String name, int rate, LocalDate releasedDate, String type, int duringTime) throws Exception{
		//Search movie from data base then after edit the movie save into database and returns true; 
		//If not found a movie throws Exception;
		return true;
	}
	@Override
	public String toString() {
		return String.format("%s, Staff ID: %d", super.toString(), staffID);
	}
}
