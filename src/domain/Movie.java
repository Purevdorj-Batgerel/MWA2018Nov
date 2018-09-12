package domain;


public class Movie {
	private String name;
	private TypeMovie type;
	private int duringTime;
	private String director;
	private AgeRating rate;
	private String description;

	Movie(String name, TypeMovie type, int time, String director, AgeRating rate, String description) {
		this.name = name;
		this.type = type;
		this.duringTime = time;
		this.director = director;
		this.rate = rate;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TypeMovie getType() {
		return type;
	}

	public void setType(TypeMovie type) {
		this.type = type;
	}

	public int getDuringTime() {
		return duringTime;
	}

	public void setDuringTime(int duringTime) {
		this.duringTime = duringTime;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public AgeRating getRate() {
		return rate;
	}

	public void setRate(AgeRating rate) {
		this.rate = rate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return String.format(
				"Movie name: %s,\nType: %s\nDuring time: %d\n" + "Director: %s\nAge rating: %s\nDescription: %s",
				this.name, this.type, this.duringTime, this.director, this.rate, this.description);
	}
}
