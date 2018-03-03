package com.CBay.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.CBay.beans.MessageThread;
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
}
