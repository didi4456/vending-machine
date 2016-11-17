package com.techelevator;
public class Change {
	
	private int numOfDimes;
	private int numOfNickels;
	private int numOfQuarters;
	private double currentBalance;

	public Change(double money) {
		
	}
	
	public Change() {
		
	}
	

	public int getNumOfDimes() {
		return numOfDimes;
	}

	public void setNumOfDimes(int numOfDimes) {
		this.numOfDimes = numOfDimes;
	}

	public int getNumOfNickels() {
		return numOfNickels;
	}

	public void setNumOfNickels(int numOfNickels) {
		this.numOfNickels = numOfNickels;
	}

	public int getNumOfQuarters() {
		return numOfQuarters;
	}

	public void setNumOfQuarters(double currentBalance) {
		this.numOfQuarters = (int)((currentBalance/25) * 100);
	}
	
	

}
