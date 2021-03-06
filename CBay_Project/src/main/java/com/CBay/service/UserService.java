package com.CBay.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import com.CBay.beans.Item;
import com.CBay.beans.ItemRating;
import com.CBay.beans.MessageThread;
import com.CBay.beans.Order;
import com.CBay.beans.SellerRating;
import com.CBay.beans.Transactions;
import com.CBay.beans.User;
import com.CBay.dao.ItemDao;
import com.CBay.dao.UserDao;

public class UserService {
	

	public static Integer InsertBuyer(String FirstName, String LastName, String Username, String PW, String Email)  {
		UserDao dao = new UserDao();
		User user = new User(FirstName, LastName, "Buyer", Username, PW, Email, "N/A");
			dao.insertUser(user);
			if (dao.getUserById(user.getId()) != null)
				return user.getId();	
			else 
				return null;

	}
	
	public static Integer InsertSeller(String FirstName, String LastName, String Username, String PW, String Email) {
		UserDao dao = new UserDao();
		User user = new User(FirstName, LastName, "Seller", Username, PW, Email, "Pending");
		dao.insertUser(user);
		if (dao.getUserById(user.getId()) != null)
			return user.getId();	
		else 
			return null;

	}
	
	public static Integer InsertMod(String FirstName, String LastName, String Username, String PW, String Email) {
		UserDao dao = new UserDao();
		User user = new User(FirstName, LastName, "Moderator", Username, PW, Email, "Pending");
		dao.insertUser(user);
		if (dao.getUserById(user.getId()) != null)
			return user.getId();	
		else 
			return null;

	}
	
	public static Integer InsertAdmin(String FirstName, String LastName, String Username, String PW, String Email) {
		UserDao dao = new UserDao();
		User user = new User(FirstName, LastName, "Admin", Username, PW, Email, "N/A");
		dao.insertUser(user);
		if (dao.getUserById(user.getId()) != null)
			return user.getId();	
		else 
			return null;

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
	
	public static List<Item> viewSellerItems(Integer Id) {
		
		UserDao dao = new UserDao();
		return dao.getSellerItems(Id);	
	}
	
	public static List<Transactions> viewUserTransactions(Integer Id) {
			
			UserDao dao = new UserDao();
			return dao.getUserTransactions(Id);	
		}
	
	public static List<Order> viewBuyerOrder(Integer Id) {
		
		UserDao dao = new UserDao();
		return dao.getUserOrder(Id);	
	}
	
	
	public static void EditUserInfo(Integer Id, String FirstName, String LastName, String Username,
									String PW, String Email, String Description) {
		
		UserDao dao = new UserDao();
		User user = new User(Id, FirstName, LastName, Username, PW, Email, Description);
		dao.changeUserInfo(user);
	}
	
	
	public static Integer insertSellerRating(Integer UserId, Integer NumRating, String Comment) {
			
			UserDao dao = new UserDao();
			SellerRating rating = new SellerRating(UserId, NumRating, Comment);
			
			dao.addUserRatingAndComment(rating); 
			return rating.getId();
			
		}
		
	
	public static List<String> getSellerComments(Integer UserId){
		
		UserDao dao = new UserDao();
		List<String> comments = new ArrayList<String>();;
		List<SellerRating> ratings = dao.getSellerRating(UserId);
	
		for (SellerRating r : ratings) {
			
			comments.add(r.getTextRating());
		}
		
		return comments;
	}
	
	// Don't touch this method
		private static List<Integer> getSellerAverageRatingForCalculation(Integer UserId){
				
				UserDao dao = new UserDao();
				List<Integer> avg = new ArrayList<Integer>();
				List<SellerRating> ratings = dao.getSellerRating(UserId);
				
				for (SellerRating r : ratings) {
					
					avg.add(r.getNumRating());
				}
				
				return avg;
			}
		
		public static Double getSellerAverageRating(Integer UserId){
				
			UserDao dao = new UserDao();
			return dao.getUserById(UserId).getRatingAvg();
		}
		
			
		private static Double calculateAvg(Integer UserId){
			Double sum = 0.0;
			List<Integer> average = getSellerAverageRatingForCalculation(UserId);
			
			for (Integer avg : average) {
				
				sum += avg;
			}
			
			return sum/average.size();
			
		}
	
	
	
	
	public static void updateSellerAvg(Integer UserId) {
		
		UserDao dao = new UserDao();
		double avg = new BigDecimal(calculateAvg(UserId)).setScale(3, RoundingMode.HALF_UP).doubleValue();

		dao.updateSellerAvg(UserId, avg);
		
	}
	
	
	public static List<User> getAllUser() {
		
		UserDao dao = new UserDao();
		return dao.getAllUsers();
	}
	
	public static List<User> getAllBuyers() {
		
		List<User> Buyers = new ArrayList<User>();
		
		for(User user : getAllUser()) {
			
			if(user.getUserType().equals("Buyer")) {
				Buyers.add(user);
			}
		}
		return Buyers;
	}



	public static List<User> getAllSellers() {
			
			List<User> Sellers = new ArrayList<User>();
			
			for(User user : getAllUser()) {
				
				if(user.getUserType().equals("Seller")) {
					Sellers.add(user);
				}
			}
			return Sellers;
		}
	
	public static List<User> getAllMods() {
		
		List<User> Mods = new ArrayList<User>();
		
		for(User user : getAllUser()) {
			
			if(user.getUserType().equals("Moderator")) {
				Mods.add(user);
			}
		}
		return Mods;
	}
	
	
	public static List<User> getAllAdmins() {
		
		List<User> Admin = new ArrayList<User>();
		
		for(User user : getAllUser()) {
			
			if(user.getUserType().equals("Admin")) {
				Admin.add(user);
			}
		}
		return Admin;
	}
	
	
	public static void approveAccount(Integer UserId) {
		
		UserDao dao = new UserDao();
		dao.approveSellerModAccounts(UserId);
	}
	
	
	public static boolean checkApproval(Integer UserId) {
		
		UserDao dao = new UserDao();
		return dao.checkSellerModApproval(UserId);
	}
	
	
	public static void deleteUser(Integer UserId) {
		
		UserDao dao = new UserDao();
		dao.removeUser(UserId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
