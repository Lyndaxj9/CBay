package com.JUnit.test;

import org.junit.Assert;
import org.junit.Test;

import com.CBay.service.ItemService;
import com.CBay.service.UserService;

public class ItemTest {

	@Test
	public void test() {

		int testUserNum = UserService.InsertSeller("TesterFN", "TesterLN", "TesterUN", "TesterPW", "Tester@mail.com");
		Assert.assertEquals(testUserNum, (int)UserService.getUserInfo(testUserNum).getId());
		Assert.assertEquals("TesterFN", UserService.getUserInfo(testUserNum).getFirstName());
		Assert.assertEquals("TesterLN", UserService.getUserInfo(testUserNum).getLastName());
		Assert.assertEquals("TesterUN", UserService.getUserInfo(testUserNum).getUserName());
		Assert.assertEquals("TesterPW", UserService.getUserInfo(testUserNum).getPW());
		Assert.assertEquals("Tester@mail.com", UserService.getUserInfo(testUserNum).getEmail());
		
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
		
		
		int testItemNum = ItemService.createItem(testUserNum, "ItemTest", "Item Test Description", 100.50, 20);
		Assert.assertEquals(testItemNum, (int)ItemService.getItemById(testItemNum).getId());
		Assert.assertEquals("ItemTest", ItemService.getItemById(testItemNum).getItemName());
		Assert.assertEquals("Item Test Description", ItemService.getItemById(testItemNum).getDescription());
		Assert.assertEquals((Double)100.50, ItemService.getItemById(testItemNum).getPrice());
		Assert.assertEquals(20, (int)ItemService.getItemById(testItemNum).getQuantity());
		
		
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

		
		
		
		UserService.deleteUser(testUserNum);
		Assert.assertEquals(null, UserService.getUserInfo(testUserNum));
	}

}
