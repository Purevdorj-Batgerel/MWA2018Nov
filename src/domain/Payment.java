package domain;

public class Payment {
	private int paymentID;
	private double paymentAmount;

	public Payment(int paymentID, double paymentAmount) {
		this.paymentID = paymentID;
		this.paymentAmount = paymentAmount;
	}

	public int getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	@Override
	public String toString() {
		return String.format("Payment ID: %d\nTotal payment: %d", paymentID, paymentAmount);
	}
}
