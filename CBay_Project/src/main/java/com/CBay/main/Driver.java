package com.CBay.main;

import com.CBay.beans.Item;
import com.CBay.beans.User;
import com.CBay.dao.ItemDao;
import com.CBay.dao.UserDao;

public class Driver {

	public static void main(String[] args) {

		//ItemDao item = new ItemDao();

		
		
		/*item.insertItem(new Item("TV", "Sansung TV", 250));
		item.insertItem(new Item("Phone", "Iphone", 250));*/

		
		UserDao user = new UserDao();
		user.insertUser(new User("John", "Doe", "Buyer", "JDoe", "JDoe", "jdoe@ay.com"));
		
		
		System.exit(0);
	}

}
