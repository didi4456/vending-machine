
package com.techelevator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import junit.framework.Assert;

public class VendingMachine {
	Map<String,Product> products = new LinkedHashMap<>();

	private double currentBalance;

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}


	public double insertMoney(double money) {
		currentBalance += money;
		return currentBalance;
	}


	public double finishTransaction() {
		Change returnChange = new Change(0);
		returnChange.setNumOfQuarters(currentBalance);
		currentBalance -= currentBalance;
		return returnChange.getNumOfQuarters();

	}

	public boolean makePurchase (String slotNum) {
		Product product = products.get(slotNum);
		if(product != null && product.getQuantity() > 0  && currentBalance>0) {
			product.setQuantity(product.getQuantity() - 1);	
			currentBalance=currentBalance-(product.getPrice());
			return true;
		}
		return false;
	}
	public String writeTransaction(String secondChoice, double balance1, double balance2){
		Date date= new Date();
		StringBuffer productInfo = new StringBuffer();
		for(String s : products.keySet()) {
			Product name = products.get(s);
			if (s.equals(secondChoice)) {
				productInfo.append(date + "  ");
				productInfo.append(s+"  ");
				productInfo.append(name.getName()+"  ");
				productInfo.append(balance1+"  ");
				productInfo.append(balance2+"  ");
				return productInfo.toString();
			}
			else{

			}
		}
		return secondChoice;
	}
	
	public static boolean isDigit(String s){
		for(int i=0;i<s.length();i++) {
			if(!Character.isDigit(s.charAt(i))) {
				return false;
			}
		}
		return true;
	}


	public String displayMenu() {
		StringBuffer productInfo = new StringBuffer();
		for(String s : products.keySet()) {
			productInfo.append(s+"  ");
			Product namePriceQuant = products.get(s);
			productInfo.append(namePriceQuant.getName()+"   "+"$");
			productInfo.append((double)(namePriceQuant.getPrice())+"   "+"");
			productInfo.append(namePriceQuant.getQuantity()+"\n");
		}
		return productInfo.toString();

	}

	public void stock() {
		File inputFile= new File ("VendingInventory.txt"); {
			try (FileInputStream fis= new FileInputStream(inputFile.getAbsoluteFile());
					InputStreamReader isr= new InputStreamReader(fis,"UTF-8");
					BufferedReader br= new BufferedReader(isr)
					){
				String line;
				while ((line=br.readLine())!=null) {
					String[] parts = line.split("\\|");
					double price =  (Double.parseDouble(parts[2])) ;
					products.put(parts[0],new Product(parts[0], price, parts[1], 5));
				}
			}
			catch(IOException ioe) {

			}
		}

	}

}
