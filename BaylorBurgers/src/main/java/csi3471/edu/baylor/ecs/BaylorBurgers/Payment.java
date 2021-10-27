package csi3471.edu.baylor.ecs.BaylorBurgers;

import java.util.Date;

public class Payment {
	
	public static Integer orderNumberGlobal = 100;
	protected Date transactionDate;
	protected Boolean isComplete;
	protected Float total;
	protected Float changeGiven;
	protected Boolean wantsReceipt;
	protected Integer orderNumber;
	
	public Payment(Float totalGiven, Date date, Boolean receiptChoice) {
		total = totalGiven;
		transactionDate = date;
		isComplete = false;
		changeGiven = 0.0f;
		wantsReceipt = receiptChoice;
	}
	
	public Integer getOrderNumberGlobal() {
		return orderNumberGlobal;
	}
	
	public void resetGlobalOrderNumber() {
		orderNumberGlobal = 100;
	}
	
	public Integer getOrderNumber() {
		return orderNumber;
	}
	
	public void setOrderNumber(Integer newNum) {
		orderNumber = newNum;
	}

	protected Date getTransactionDate() {
		return transactionDate;
	}

	protected void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	protected Boolean getIsComplete() {
		return isComplete;
	}

	protected void setIsComplete(Boolean isComplete) {
		this.isComplete = isComplete;
	}

	protected Float getTotal() {
		return total;
	}

	protected void setTotal(Float total) {
		this.total = total;
	}

	protected Float getChangeGiven() {
		return changeGiven;
	}

	protected void setChangeGiven(Float changeGiven) {
		this.changeGiven = changeGiven;
	}

	public Integer pay(Float amount) {
		if (amount >= total) {
		
		isComplete = true;
				
		if (wantsReceipt) {
			printReceipt();
		}
				
		orderNumber = orderNumberGlobal;
		orderNumberGlobal++;
		}
		return orderNumber;
	}
	
	public void printReceipt() {
		// FIXME: print the receipt
	}
	
}
