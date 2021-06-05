package model.services;

public class PaypalService implements OnlinePaymentService{
	
	private static double fee = 0.02;
	private static double tax = 0.01;
	
	
	public double paymentFee(double amount) {
		return amount * fee;
	}
	public double interest(double amount, int months) {
		return amount * (tax * months);
	}
}
