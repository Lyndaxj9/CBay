package com.CBay.service;

import java.util.List;

import com.CBay.beans.MessageThread;
import com.CBay.beans.User;
import com.CBay.dao.UserDao;

public class UserService {

	public static Integer InsertBuyer(String FirstName, String LastName, String Username, String PW, String Email) {
		UserDao dao = new UserDao();
		User user = new User(FirstName, LastName, "Buyer", Username, PW, Email);
		dao.insertUser(user);
		return user.getId();
		
	}
	
	public static Integer InsertSeller(String FirstName, String LastName, String Username, String PW, String Email) {
		UserDao dao = new UserDao();
		User user = new User(FirstName, LastName, "Seller", Username, PW, Email);
		dao.insertUser(user);
		return user.getId();

	}
	
	public static Integer InsertMod(String FirstName, String LastName, String Username, String PW, String Email) {
		UserDao dao = new UserDao();
		User user = new User(FirstName, LastName, "Moderator", Username, PW, Email);
		dao.insertUser(user);
		return user.getId();

	}
	
	public static Integer InsertAdmin(String FirstName, String LastName, String Username, String PW, String Email) {
		UserDao dao = new UserDao();
		User user = new User(FirstName, LastName, "Admin", Username, PW, Email);
		dao.insertUser(user);
		return user.getId();

	}
	
	public static Integer LoginBuyer(String Username, String Password) {
		UserDao dao = new UserDao();
		return dao.LoginUser(Username, Password, "Buyer");
	
	}
	
		
	public static Integer LoginSeller(String Username, String Password) {
		UserDao dao = new UserDao();

		return dao.LoginUser(Username, Password, "Seller");
	
	}
	
	public static Integer LoginMod(String Username, String Password) {
		UserDao dao = new UserDao();

		return dao.LoginUser(Username, Password, "Moderator");
		
	}
	
	public static Integer LoginAdmin(String Username, String Password) {
		UserDao dao = new UserDao();

		return dao.LoginUser(Username, Password, "Admin");	
		
	}
	
	/* 
	 * Call this method whenever any user Registers OR login successfully
	 * For Successful Registration :
	 * 			User user = getUserInfo(InsertBuyer("name", "username", "pw" etc)
	 * For Successful Login :
	 * 			User user = getUserInfo(LoginBuyer("username", "pw"))
	 * 
	 * 	Then to retrieve the data to populate the profile page 
	 * 			user.getSomething();
	*/
	public static User getUserInfo(Integer Id) {
		
		UserDao dao = new UserDao();
		return dao.getUserById(Id);	
	}
	
	public static List<MessageThread> viewUserMessageThreads(Integer Id) {
		
		UserDao dao = new UserDao();
		return dao.getUserMessageThreads(Id);	
	}
	
}
