package domain;

import java.time.LocalDate;

public class Movie {
	private String name;
	private int rate;
	private LocalDate releasedDate;
	private String type;
	private int duringTime;
	

	Movie(String name, int rate, LocalDate releasedDate, String type, int duringTime) {
		this.name = name;
		this.rate = rate;
		this.releasedDate = releasedDate;
		this.type = type;
		this.duringTime = duringTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public LocalDate getReleasedDate() {
		return releasedDate;
	}

	public void setReleasedDate(LocalDate releasedDate) {
		this.releasedDate = releasedDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDuringTime() {
		return duringTime;
	}

	public void setDuringTime(int duringTime) {
		this.duringTime = duringTime;
	}

	@Override
	public String toString() {
		return String.format("Movie name: %s \nDuring time: %d\nType: %s\nRate: %d\nReleased date: %s", name,
				duringTime, type, rate, releasedDate.toString());
	}
}
