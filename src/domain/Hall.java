package domain;

public class Hall {
	private int hallNo;
	private String name;
	private int totalSeat;

	Hall(int hallNo, String name, int totalSeat) {
		this.hallNo = hallNo;
		this.totalSeat = totalSeat;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHallNo() {
		return hallNo;
	}

	public void setHallNo(int hallNo) {
		this.hallNo = hallNo;
	}

	public int getTotalSeat() {
		return totalSeat;
	}

	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}

	@Override
	public String toString() {
		return String.format("Hall number: %d\nName: %s\nTotal seat: %d", hallNo, name, totalSeat);
	}
}
