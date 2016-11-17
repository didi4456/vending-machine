
package com.techelevator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public  class VendoMatic500 {
	
	private static Scanner scan = new Scanner(System.in);
	private static VendingMachine machine = new VendingMachine();
	private static Change giveChange = new Change();
	private static Date date= new Date();

	public static void main(String[] args) {
		
		
		machine.stock();
		runMainMenu();

	}
	
	public static void runProcessMenu() {
		System.out.println("(1) Feed Money");
		System.out.println("(2) Select Product");
		System.out.println("(3) Finish Transaction");
		System.out.println("Current Money Provided:$"+machine.getCurrentBalance());
		String secondAnswer= scan.nextLine();
		if (secondAnswer.contentEquals("1")) {
			feedMoney();
			
		}else if(secondAnswer.contentEquals("2")) {
			menuTitle();
			System.out.println(machine.displayMenu());
			System.out.println("Please make a selection using the Letter-Number Combination from A1-D3");
			double balance1 = machine.getCurrentBalance();
			String secondChoice= scan.nextLine();
			if (machine.makePurchase(secondChoice.toUpperCase())){
				System.out.println("enjoy!");
				double balance2 = machine.getCurrentBalance();
				String message= machine.writeTransaction(secondChoice.toUpperCase(), balance1, balance2 );
				try(FileWriter writer = new FileWriter("TransactionLog.txt", true)) {
					
					writer.write("\n"+message+"\n");
				}
				catch (IOException e){
				}	
			}
			else {
				System.out.println("Try again");
			}
			runProcessMenu();
		}else if (secondAnswer.contentEquals("3")){
			System.out.println("Thank you for choosing Vendo-Matic-500"+"\n");		
			System.out.println("Your change is $"+machine.getCurrentBalance());
			giveChange.setNumOfQuarters(machine.getCurrentBalance());
			System.out.println("Your change is "+giveChange.getNumOfQuarters()+" quarters");
			machine.finishTransaction();
			System.out.println("Current money provided: $"+machine.getCurrentBalance());
		}else {
			runProcessMenu();
		}
			
			
		
	}
	
	public static void feedMoney() {
		System.out.println("Please enter money with $1, $5, or $10 bills");
		System.out.println("$1");
		System.out.println("$5");
		System.out.println("$10");
		String secondChoice= scan.nextLine();
			if(machine.isDigit(secondChoice)) {
				double payment = Double.parseDouble(secondChoice);
				machine.setCurrentBalance(machine.insertMoney(payment));
				runProcessMenu();
		}else{
			feedMoney();
		}
	}
	public static void menuTitle(){
		System.out.println("Slot"+"    "+"Snack"+"    "+"Price"+"    "+"Quantity");
		System.out.println("**********************************");
	}
	public static void runMainMenu() {
		
		System.out.println("You look hungry; you've come to the right place!"); 
		System.out.println("************************************************");
		System.out.println("(1) Display Vending Machine Items");
		System.out.println("(2) Purchase");
		String answer = scan.nextLine();
				if(answer.contentEquals("1")) {
					menuTitle();
					System.out.println(machine.displayMenu());
					System.out.println("Please press 1 to go back to the main menu, or 2 to make a purchase");
					String secondChoice= scan.nextLine();
					if(secondChoice.equals("1")) {
					runMainMenu();
					}else if(secondChoice.equals("2")) {
						runProcessMenu();
					}else {
						System.out.println("Please press 1 to go back to the main menu, or 2 to make a purchase");
						String secondChoice1 = scan.nextLine();
						if(secondChoice1.equals("1")) {
						runMainMenu();
						}else if(secondChoice1.equals("2")) {
							runProcessMenu();
						}
					}
					machine.makePurchase(secondChoice);
					}
				else if (answer.contentEquals("2")) {
						runProcessMenu();
				}
	}
}

	
	
	
	
	
	
	
	



