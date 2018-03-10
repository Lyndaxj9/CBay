package com.JUnit.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

import com.CBay.service.ItemService;
import com.CBay.service.MessageService;
import com.CBay.service.OrderService;
import com.CBay.service.UserService;

public class JUnitTest {
	
	int SellerId;
	int BuyerId;
	int ItemId;
	int TransactionId;

	
	public  int getSellerId() {
		return SellerId;
	}

	public void setSellerId(int sellerId) {
		SellerId = sellerId;
	}


	public int getBuyerId() {
		return BuyerId;
	}


	public void setBuyerId(int buyerId) {
		BuyerId = buyerId;
	}


	public int getItemId() {
		return ItemId;
	}


	public void setItemId(int itemId) {
		ItemId = itemId;
	}


	public int getTransactionId() {
		return TransactionId;
	}


	public void setTransactionId(int transactionId) {
		TransactionId = transactionId;
	}




	@Test ()
	public void userInsertTest() {

		int testUserNum = UserService.InsertSeller("TesterFN", "TesterLN", "TesterUN", "TesterPW", "Tester@mail.com");
		Assert.assertEquals(testUserNum, (int)UserService.getUserInfo(testUserNum).getId());
		Assert.assertEquals("TesterFN", UserService.getUserInfo(testUserNum).getFirstName());
		Assert.assertEquals("TesterLN", UserService.getUserInfo(testUserNum).getLastName());
		Assert.assertEquals("TesterUN", UserService.getUserInfo(testUserNum).getUserName());
		Assert.assertEquals("TesterPW", UserService.getUserInfo(testUserNum).getPW());
		Assert.assertEquals("Tester@mail.com", UserService.getUserInfo(testUserNum).getEmail());
		
		setSellerId(testUserNum);
		
	}
	
		
		
	
	@Test
	public void userServiceTest() {
			
		int testUserNum = getSellerId();
		System.out.println(testUserNum);
		
		Assert.assertEquals(testUserNum, (int)UserService.LoginSeller("TesterUN", "TesterPW"));
		Assert.assertEquals(false, UserService.checkApproval(testUserNum));
		UserService.approveAccount(testUserNum);
		Assert.assertEquals(true, UserService.checkApproval(testUserNum));
		UserService.insertSellerRating(testUserNum, 5, "Good Seller");
		UserService.updateSellerAvg(testUserNum);
		Assert.assertEquals((Double)5.0, UserService.getSellerAverageRating(testUserNum));
		UserService.insertSellerRating(testUserNum, 2, "OK Seller");
		UserService.updateSellerAvg(testUserNum);
		Assert.assertEquals((Double)3.5, UserService.getSellerAverageRating(testUserNum));
		Assert.assertEquals("Good Seller", UserService.getSellerComments(testUserNum).get(0));
		Assert.assertEquals("OK Seller", UserService.getSellerComments(testUserNum).get(1));
		UserService.EditUserInfo(testUserNum, "TesterFN", "TesterLN", "TesterUN-Edit", "TesterPW-Edit", "Tester@mail.com", "Description-Edit");
		Assert.assertEquals("TesterUN-Edit", UserService.getUserInfo(testUserNum).getUserName());
		Assert.assertEquals("TesterPW-Edit", UserService.getUserInfo(testUserNum).getPW());
		Assert.assertEquals("Description-Edit", UserService.getUserInfo(testUserNum).getDescription());
		
	}
		
	
	@Test
	public void itemTest() {
		
		int testUserNum = getSellerId();
		System.out.println(testUserNum);


		int testItemNum = ItemService.createItem(testUserNum, "ItemTest", "Item Test Description", 100.50, 20);
		Assert.assertEquals(testItemNum, (int)ItemService.getItemById(testItemNum).getId());
		Assert.assertEquals("ItemTest", ItemService.getItemById(testItemNum).getItemName());
		Assert.assertEquals("Item Test Description", ItemService.getItemById(testItemNum).getDescription());
		Assert.assertEquals((Double)100.50, ItemService.getItemById(testItemNum).getPrice());
		Assert.assertEquals(20, (int)ItemService.getItemById(testItemNum).getQuantity());
		
		setItemId(testUserNum);
	}
	
	
	@Test
	public void itemServiceTest() {
		
		int testItemNum = getItemId();
		int testUserNum = getSellerId();
		
		System.out.println(testUserNum);
		System.out.println(testItemNum);

		
		ItemService.editItem(testItemNum, "ItemTest-Edit", 250.23, "Item Description-Edit");
		Assert.assertEquals("ItemTest-Edit", ItemService.getItemById(testItemNum).getItemName());
		Assert.assertEquals("Item Description-Edit", ItemService.getItemById(testItemNum).getDescription());
		Assert.assertEquals((Double)250.23, ItemService.getItemById(testItemNum).getPrice());
		Assert.assertEquals((Double)0.0, ItemService.getItemAverageRating(testItemNum));
		ItemService.insertItemRating(testItemNum, 4, "Good Test Item");
		ItemService.updateItemAvg(testItemNum);
		Assert.assertEquals((Double)4.0, ItemService.getItemAverageRating(testItemNum));
		ItemService.insertItemRating(testItemNum, 3, "Ok Test Item");
		ItemService.updateItemAvg(testItemNum);
		Assert.assertEquals((Double)3.5, ItemService.getItemAverageRating(testItemNum));
		Assert.assertEquals(testItemNum, (int)ItemService.getItemBySeller(testUserNum).get(0).getId());
		Assert.assertEquals("Good Test Item", ItemService.getItemComments(testItemNum).get(0));

	}
	
	
	
	@Test
	public void orderTest() {
		
		int testItemNum = getItemId();
		int testUserNum = getSellerId();
		
		System.out.println(testUserNum);
		System.out.println(testItemNum);


		int testUserNumBuyer = UserService.InsertBuyer("BuyerTesterFN", "BuyerTesterLN", "BuyerTesterUN", "BuyerTesterPW", "BuyerTester@mail.com");
		int testTransactionNum = OrderService.createTransaction(testItemNum, testUserNumBuyer, testUserNum, 11);
		Assert.assertEquals(testTransactionNum, (int)OrderService.getTransactionByBuyerIdAndStatus(testUserNumBuyer, "In-Cart").get(0).getId());
		
		setBuyerId(testUserNumBuyer);
		setTransactionId(testTransactionNum);

	}
	
	@Test
	public void orderServiceTest() {
		
		int testUserNumBuyer = getBuyerId();
		int testTransactionNum = getTransactionId();
		
		System.out.println(testUserNumBuyer);
		System.out.println(testTransactionNum);


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
	}
	
	@Test
	public void MessageTest() {
		
		int testUserNumBuyer = getBuyerId();
		int testUserNum = getSellerId();
		int testTransactionNum = getTransactionId();
		
		System.out.println(testUserNumBuyer);
		System.out.println(testUserNum);
		System.out.println(testTransactionNum);

		
		int testThreadNum = MessageService.createMessageThread(testUserNumBuyer, testUserNum);
		int testMessageNum = MessageService.SendMessage(testThreadNum, testTransactionNum, testUserNumBuyer, testUserNum, "Test Message", "Test Subject");
		Assert.assertEquals(testThreadNum, (int)MessageService.getAllThreadsByUser(testUserNumBuyer).get(0).getId());
		Assert.assertEquals(testThreadNum, (int)MessageService.getAllThreadsByUser(testUserNum).get(0).getId());
		Assert.assertEquals(testMessageNum, (int)MessageService.getAllMessagesByThread(testThreadNum).get(0).getId());
	}
	
	
	
	public void deleteAllTest() {
		int testUserNumBuyer = getBuyerId();
		int testUserNum = getSellerId();
		
		System.out.println(testUserNumBuyer);
		System.out.println(testUserNum);

		
		UserService.deleteUser(testUserNumBuyer);
		UserService.deleteUser(testUserNum);
		Assert.assertEquals(null, UserService.getUserInfo(testUserNum));
	}





		

		

}
