package domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Member extends Person{
	private int memberID;
	private List<Booking> bookings=new ArrayList<>();
	public Member(String firstName, String lastName, LocalDate dob, int memberID) {
		super(firstName, lastName, dob);
		this.memberID=memberID;
	}
	public int getMemberID() {
		return memberID;
	}
	public void setMemberID(int memberID) {
		this.memberID=memberID;
	}
	public void addBooking(Booking booking) {
		bookings.add(booking);
	}
	public List<Booking> getBooking(){
		return bookings;
	}
	public double computePaymentAmount() {
		double sum=0.0;
		for(Booking b: bookings) {
			sum+=b.getPayment().getPaymentAmount();
		}
		return sum;
	}
	@Override
	public String toString() {
		return String.format("%s\nMember ID: %d\nTotal amount: %d", 
				super.toString(), memberID, this.computePaymentAmount());
	}
}
