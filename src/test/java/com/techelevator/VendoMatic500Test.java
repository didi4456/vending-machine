package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class VendoMatic500Test {

	
	@Test
	public void does_feed_money_method_work() {
		VendingMachine test = new VendingMachine();
		test.setCurrentBalance(0);
		test.insertMoney(12);
		Assert.assertEquals(12,test.getCurrentBalance(), .001);
	}
	
	@Test
	public void do_product_get_methods_work() {
		VendingMachine test = new VendingMachine();
		Product stuff = new Product("A1", 1.25, "Candy", 5 );
		stuff.getName();
		Assert.assertEquals("Candy", stuff.getName());
		stuff.getPrice();
		Assert.assertEquals(1.25, stuff.getPrice(), .001);
		stuff.getQuantity();
		Assert.assertEquals(5, stuff.getQuantity());
		stuff.getSlotNum();
		Assert.assertEquals("A1", stuff.getSlotNum());
	}
	
//	@Test
//	public void does_make_purchase_work() {
//		VendingMachine test = new VendingMachine();
//		Product stuff = new Product("A1", 1.25, "Candy", 5 );
//		test.setCurrentBalance(10);
//		test.makePurchase(stuff.getSlotNum());
//		Assert.assertTrue(test.makePurchase(stuff.getSlotNum()));
//	}
	
	@Test 
	public void does_change_method_work() {
		VendingMachine test = new VendingMachine();
		Product stuff = new Product("A1", 1.25, "Candy", 5 );
		Change money = new Change(10.25);
		money.setNumOfQuarters(10.25);
		Assert.assertEquals(41, money.getNumOfQuarters());
	}
	
	@Test
	public void does_finish_transaction_work() {
		VendingMachine test = new VendingMachine();
		Product stuff = new Product("A1", 1.25, "Candy", 5 );
		test.setCurrentBalance(10);
		Change returnChange = new Change(0);
		returnChange.setNumOfQuarters(test.getCurrentBalance());
		Assert.assertEquals(40, test.finishTransaction(), .001);
	}
	
	@Test
	public void does_setter_getter_current_balance_work() {
		VendingMachine test = new VendingMachine();
		test.setCurrentBalance(5);
		Assert.assertEquals(5, test.getCurrentBalance(), .001);
	}
	
	@Test
	public void does_is_digit_work() {
		VendingMachine test = new VendingMachine();
		Assert.assertTrue(test.isDigit("5"));
		Assert.assertFalse(test.isDigit("A"));
	}
}
