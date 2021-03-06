package com.CBay.main;

import java.io.FileOutputStream;
import java.io.IOException;

import com.CBay.beans.Image;
import com.CBay.beans.Item;
import com.CBay.beans.Transactions;
import com.CBay.beans.User;
import com.CBay.service.ItemService;
import com.CBay.service.OrderService;
import com.CBay.service.UserService;

public class Driver {

	public static void main(String[] args) throws IOException {

/*		
 
 		System.out.println(UserService.InsertSeller("John", "Doe", "JDoe", "JDoe", "JDoe@doe.com"));
		System.out.println(UserService.InsertSeller("Bobbert", "Bob", "BBobbert", "BBobbert", "Bobbert@bob.com"));
		
		
		System.out.println(UserService.getUserInfo(UserService.LoginSeller("JDoe", "JDoe")).getFirstName());
		
		MessageService.createMessageThread(10001, 10000);
		MessageService.createMessageThread(10001, 10000);
		MessageService.createMessageThread(10000, 10001);
		MessageService.createMessageThread(10000, 10001);
		
		for(MessageThread m : UserService.viewUserMessageThreads(10001))
			System.out.println(m.getId());
			

		
		ItemService.createItem(10000, "Tv", "Samsung Tv", 200);
		ItemService.addItemImage("C:/Users/Amr Hosny/Desktop/Test1.txt", 20000);
		
		for(Image file : ItemService.getImageByItemId(20000)) {
			
			FileOutputStream outputStream = new FileOutputStream("C:/Users/Amr Hosny/Desktop/Test1.txt");
			outputStream.write(file.getImage());
			outputStream.close();
		}
		
		
		System.out.println(UserService.InsertSeller("dogbert", "dog", "DogbertDog", "DogbertDog", "Dog@gmai.com"));
		User user = new User(10001, "John", "Doe", "JDoe", "JDoe", "Jdoe22@gmail.com", "My Description Here");
		
		UserService.EditUserInfo(10020, "dogbert", "dog", "DogbertDog", "Dog123456789", "Dogbert@gmail.com", 
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam\r\n" + 
				"ultricies mauris vel lacus dictum dapibus vel eget augue. Nullam\r\n" + 
				"finibus justo sit amet nibh semper, mattis cursus nibh dignissim.\r\n" + 
				"Class aptent taciti sociosqu ad litora torquent per conubia\r\n" + 
				"nostra, per inceptos himenaeos. Proin vulputate massa nec nunc\r\n" + 
				"auctor venenatis. Morbi at ex vitae purus feugiat placerat ac nec\r\n" + 
				"ligula. Aliquam ac egestas est. Nulla tincidunt suscipit bibendum.\r\n" + 
				"rhoncus");		
		
		
		ItemService.createItem(10001, "Tv", "Samsung Tv", 200);
		ItemService.editItem(20000, "Laptop", 700, "Tv turn to a Laptop");
		
		ItemService.editItem(20000, "Laptop", 700, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam\r\n" + 
				"ultricies mauris vel lacus dictum dapibus vel eget augue. Nullam\r\n" + 
				"finibus justo sit amet nibh semper, mattis cursus nibh dignissim.\r\n" + 
				"Class aptent taciti sociosqu ad litora torquent per conubia\r\n" + 
				"nostra, per inceptos himenaeos. Proin vulputate massa nec nunc\r\n" + 
				"auctor venenatis. Morbi at ex vitae purus feugiat placerat ac nec\r\n" + 
				"ligula. Aliquam ac egestas est. Nulla tincidunt suscipit bibendum.\r\n" + 
				"rhoncus");
		
		System.out.println(ItemService.getItemById(20000));
		
		ItemService.insertItemRating(20000, 3, "This Tv is ok");
		ItemService.insertItemRating(20000, 4, "This Tv is good");
		ItemService.insertItemRating(20000, 5, "This Tv is great");
		ItemService.insertItemRating(20000, 1, "This Tv is bad");
		ItemService.insertItemRating(20000, 2, "This Tv is not bad");
		ItemService.insertItemRating(20000, 1, "This Tv is ok");
		
		
		
		for(String comment : ItemService.getItemComments(20000)) {
			
			System.out.println(comment);
		}

		
		ItemService.updateItemAvg(20000);
		

		UserService.insertSellerRating(10000, 3, "This Seller is fine I guess");
		UserService.insertSellerRating(10000, 0, "This Seller is horrible");
		UserService.insertSellerRating(10000, 2, "This Seller is ok but ...");
		UserService.insertSellerRating(10000, 5, "This Seller is the greatests");
		UserService.insertSellerRating(10000, 4, "This Seller was nice to me");
		UserService.insertSellerRating(10000, 3, "This Seller is good");

		for(String comment : UserService.getSellerComments(10000)) {
			System.out.println(comment);
		}
		
		UserService.updateSellerAvg(10000);

		for(Item item : ItemService.getAllItems()) {
			
			System.out.println(item.getId());
		}
		
		
		System.out.println(UserService.getAllBuyers());
		System.out.println(UserService.getAllSellers());
		System.out.println(UserService.getAllMods());
		System.out.println(UserService.getAllUser());
		
		System.out.println(UserService.InsertSeller("Robbert", "Rob", "RRob", "RRob", "Robbert@rob.com"));
 		System.out.println(UserService.checkApproval(10042));
 		UserService.approveAccount(10042);
		System.out.println(UserService.checkApproval(10042));

	*/
		
		/*System.out.println(UserService.InsertSeller("John", "Doe", "JDoe", "JDoe", "JDoe@doe.com"));
		System.out.println(UserService.InsertSeller("Bobbert", "Bob", "BBobbert", "BBobbert", "Bobbert@bob.com"));
		System.out.println(UserService.InsertBuyer("Robbert", "Rob", "RRob", "RRob", "Robbert@rob.com"));

		ItemService.createItem(10000, "Tv", "Samsung Tv", 200, 10);
		ItemService.createItem(10001, "LapTop", "Windows 98", 2000, 14);
		
		
		

 		System.out.println(UserService.checkApproval(10000));
 		System.out.println(UserService.checkApproval(10001));
 		
 		System.out.println(OrderService.createTransaction(20000, 10002, 10001, 3));
 		
 		
		for(Transactions tran : OrderService.getAllTransactionsBySeller(10000)) {
			
			System.out.println(tran.getId());
		}
		
 		 */
 		
 
 		
 		//OrderService.updateTransactionCheckedOut(30002);
 		
 		//System.out.println(ItemService.getItemById(20000).getQuantity());

 		//System.out.println(UserService.InsertSeller("John", "Doe", "JDoe2", "JDoe2", "JDoe2@doe.com"));

 		//System.out.println(UserService.InsertMod("Ross", "Riss", "RissRoss", "RissRoss", "Riss@Ross.com"));

		//ItemService.createItem(10000, "Tv", "Samsung Tv", 200.53, 10);


		for(Item item : ItemService.getItemBySearch("lap")) {
			
			System.out.println(item.getId());
		}
		
		
		System.exit(0);
	}

}
