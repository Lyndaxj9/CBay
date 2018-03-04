package com.CBay.main;

import java.io.FileOutputStream;
import java.io.IOException;

import com.CBay.beans.Image;
import com.CBay.service.ItemService;

public class Driver {

	public static void main(String[] args) throws IOException {

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
			

		
		ItemService.createItem(10001, "Tv", "Samsung Tv", 200);
		ItemService.addItemImage("C:/Users/Amr Hosny/Desktop/Test1.txt", 20000);
		
		for(Image file : ItemService.getImageByItemId(20000)) {
			
			FileOutputStream outputStream = new FileOutputStream("C:/Users/Amr Hosny/Desktop/Test1.txt");
			outputStream.write(file.getImage());
			outputStream.close();
		}
		
	*/	
		
		System.exit(0);
	}

}
