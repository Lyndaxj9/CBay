package com.CBay.service;

import com.CBay.beans.User;
import com.CBay.dao.UserDao;

public class UserService {

	public static void InsertBuyer(String FirstName, String LastName, String Username, String PW, String Email) {
		UserDao dao = new UserDao();
		User user = new User(FirstName, LastName, "Buyer", Username, PW, Email);
		dao.insertUser(user);
	}
	
	public static void InsertSeller(String FirstName, String LastName, String Username, String PW, String Email) {
		UserDao dao = new UserDao();
		User user = new User(FirstName, LastName, "Seller", Username, PW, Email);
		dao.insertUser(user);
	}
	
	public static void InsertMod(String FirstName, String LastName, String Username, String PW, String Email) {
		UserDao dao = new UserDao();
		User user = new User(FirstName, LastName, "Moderator", Username, PW, Email);
		dao.insertUser(user);
	}
	
	public static void InsertAdmin(String FirstName, String LastName, String Username, String PW, String Email) {
		UserDao dao = new UserDao();
		User user = new User(FirstName, LastName, "Admin", Username, PW, Email);
		dao.insertUser(user);
	}
	
	public static boolean LoginBuyer(String Username, String Password) {
		UserDao dao = new UserDao();
		if(dao.LoginUser(Username, Password, "Buyer"))
			return true;
		else
			return false;
			
		}
	
		
	public static boolean LoginSeller(String Username, String Password) {
		UserDao dao = new UserDao();

		if(dao.LoginUser(Username, Password, "Seller"))
			return true;
		
		return false;
			
		}
	
	
	public static boolean LoginMod(String Username, String Password) {
		UserDao dao = new UserDao();

		if(dao.LoginUser(Username, Password, "Moderator"))
			return true;
		
		return false;
			
		}
	
	public static boolean LoginAdmin(String Username, String Password) {
		UserDao dao = new UserDao();

		if(dao.LoginUser(Username, Password, "Admin"))
			return true;
		
		return false;
			
		}
	
}
