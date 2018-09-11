package domain;

public class Hall {
	private int hallNo;
	private int totalSeat;
	Hall(int hallNo, int totalSeat){
		this.hallNo=hallNo;
		this.totalSeat=totalSeat;
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
		return String.format("Hall number: %d\nTotal seat: %d", hallNo, totalSeat);
	}
}
