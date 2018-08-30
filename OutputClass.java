package com.amazonaws.lambda.demo;

import java.util.Arrays;

public class OutputClass {
	
	OutputClass() {
		t = new TransactionClass[3];
		
//		for(int i=0;i<3;i++){
//			t[i] = new TransactionClass();
//		}
		cin = 1500000010;
		account_number = 0;
		balance = 0;
		total_credit = 0;
		total_debit = 0;
	}
	
	int cin;
	int account_number;
	double balance;
	double total_credit;
	double total_debit;
	
	TransactionClass t[] ;

	public int getCin() {
		return cin;
	} 	

	public void setCin(int cin) {
		this.cin = cin;
	}

	public int getAccount_number() {
		return account_number;
	}

	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getTotal_credit() {
		return total_credit;
	}

	public void setTotal_credit(double total_credit) {
		this.total_credit = total_credit;
	}

	public double getTotal_debit() {
		return total_debit;
	}

	public void setTotal_debit(double total_debit) {
		this.total_debit = total_debit;
	}

	public TransactionClass[] getT() {
		return t;
	}

	public void setT(TransactionClass[] t) {
		this.t = t;
	}

	@Override
	public String toString() {
		return "OutputClass [cin=" + cin + ", account_number=" + account_number + ", balance=" + balance
				+ ", total_credit=" + total_credit + ", total_debit=" + total_debit + ", t=" + Arrays.toString(t) + "]";
	}

}
