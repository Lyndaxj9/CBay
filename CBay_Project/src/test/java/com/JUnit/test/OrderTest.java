package com.JUnit.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.CBay.service.ItemService;
import com.CBay.service.OrderService;
import com.CBay.service.UserService;

public class OrderTest {

	@Test
	public void test() {

		int testUserNum = UserService.InsertSeller("TesterFN", "TesterLN", "TesterUN", "TesterPW", "Tester@mail.com");
		
		
		int testItemNum = ItemService.createItem(testUserNum, "ItemTest", "Item Test Description", 100.50, 20);
		int testUserNumBuyer = UserService.InsertBuyer("BuyerTesterFN", "BuyerTesterLN", "BuyerTesterUN", "BuyerTesterPW", "BuyerTester@mail.com");
		int testTransactionNum = OrderService.createTransaction(testItemNum, testUserNumBuyer, testUserNum, 11);
		
		Assert.assertEquals(testTransactionNum, (int)OrderService.getTransactionByBuyerIdAndStatus(testUserNumBuyer, "In-Cart").get(0).getId());
		List<Integer> TransactionsId = new ArrayList<Integer>();
		TransactionsId.add(testTransactionNum);
		
		int testOrderNum = OrderService.placeOrder(TransactionsId, testUserNumBuyer);
		Assert.assertEquals(testOrderNum, (int)OrderService.getOrderById(testOrderNum).getId());
		Assert.assertEquals(testUserNumBuyer, (int)OrderService.getOrderById(testOrderNum).getBuyerId());
		Assert.assertEquals(testTransactionNum, (int)OrderService.getTransactionsByOrderId(testOrderNum).get(0).getId());
		Assert.assertEquals("Checked-Out", OrderService.getTransactionsByOrderId(testOrderNum).get(0).getStatus());
		OrderService.updateTransactionCanceled(testTransactionNum);
		Assert.assertEquals("Canceled", OrderService.getTransactionsByOrderId(testOrderNum).get(0).getStatus());
		OrderService.updateTransactionDelivered(testTransactionNum);
		Assert.assertEquals("Delivered", OrderService.getTransactionsByOrderId(testOrderNum).get(0).getStatus());
		OrderService.updateTransactionShipped(testTransactionNum);
		Assert.assertEquals("Shipped", OrderService.getTransactionsByOrderId(testOrderNum).get(0).getStatus());

		

		
		UserService.deleteUser(testUserNumBuyer);
		UserService.deleteUser(testUserNum);
		Assert.assertEquals(null, UserService.getUserInfo(testUserNum));
	}

}
