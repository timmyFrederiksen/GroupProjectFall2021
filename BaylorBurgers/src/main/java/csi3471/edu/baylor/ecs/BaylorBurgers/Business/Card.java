package csi3471.edu.baylor.ecs.BaylorBurgers.Business;

import java.util.Date;

public class Card extends Payment {

	private String cardNumber;
	private Integer cvv;
	private Integer expMonth;
	private Integer expYear;
	
	public Card(Float totalGiven, Date date, Boolean receiptChoice) {
		super(totalGiven, date, receiptChoice);
	}
	
	public Card(Float totalGiven, Date date, Boolean receiptChoice, 
			String num, Integer cvv, Integer month, Integer year) {
		super(totalGiven, date, receiptChoice);
		cardNumber = num;
		this.cvv = cvv;
		expMonth = month;
		expYear = year;
	}
	
	// Note: no getters and setters as we want 
	// to keep the data within this class
	
	@Override
	public Integer pay(Float amount) {
		// Check for:
		// - card number is enough numbers long
		// - cvv is 3-4 digits
		// - valid month
		// - card is not expired
		if (cardNumber.length() > 13 && cvv < 10000 && cvv > 99 &&
				expMonth > 0 && expMonth < 13 && expYear > 2020) {
		
			isComplete = true;
				
			if (wantsReceipt) {
				// FIXME: Consider overriding printReceipt as well.
				// Depends on implementation
				printReceipt();
			}
				
			orderNumber = orderNumberGlobal;
			orderNumberGlobal++;
		}
		
		return orderNumber;
	}
}
