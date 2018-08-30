package com.amazonaws.lambda.demo;

public class InputClass {
	int cin;
	
	InputClass() {
		this.cin = 1500000010;
	}
	
	InputClass(int cin) {
		this.cin = cin;
	}

	public int getCin() {
		return cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}

}
