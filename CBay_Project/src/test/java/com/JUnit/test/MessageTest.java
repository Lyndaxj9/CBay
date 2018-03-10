package com.JUnit.test;

import org.junit.Assert;
import org.junit.Test;

import com.CBay.service.ItemService;
import com.CBay.service.MessageService;
import com.CBay.service.OrderService;
import com.CBay.service.UserService;

public class MessageTest {

	@Test
	public void test() {
		
			int testUserNum = UserService.InsertSeller("TesterFN", "TesterLN", "TesterUN", "TesterPW", "Tester@mail.com");
			int testItemNum = ItemService.createItem(testUserNum, "ItemTest", "Item Test Description", 100.50, 20);
			int testUserNumBuyer = UserService.InsertBuyer("BuyerTesterFN", "BuyerTesterLN", "BuyerTesterUN", "BuyerTesterPW", "BuyerTester@mail.com");
			int testTransactionNum = OrderService.createTransaction(testItemNum, testUserNumBuyer, testUserNum, 11);
			int testThreadNum = MessageService.createMessageThread(testUserNumBuyer, testUserNum);
			int testMessageNum = MessageService.SendMessage(testThreadNum, testTransactionNum, testUserNumBuyer, testUserNum, "Test Message", "Test Subject");
			
			Assert.assertEquals(testThreadNum, (int)MessageService.getAllThreadsByUser(testUserNumBuyer).get(0).getId());
			Assert.assertEquals(testThreadNum, (int)MessageService.getAllThreadsByUser(testUserNum).get(0).getId());
			Assert.assertEquals(testMessageNum, (int)MessageService.getAllMessagesByThread(testThreadNum).get(0).getId());

			
			UserService.deleteUser(testUserNumBuyer);
			UserService.deleteUser(testUserNum);
			Assert.assertEquals(null, UserService.getUserInfo(testUserNum));
	}

}
