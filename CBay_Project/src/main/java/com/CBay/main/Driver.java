package com.CBay.main;

import com.CBay.beans.MessageThread;
import com.CBay.service.ItemService;
import com.CBay.service.UserService;

public class Driver {

	public static void main(String[] args) {

/*		
 
 		System.out.println(UserService.InsertSeller("John", "Doe", "JDoe", "JDoe", "JDoe@doe.com"));
		System.out.println(UserService.InsertSeller("Bobbert", "Bob", "BBobbert", "BBobbert", "Bobbert@bob.com"));
		
		System.out.println(UserService.getUserInfo(UserService.LoginSeller("JDoe", "JDoe")).getFirstName());
		
		MessageService.createMessageThread(10001, 10002);
		MessageService.createMessageThread(10001, 10002);
		MessageService.createMessageThread(10002, 10001);
		MessageService.createMessageThread(10002, 10001);
		
		for(MessageThread m : UserService.viewUserMessageThreads(10001))
			System.out.println(m.getId());
			
*/
		
		//ItemService.createItem(10001, "Tv", "Samsung Tv", 200);
		ItemService.addItemImage("C:/Users/Amr Hosny/Desktop/BashSnip1.png", 20000);
		
		System.exit(0);
	}

}
