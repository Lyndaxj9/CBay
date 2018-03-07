package com.CBay.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.CBay.beans.Item;
import com.CBay.beans.ItemRating;
import com.CBay.beans.MessageThread;
import com.CBay.beans.Order;
import com.CBay.beans.SellerRating;
import com.CBay.beans.Transactions;
import com.CBay.beans.User;
import com.CBay.util.HibernateUtil;

public class UserDao {

	public void insertUser(User user){
		
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		//Integer user_id = null;
		try{
			tx = session.beginTransaction();
		
			session.save(user);
			tx.commit();
			
		}catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	public Integer LoginUser(String username, String password, String Type) {
		
		List<User> AllUsers = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try{
			
			tx = session.beginTransaction();
			AllUsers = session.createQuery("FROM User").list();
			
			for (User u : AllUsers) {
				System.out.println(u.getUserName() + " " + u.getPW() + " " + u.getUserType());
				if((u.getUserName().equals(username)) && (u.getPW().equals(password)) && (u.getUserType().equals(Type)))
					return u.getId();
				
			}
			
		}catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		return null;
	}
	
	
	public User getUserById(Integer Id) {
		User user = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try{
			
			tx = session.beginTransaction();
			
			user = (User)session.get(User.class, Id);
			
			
		}catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		return user;
			
		}

	public List<MessageThread> getUserMessageThreads(Integer id) {
		List<MessageThread> threads = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try{
			
			tx = session.beginTransaction();
			String hql = "FROM MessageThread WHERE SenderID= :ID OR ResponderID= :ID";
			Query query = session.createQuery(hql);
			query.setParameter("ID", id);
			threads = query.list();
			return threads;
			
		}catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		return null;
		
	}

	public List<Item> getSellerItems(Integer id) {
		
		List<Item> item = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try{
			
			tx = session.beginTransaction();
			String hql = "FROM Item WHERE UserId = :ID";
			Query query = session.createQuery(hql);
			query.setParameter("ID", id);
			item = query.list();
			return item;
			
		}catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		return null;
	}
	
	public List<Transactions> getUserTransactions(Integer id) {
			
			List<Transactions> tran = null;
			Session session = HibernateUtil.getSession();
			Transaction tx = null;
			
			try{
				
				tx = session.beginTransaction();
				String hql = "FROM Transactions WHERE BuyerId = :ID OR SellerId = :ID";
				Query query = session.createQuery(hql);
				query.setParameter("ID", id);
				tran = query.list();
				return tran;
				
			}catch(HibernateException e){
				if(tx!=null){
					tx.rollback();
				}
				e.printStackTrace();
			}finally{
				session.close();
			}
			return null;
		}
	
	public List<Order> getUserOrder(Integer id) {
		
		List<Order> order = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try{
			
			tx = session.beginTransaction();
			String hql = "FROM Order WHERE buyerId = :ID";
			Query query = session.createQuery(hql);
			query.setParameter("ID", id);
			order = query.list();
			return order;
			
		}catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		return null;
	}
	
	public void changeUserInfo(User UserEdit) {
			
			Session session = HibernateUtil.getSession();
			Transaction tx = null;
			User user = null;
			try{
				tx = session.beginTransaction();
				user = (User)session.get(User.class, UserEdit.getId());
				user.setFirstName(UserEdit.getFirstName());
				user.setLastName(UserEdit.getLastName());
				user.setUserName(UserEdit.getUserName());
				user.setPW(UserEdit.getPW());
				user.setEmail(UserEdit.getEmail());
				user.setDescription(UserEdit.getDescription());
				session.update(user);
				tx.commit();
				
			}catch(HibernateException e){
				if(tx!=null){
					tx.rollback();
				}
				e.printStackTrace();
			}finally{
				session.close();
			}		
	}
	
	
	
	public void addUserRatingAndComment(SellerRating rating) {

		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(rating);
			tx.commit();
			
		}catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	
	public List<SellerRating> getSellerRating(Integer UserId){
		
		List<SellerRating> rating = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try{	
			tx = session.beginTransaction();
			String hql = "FROM SellerRating WHERE UserId= :ID";
			Query query = session.createQuery(hql);
			query.setParameter("ID", UserId);
			rating = query.list();
			return rating;
			
		}catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		return null;
	
	}
	
	
	public void updateSellerAvg(Integer UserId, Double avg) {
			
			Session session = HibernateUtil.getSession();
			Transaction tx = null;
			User user = null;
			try{
				tx = session.beginTransaction();
				user = (User)session.get(Item.class, UserId);
				user.setRatingAvg(avg);
				session.update(user);
				tx.commit();
				
			}catch(HibernateException e){
				if(tx!=null){
					tx.rollback();
				}
				e.printStackTrace();
			}finally{
				session.close();
			}		
	}
		
	
}
