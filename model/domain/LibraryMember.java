package model.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

final public class LibraryMember extends Person implements Serializable {
	private String memberId;
	private List<CheckoutRecordEntry> list=new ArrayList<>();
	public LibraryMember(String memberId, String fname, String lname, String tel,Address add) {
		super(fname,lname, tel, add);
		this.memberId = memberId;
	}
	public List<CheckoutRecordEntry> getEntries(){
		return this.list;
	}
	
	public void addEntry(CheckoutRecordEntry e) {
		list.add(e);
	}
	
	public String getMemberId() {
		return memberId;
	}



	@Override
	public String toString() {
		return "Member Info: " + "ID: " + memberId + ", name: " + getFirstName() + " " + getLastName() +
				", " + getTelephone() + " " + getAddress();
	}

	private static final long serialVersionUID = -2226197306790714013L;
}
