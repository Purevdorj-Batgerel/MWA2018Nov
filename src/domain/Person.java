package domain;

import java.time.LocalDate;

public class Person implements iPerson{
	private String firstName;
	private String lastName;
	private LocalDate dob;
	public Person(String firstName, String lastName, LocalDate dob) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.dob=dob;
	}
	@Override
	public void login() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String toString() {
		return String.format("Name: %s, %s DOB: %s", firstName, lastName, dob);
	}
	
}
