package com.CBay.main;

import com.CBay.beans.Item;
import com.CBay.beans.User;
import com.CBay.dao.ItemDao;
import com.CBay.dao.UserDao;
import com.CBay.service.UserService;

public class Driver {

	public static void main(String[] args) {

		System.out.println(UserService.InsertSeller("John", "Doe", "JDoe", "JDoe", "JDoe@doe.com"));
		System.out.println(UserService.InsertSeller("Bobbert", "Bob", "BBobbert", "BBobbert", "Bobbert@bob.com"));
		
		
		
		System.exit(0);
	}

}
