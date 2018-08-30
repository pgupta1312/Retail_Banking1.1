package com.amazonaws.lambda.demo;

public class TransactionClass {
	
	TransactionClass() {
		transaction_id = 0;
		type = "";
		amount =0;
		date ="";
	}
	
	int transaction_id;
	String type;
	double amount;
	String date;
	public int getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "TransactionClass [transaction_id=" + transaction_id + ", type=" + type + ", amount=" + amount
				+ ", date=" + date + "]";
	}
	

}
