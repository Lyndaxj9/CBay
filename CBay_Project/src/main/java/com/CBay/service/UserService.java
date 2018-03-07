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
	
	
	public static List<Integer> getSellerAverageRating(Integer UserId){
			
			UserDao dao = new UserDao();
			List<Integer> avg = new ArrayList<Integer>();
			List<SellerRating> ratings = dao.getSellerRating(UserId);
			
			for (SellerRating r : ratings) {
				
				avg.add(r.getNumRating());
			}
			
			return avg;
		}
	
	
	public static Double calculateAvg(Integer UserId){
		Double sum = 0.0;
		List<Integer> average = getSellerAverageRating(UserId);
		
		for (Integer avg : average) {
			
			sum += avg;
		}
		
		return sum/average.size();
		
	}
	
	
	public static void updateSellerAvg(Integer UserId) {
		
		UserDao dao = new UserDao();
		double avg = new BigDecimal(calculateAvg(UserId)).setScale(3, RoundingMode.HALF_UP).doubleValue();
		System.out.println(avg);
		dao.updateSellerAvg(UserId, avg);
		
	}
}
