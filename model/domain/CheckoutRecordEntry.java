package model.domain;

import java.time.LocalDate;

public class CheckoutRecordEntry {

	private LocalDate checkoutDate;
	private LocalDate dueDate;
	private BookCopy copy;
	private String memberId;
	public CheckoutRecordEntry(String memberId, BookCopy copy, LocalDate cd, LocalDate dd) {
		this.checkoutDate=cd;
		this.copy=copy;
		this.dueDate=dd;
		this.memberId = memberId;
	}

	public LocalDate getChechoutDate(){
		return this.checkoutDate;
	}

	public LocalDate getDueDate(){
		return this.dueDate;
	}

	public BookCopy getBookCopy(){
		return this.copy;
	}
	public String getMemberId(){
		return this.memberId;
	}
	@Override
	public String toString(){
		return this.memberId +" "+this.copy.getBook().getIsbn()+" "+this.checkoutDate+" "+this.dueDate;
	}
}
