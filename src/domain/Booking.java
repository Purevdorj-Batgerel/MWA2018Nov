package domain;

import java.time.LocalDate;

public class Booking {
	private int bookingNo;
	private LocalDate bookingDate;
	private Schedule schedule;
	private Payment payment;

	public Booking(int bookingNo, LocalDate bookingDate, LocalDate time, String name, int rate, LocalDate releasedDate,
			String type, int duringTime, int hallNo, int totalSeat, int paymentID, double paymentAmount) {
		this.bookingNo = bookingNo;
		this.bookingDate = bookingDate;
		Movie movie = new Movie(name, rate, releasedDate, type, duringTime);
		Hall hall = new Hall(hallNo, totalSeat);
		this.schedule = new Schedule(time, movie, hall);
		this.payment=new Payment(paymentID, paymentAmount);
	}
	public int getBookingNo() {
		return bookingNo;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public Schedule getSchedule() {
		return schedule;
	}
	public Payment getPayment() {
		return this.payment;
	}
	@Override
	public String toString() {
		return String.format("Booking number: %d\nBooking date: %s\n%s\n%s", 
				bookingNo, bookingDate.toString(), schedule, payment);
	}
}
